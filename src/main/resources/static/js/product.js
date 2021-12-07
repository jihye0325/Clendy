let maxNumber;
let optionNoArr = [];
let dataSource;

$(function(){
	

	tabCount(pNoNumber);
	options(pNoNumber);
	
    // 상품문의 상세 이벤트
   $(document).on("click", ".qna_list .line .line_box > p.line_title a",function(){
       if(!$(this).parent().hasClass("secret")){
           if($(this).parents(".line").hasClass("on")){
               $(this).parents(".line").find(".line_qna_box").stop().slideUp();
               $(this).parents(".line").removeClass("on");
           }else{
               $(this).parents(".line").find(".line_qna_box").stop().slideDown();
               $(this).parents(".line").addClass("on");
           }	
       }
   });	
   
   let currentScroll = $(document).scrollTop();

   let pvTop = $('#product_view').offset().top;
   let menuTop = $('.view_main_wrap .view_tab_wrap').offset().top;

   $(document).scroll(function(){
       currentScroll = $(document).scrollTop();
       optionScroll(currentScroll);
       menuScroll(currentScroll);
       menuActiveScroll(currentScroll);
   });

   optionScroll(currentScroll);
   menuScroll(currentScroll);
   menuActiveScroll(currentScroll);

   // 우측 옵션 스크롤 이벤트
   function optionScroll(currentScroll){
       if(pvTop <= currentScroll){
               $(".view_sub_wrap .box_wrap").addClass("fixed");
       }else{
           $(".view_sub_wrap .box_wrap").removeClass("fixed");
       }
   }

   // 상세 메뉴탭 스크롤 이벤트
   function menuScroll(currentScroll){
       if(menuTop + 25 <= currentScroll){
           $(".view_main_wrap .view_tab_wrap").addClass("fixed");
       }else{
           $(".view_main_wrap .view_tab_wrap").removeClass("fixed");
       }
   }

   // 상세 메뉴탭 하이라이트 스크롤 이벤트
   function menuActiveScroll(currentScroll){
       // 각 탭에 대한 top값 저장하기
       let reviewTop = $("#item_review").offset().top - 60; // 상품리뷰
       let qnaTop = $("#item_qna").offset().top - 60; // 상품문의
       let infoTop = $("#item_info").offset().top - 60; // 기본정보

       // 스크롤 이벤트시 조건 에맞을시 on 클래스 추가/삭제
       $(".view_tab_wrap .tab_box a").removeClass("on");
       if($(window).scrollTop() + $(window).height() == $(document).height()){
           $(".view_tab_wrap .tab_box a").eq(3).addClass("on");
       }else if(currentScroll >= infoTop){
           $(".view_tab_wrap .tab_box a").eq(3).addClass("on");
       }else if(currentScroll >= qnaTop){
           $(".view_tab_wrap .tab_box a").eq(2).addClass("on");
       }else if(currentScroll >= reviewTop){
           $(".view_tab_wrap .tab_box a").eq(1).addClass("on");
       }else{
           $(".view_tab_wrap .tab_box a").eq(0).addClass("on");
       }
   }

   // 상세 메뉴탭 클릭 이벤트
   $(".tab_box a").click(function(){
       let detailTop = $(".view_tab_wrap").offset().top; // 상품상세
       let reviewTop = $("#item_review").offset().top - 40; // 상품리뷰
       let qnaTop = $("#item_qna").offset().top - 40; // 상품문의
       let infoTop = $("#item_info").offset().top - 40; // 기본정보
       let index = $(this).index();
       let target = 0;

       switch(index){
           case 0 : target = detailTop; break;
           case 1 : target = reviewTop; break;
           case 2 : target = qnaTop; break;
           case 3 : target = infoTop; break;
       }

       $('html,body').animate({scrollTop: target}, 500);
   });

   // 우측 옵션 갯수 이벤트
   optionNumChange();
   function optionNumChange(){
       let allNum = $(".select_list_wrap .list").length;
       for(let i = 0; i < allNum; i++){
           let numValue = $(".select_list_wrap .list").eq(i).find(".num").val();
           if(numValue <= 1){
               //.select_list_wrap .list .list_num_wrap
               $(".select_list_wrap .list").eq(i).find(".list_num_wrap .minus").addClass("hide");
           }else{
               $(".select_list_wrap .list").eq(i).find(".list_num_wrap .minus").removeClass("hide");
           }
           
           if(numValue >= maxNumber){
               //.select_list_wrap .list .list_num_wrap
               $(".select_list_wrap .list").eq(i).find(".list_num_wrap .plus").addClass("hide");
           }else{
               $(".select_list_wrap .list").eq(i).find(".list_num_wrap .plus").removeClass("hide");
           }
       }

   }

   // 우측 옵션 갯수 이벤트 
   $(document).on('click', '.select_list_wrap .list .list_num_wrap > a', function(){

       if($(this).hasClass("plus") && !$(this).hasClass("hide")){
           $(this).prev().val(Number($(this).prev().val()) + 1);
       }

       if($(this).hasClass("minus") && !$(this).hasClass("hide")){
           $(this).next().val(Number($(this).next().val()) - 1);
       }

       optionNumChange();
       priceHanlder(dataSource);
   });

}); 

// 상품정보 위시리스트
function wishListHandler(userNo, pNo){
	
	// 비로그인 일시
	annoLogin();
	if(loginUno == -1) return;
	
	
	let wishList = {"userNo": userNo, "pNo": pNo};
	
	$.ajax({
		type : "post",
		url : "/product/wishStatus",
		contentType : "application/json; charset=utf-8",
		data: JSON.stringify(wishList),
		dataType : "text",
		beforeSend : function(xhr){
			xhr.setRequestHeader(header, token);
		},
		success : function(data){

			if(data == 'insert'){
				$(".view_txt_wrap .btn_wish").addClass("on");
			}else if(data == 'delete'){
				$(".view_txt_wrap .btn_wish").removeClass("on");			
			}
		},
		error : function(error){
			console.log(error);
		}
	});
}

// 상품옵션 정보
function options(pNo){
	let dataLimit = {"pNo" : pNo};
	$.ajax({
		type : "post",
		url : "/product/options",
		data: JSON.stringify(dataLimit),
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		beforeSend : function(xhr){
			xhr.setRequestHeader(header, token);
		},
		success : function(data){
			option(data);
			priceHanlder(data);
			dataSource = data;
		},
		error : function(error){
			console.log(error);
		}
	})
}

// 옵션
function option(data){
	const keySize = Object.keys(data).length;
	
	$("select[name=optionColor]").find("option").remove();
	// 색상 세팅
	for(let i = 0; i <= keySize; i++){
		if(i == 0){
			$("select[name=optionColor]").append("<option value='colorChoice'>색상 선택</option>");
		}else{
			let key = Object.keys(data)[i - 1];
			$("select[name=optionColor]").append("<option value='" + key + "'>" + key + "</option>");
			
		}
	}
	
	// 옵션 이벤트
	$('select[name=optionColor]').change(function(){
	
		// 박스가 이미 추가되어있는지 확인
		const boxSize = $(".select_list_wrap .list").length;
		let optionNoArr = [];

		for(let i = 0; i < boxSize; i++){
			let num = $(".select_list_wrap .list").eq(i).find("[name=pOptionNo]").val();
			optionNoArr.push(Number(num));
		}
		
		
		$("select[name=optionSize] option").remove();
		$("select[name=optionSize]").append("<option value='sizeChoice'>사이즈 선택</option>");
	
		let val = $(this).val();
		if(val == 'colorChoice'){
			$('select[name=optionSize]').attr("disabled", "true");
		}else{
			$('select[name=optionSize]').removeAttr("disabled");
			const sizeKeySize = Object.keys(data[val]).length;
			for(let i = 0; i < sizeKeySize; i++){
				let key = Object.keys(data)[i];
				
				
				if(optionNoArr.indexOf(data[val][i].pOptionNo) == -1){
					$("select[name=optionSize]").append("<option value='" + data[val][i].pOptionNo + "'>"+ data[val][i].pSize + " 재고(" + data[val][i].pStock + "개)</option>");
				}else{
					$("select[name=optionSize]").append("<option disabled value='" + data[val][i].pOptionNo + "'>"+ data[val][i].pSize + " 재고(" + data[val][i].pStock + "개)</option>");
				}
			}
			
			optionBox(data);
		}
	});

}

function optionBox(data){
	// 옵션 박스 추가
	$("select[name=optionSize]").change(function(){
		let val = $(this).val();

		let colorKey = $("select[name=optionColor]").val();
		const keySize = Object.keys(data[colorKey]).length;
		let product;
		
		if(val != 'sizeChoice'){
			
		
			for(let i = 0; i < keySize; i++){
				if(val == data[colorKey][i].pOptionNo) {
					product = data[colorKey][i];
	
				}
			}		
		
			let html = `<div class="list">
							<input type='hidden' name="pOptionNo" value='${product.pOptionNo}'>
                            <p class="title">${product.pColor} / ${product.pSize}</p>
                            <a href="javascript:;" class="close"></a>
                            <div class="list_bot">
                                <div class="list_num_wrap">
                                    <a href="javascript:;" class="minus hide"></a>
                                    <input type="number" name="cartAmount" id="" value="1" min="1" max="${product.pStock}" class="num" readonly>
                                    <a href="javascript:;" class="plus"></a>
                                </div>
                                <p class="price">
                                    <span>${(product.pPrice - (product.pPrice * product.pDiscount / 100)).toLocaleString('ko-KR')}</span>원
                                </p>
                            </div>
                        </div>`;
                   
           $(".select_list_wrap").append(html);
           maxNumber = product.pStock;
		}
		$("select[name=optionSize] option").eq(0).attr("selected", "selected");
		$("select[name=optionSize]").attr("disabled", true);
		options(pNoNumber);
	});

}


// 탭메뉴 갯수
function tabCount(pNo){
	$.ajax({
		type : "post",
		url : "/product/tabCount",
		data: {"pNo" : pNo},
		dataType : "json",
		beforeSend : function(xhr){
			xhr.setRequestHeader(header, token);
		},
		success : function(data){
			$('.view_tab_wrap .tab_box a').eq(1).find('span').text(data.REVIEW_COUNT);
			$('.view_tab_wrap .tab_box a').eq(2).find('span').text(data.INQUIRY_COUNT);
			
		},
		error : function(error){
			console.log(error);
		}
	})
}

// 옵션 목록 삭제
$(document).on('click', '.list .close', function(){
	$(this).parent('.list').remove();
	priceHanlder(dataSource);
})

// 선택 상품 계산
function priceHanlder(data){

	const key = Object.keys(data)[0];
	let onePrice = data[key][0].pPrice - (data[key][0].pPrice * data[key][0].pDiscount / 100);
	let count = 0; // 총 물품 갯수
	let allPrice = 0;	// 총 물품 가격
	
	let list = $(".select_list_wrap .list");
	
	for(let i = 0; i < list.length; i++){
		count += Number(list.eq(i).find('.num').val());
	}
	
	allPrice = onePrice * count;
	
	$(".list_total_wrap .title span").text(count);
	$(".list_total_wrap .price span").text(allPrice.toLocaleString('ko-KR'));
}

// 장바구니 이벤트
function productCartHandler(){

	annoLogin()
	if(loginUno == -1) return;

	let count = $('.select_list_wrap .list').length;
	let frm = document.forms['productFrm'];

	if(count > 0){
		frm.method = "GET";
		frm.action = "/product/cartInsert";
		frm.submit();

	}else{
		alert("상품 옵션을 추가해주세요.");
	}
}

// 구매하기 이벤트
function productBuyHandler(){

	annoLogin()
	if(loginUno == -1) return;

	let count = $('.select_list_wrap .list').length;
	let frm = document.forms['productFrm'];
	if(count > 0){
		// $('name=productFrm').attr("method", "post");
		// $('name=productFrm').attr("action", buy);
		frm.submit();

	}else{
		alert("상품 옵션을 추가해주세요.");
	}
}

// 팝업 알림
function alertPopup(pMsg){
	$(".layout_title").text(pMsg);
	popOpen('alertPopup');
	setTimeout(() => {
		popClose('alertPopup');
	}, 3000);
}

// 비로그인시
function annoLogin(){
	if(loginUno == -1){
		let result = confirm("로그인후 이용해주세요. 로그인페이지로 이동하시겠습니까?");
		if(result){
			location.href="/member/login";
		}
		
		return;
	}
}
