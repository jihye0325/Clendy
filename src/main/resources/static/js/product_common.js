
/*
	상품 페이지의 공통 스크립트
	1. 페이징
	2. 팝업 열기, 닫기
*/
// csrf 변수
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

// 페이징 공통
function pagingHandler(id, cmObject){
	$.ajax({
		type : "post",
		url : "/product/paging",
		contentType : "application/json; charset=utf-8",
        data : JSON.stringify(cmObject),
        dataType : "json",
        beforeSend : function(xhr){
			xhr.setRequestHeader(header, token);
		},
        success : function(data){
           paging(id, data, "qnaAllSelectList");
        },
        error : function(error){
        	console.log(error);
        }
	})
}

// 페이징 배치
function paging(id, data, link){

	if(data.listCount == 0){
	   $("#" + id + " .pagaing_wrap").hide();
	}else{
		$("#" + id + " .pagaing_wrap").show();
	}

	$("#" + id + " .pagaing_num").html('');
	
   // 페이징 좌측
   if(data.page <= 1){
   		$("#" + id + " .pagaing_left").html('');
	   	$("#" + id + " .pagaing_left").html('<li class="allPrev hide"><a href="javascript:;"></a></li><li class="prev hide"><a href="javascript:;"></a></li>');
   }else{
   		$("#" + id + " .pagaing_left").html('');
   	
   		if(id == 'item_qna'){
   			$("#" + id + " .pagaing_left").html('<li class="allPrev"><a href="javascript:' + link +'(1);"</a></li><li class="prev"><a href="javascript:' + link  + '(' + (data.page - 1) +');"></a></li>');
   		}else if(id == 'item_review'){
   			$("#" + id + " .pagaing_left").html("<li class='allPrev'><a href='javascript:" + link + "("+ pNoNumber + ", " + loginUno +" ," + (1) + ");'></a></li><li class='prev'><a href='javascript:" + link + "("+ pNoNumber + ", " + loginUno +" ," + (data.page - 1) + ");'></a></li>");
   		}
   		
   }
   
    // 페이징 우측
   if(data.page >= data.maxPage){
   		$("#" + id + " .pagaing_right").html('');
   		$("#" + id + " .pagaing_right").html('<li class="next hide"><a href="javascript:;"></a></li><li class="allNext hide"><a href="javascript:;"></a></li>')
   }else{
   		$("#" + id + " .pagaing_right").html('');
   		
   		if(id == 'item_qna'){
   			$("#" + id + " .pagaing_right").html('<li class="next"><a href="javascript:' + link +'(' + (data.page + 1) + ');"</a></li><li class="allNext"><a href="javascript:' + link  + '(' + (data.endPage) +');"></a></li>')

   		}else if(id == 'item_review'){
   			$("#" + id + " .pagaing_right").html("<li class='next'><a href='javascript:" + link + "("+ pNoNumber + ", " + loginUno +" ," + (data.page + 1) + ");'></a></li><li class='allNext'><a href='javascript:" + link + "("+ pNoNumber + ", " + loginUno +" ," + (data.endPage) + ");'></a></li>");
   		}
   		
   		
   		
   }
	
   // 페이징 숫자
   for(let i = data.startPage; i <= data.endPage; i++){
       if(i == data.page){
       		if(id == 'item_qna'){
	           $("#" + id + " .pagaing_num").append("<li class='on'><a href='javascript:" + link + "("+ i +");'>" + i +"</a></li>");
       		}else if(id == 'item_review'){
       		   $("#" + id + " .pagaing_num").append("<li class='on'><a href='javascript:" + link + "("+ pNoNumber + ", " + loginUno +" ," + i + ");'>" + i +"</a></li>");
       		
       		}
       
       }else{
       		if(id == 'item_qna'){
	           $("#" + id + " .pagaing_num").append("<li><a href='javascript:" + link + "("+ i +");'>" + i +"</a></li>");
       		}else if(id == 'item_review'){
       		   $("#" + id + " .pagaing_num").append("<li><a href='javascript:" + link + "("+ pNoNumber + ", " + loginUno +" ," + i + ");'>" + i +"</a></li>");
       		
       		}
       
       
       }
   }
}

// 팝업 닫기
function popClose(id){
   $('#' + id).removeClass("show");
}

// 팝업 열기
function popOpen(id, parameter, piqCode){
   if(parameter == "insert"){
       productQnaText();
       $('#productQna').removeClass("qnaModify");
       $('#productQna').addClass("qnaInsert");
       $('#productQna .layout_head .title').text("상품문의 등록");
       $("#productQna.qnaInsert a.active").attr("href","javascript:qnaInsert("+ pNoNumber +")");
       
   }else if(parameter == "modify"){
       $('#productQna').removeClass("qnaInsert");
       $('#productQna').addClass("qnaModify");
       $('#productQna .layout_head .title').text("상품문의 수정");
       $("#productQna.qnaModify a.active").attr("href","javascript:qnaModify("+ piqCode +")");
   }
   
   $('#' + id).addClass("show");
}