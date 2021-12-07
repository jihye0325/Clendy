/*
	상품 상세 페이지
	- 상품 문의 관련된 스크립트 
*/

$(function(){

	// 첫 로딩시 작동
	qnaAllSelectList();
	
	// 상품 검색 타입 작동
	$("select[name=qnaType]").change(function(){
	   qnaAllSelectList();
	})
	
	// 비밀글 체크시 작동
	$("#qnaSecret").change(function(){
	   qnaAllSelectList();
	})

});

// 상품문의 글 초기화
function productQnaText(){
   $("#productQna [name=piqSecret] option:eq(0)").prop("selected", true);
   $("#productQna [name=piCateCode] option:eq(0)").prop("selected", true);
   $("#productQna [name=piqTitle]").val('');
   $("#productQna [name=piqContent]").val('');
}

// 상품문의 등록
function qnaInsert(pNo){
   const piqSecret = $("#productQna [name=piqSecret]").val();
   const piCateCode = $("#productQna [name=piCateCode]").val();
   const piqTitle = $("#productQna [name=piqTitle]").val();
   const piqContent = $("#productQna [name=piqContent]").val();
   
   if(piqTitle.length <= 0){
   	alert("제목을 입력해주세요.");
   	return;
   }
   
   if(piqContent.length <= 0){
   	alert("내용을 입력해주세요.");
   	return;
   }
   
   const insertData = {'userNo' : loginUno,'pNo': pNo, 'piqSecret': piqSecret, 'piCateCode': piCateCode, 'piqTitle': piqTitle, 'piqContent': piqContent};
   
   $.ajax({
       type : "post",
       url : "/product/qnaInsert",
       dataType : "text",
       contentType : "application/json; charset=utf-8",
       data : JSON.stringify(insertData),
       beforeSend : function(xhr){
			xhr.setRequestHeader(header, token);
		},
       success : function(data){
           popClose('productQna');
           
           alertPopup("상품 문의글이 등록되었습니다.");
           
           $("#productQna [name=piqSecret] option:eq(0)").prop("selected", true);
           $("#productQna [name=piCateCode] option:eq(0)").prop("selected", true);
           $("#productQna [name=piqTitle]").val('');
           $("#productQna [name=piqContent]").val('');
           
           // 목록 받아오기
           qnaAllSelectList();
       },
       error: function(error){
           console.log(error);
       }
   })
}

// 상품 수정 정보
function qnaModifyView(piqCode){
   $.ajax({
       type : "post",
       data : {"piqCode": piqCode},
       url : "/product/qnaModifyView",
       beforeSend : function(xhr){
			xhr.setRequestHeader(header, token);
		},
       success : function(data){
           // select, input 값 세팅
           const secretSize = $("#productQna [name=piqSecret] option").length;
           const codeSize = $("#productQna [name=piCateCode] option").length;
           
           for(let i = 0; i < secretSize; i++){
               if($("#productQna [name=piqSecret] option").eq(i).val() == data.piqSecret){
                   $("#productQna [name=piqSecret] option").eq(i).prop("selected", true);
               }
           }
           
           for(let i = 0; i < codeSize; i++){
               if($("#productQna [name=piCateCode] option").eq(i).val() == data.piCateCode){
                   $("#productQna [name=piCateCode] option").eq(i).prop("selected", true);
               }
           }

              $("#productQna [name=piqTitle]").val(data.piqTitle);
              $("#productQna [name=piqContent]").val(data.piqContent);
              
              popOpen('productQna', 'modify', piqCode);
           
       },
       error : function(error){
           console.log(error);
       }
   })
}

// 상품문의 수정
function qnaModify(piqCode){
   const piqSecret = $("#productQna [name=piqSecret]").val();
   const piCateCode = $("#productQna [name=piCateCode]").val();
   const piqTitle = $("#productQna [name=piqTitle]").val();
   const piqContent = $("#productQna [name=piqContent]").val(); 
   
    if(piqTitle.length <= 0){
	   	alert("제목을 입력해주세요.");
	   	return;
   	}
   
   if(piqContent.length <= 0){
	   	alert("내용을 입력해주세요.");
	   	return;
   }
   
   const insertData = {'piqCode': piqCode, 'piqSecret': piqSecret, 'piCateCode': piCateCode, 'piqTitle': piqTitle, 'piqContent': piqContent};
   
   $.ajax({
       type : "post",
       url : "/product/qnaModify",
       dataType : "text",
       contentType : "application/json; charset=utf-8",
       data : JSON.stringify(insertData),
       beforeSend : function(xhr){
			xhr.setRequestHeader(header, token);
		},
       success : function(data){
           if(data == 'success'){
               popClose('productQna');
               alertPopup("상품 문의글이 수정 되었습니다.");
           }else if(data == 'fail'){
               popClose('productQna');
               alertPopup("상품 문의글이 수정 실패 하였습니다.");
           }
           // 목록 받아오기
           qnaAllSelectList();
           
       },
       error : function(error){
           console.log(error);
       }
       
   })
}

// 상품문의 삭제
function qnaDelete(piqCode){
   if(confirm("상품 문의글을 삭제하시겠습니까?")){
       $.ajax({
           type : "post",
           url : "/product/qnaDelete",
              dataType : "text",
           contentType : "application/json; charset=utf-8",
           data : JSON.stringify(piqCode),
           beforeSend : function(xhr){
				xhr.setRequestHeader(header, token);
			},
           success : function(data){
               
               if(data == 'success'){
                   popClose('productQna');
                      alertPopup("상품 문의글이 삭제 되었습니다.");
               }else{
                   popClose('productQna');
                      alertPopup("상품 문의글 삭제 실패 하였습니다.");
               }
               
               // 목록 받아오기
               qnaAllSelectList();
           },
           error : function(error){
               console.log(error);
           }
           
       })	
   }
}

// 상품문의 목록(ajax)
function qnaAllSelectList (page){
	

   if(page == undefined){
   		page = 1
   }
   let qnaType = $("select[name=qnaType] option:selected").val();
   let secretCheck = $("#qnaSecret").is(":checked");
   
   let dataLimit = {"page": page, "qnaType": qnaType, "secretCheck": secretCheck, "pNo": pNoNumber, "loginUno" : loginUno };
   
   $.ajax({
       type : "post",
       url : "/product/qnaAllSelectList",
       contentType : "application/json; charset=utf-8",
       data : JSON.stringify(dataLimit),
       beforeSend : function(xhr){
			xhr.setRequestHeader(header, token);
		}
   }).done(function(fragment,){
   		$('#view_qna').replaceWith(fragment);
   })
   
   //페이징 전달
   pagingHandler("item_qna",dataLimit);
   tabCount(pNoNumber);
}

