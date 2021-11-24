$(function(){
	tabCount(pNoNumber);

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
       // console.log("상품리뷰 : " + reviewTop);
       // console.log("상품문의 : " + qnaTop);

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
       // console.log(allNum);
       for(let i = 0; i < allNum; i++){
           let numValue = $(".select_list_wrap .list").eq(i).find(".num").val();
           if(numValue <= 1){
               //.select_list_wrap .list .list_num_wrap
               $(".select_list_wrap .list").eq(i).find(".list_num_wrap .minus").addClass("hide");
           }else{
               $(".select_list_wrap .list").eq(i).find(".list_num_wrap .minus").removeClass("hide");
           }

           
           if(numValue >= 10){
               //.select_list_wrap .list .list_num_wrap
               $(".select_list_wrap .list").eq(i).find(".list_num_wrap .plus").addClass("hide");
           }else{
               $(".select_list_wrap .list").eq(i).find(".list_num_wrap .plus").removeClass("hide");
           }
       }
   }

   // 우측 옵션 갯수 이벤트 
   $(".select_list_wrap .list .list_num_wrap > a").click(function(){

       if($(this).hasClass("plus") && !$(this).hasClass("hide")){
           $(this).prev().val(Number($(this).prev().val()) + 1);
       }

       if($(this).hasClass("minus") && !$(this).hasClass("hide")){
           $(this).next().val(Number($(this).next().val()) - 1);
       }

       optionNumChange();
   });

}); 

// 상품정보 위시리스트
function wishListHandler(userNo, pNo){
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
			// console.log(data);
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

