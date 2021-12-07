$(function(){
    reviewSelect(pNoNumber, loginUno, 1);
    
    // 슬라이드
	 var swiper = new Swiper(".mySwiper", {
		  pagination: {
		    loop: true,
		    el: ".slide_page",
		    type: "fraction",
		  },
		  observer: true,
		  observeParents: true
	});
	
	
})

function reviewSelect(pNo, userNo, page){
    if(page == undefined){
        page = 1;
    }

    let dataLimit = {"pNo" : pNo, "userNo": userNo, "page" : page};
   
    $.ajax({
        type : "post",
        url : "/product/reviewAllSelectList",
        contentType : "application/json; charset=utf-8",
        data : JSON.stringify(dataLimit),
        beforeSend : function(xhr){
			xhr.setRequestHeader(header, token);
		},
    }).done(function(fragment){
            $('#review_board').replaceWith(fragment);
    		reviewPagingHandler(pNo, page);
    		tabCount(pNoNumber);
    })
    
};

function reviewPagingHandler(pNo, page){
    let dataLimit = {"pNo" : pNo, "page" : page};
    
    $.ajax({
		type : "post",
		url : "/product/reviewPaging",
		contentType : "application/json; charset=utf-8",
        data : JSON.stringify(dataLimit),
        dataType : "json",
        beforeSend : function(xhr){
			xhr.setRequestHeader(header, token);
		},
        success : function(data){
           paging("item_review", data, "reviewSelect");
        },
        error : function(error){
        	console.log(error);
        }
	})
}

function reviewView(rNo){

	 let dataLimit = {"rNo" : rNo};
	
	$.ajax({
		type : "post",
		url : "/product/reviewView/" + rNo,
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(dataLimit),
		beforeSend : function(xhr){
			xhr.setRequestHeader(header, token);
		},
		success : function(data){
			popOpen("review_view");
			let id = $("#review_view");
			
			id.find(".review_id_text").text(data.member.id);
			
			if(data.openSize == 'Y'){
				id.find(".info").text(data.member.gender + "성-(" + data.member.height + "cm, " + data.member.weight + "kg)");
			}else{
				id.find(".info").text("비공개");
			}
			
			let rCreateDate = new Date(Date.parse(data.rCreateDate))
			id.find('.review_date').text(rCreateDate.getFullYear() + "." + (rCreateDate.getMonth() + 1) + "." + rCreateDate.getDate());
			
			id.find(".review_star").html("");
			for(let i = 1; i <= 5; i++){
				if(i <= data.score ){
					id.find(".review_star").append('<div class="star on"></div>');	
				}else{
					id.find(".review_star").append('<div class="star"></div>');
				}
			}
			
			id.find(".review_option").text(data.pColor + " / " + data.pSize);
			id.find(".review_txt_box").html(data.rContent);
			
			//이미지 수정
			let maxImgSize = 10;
			
			let imgSize = $("#review_view .review_txt_box img").length;
			$('.swiper-slide').remove();
			
			for(let i = 0; i < imgSize; i++){
				let imgSrc = $("#review_view .review_txt_box img").eq(i).attr("src");
				let slideHtml = '<div class="swiper-slide"><img src="'+imgSrc+'"></div>';
				$(".swiper-wrapper").append(slideHtml);
			}
			
			$("#review_view .review_txt_box img").parent().remove();
			
			
		},
		error : function(error){
		
		}
	});
}

function reviewLike(rNo, loginUno, index){
	let dataLimit = {"rNo" : rNo, "loginUno" : loginUno};
	
	$.ajax({
		type : "post",
		url : "/product/reviewLike",
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(dataLimit),
		beforeSend : function(xhr){
			xhr.setRequestHeader(header, token);
		},
		success : function(data){
			if(data == 'insert'){
				$('.review_list').eq(index).find(".review_like").addClass('on');
			}else if(data == 'delete'){
				$('.review_list').eq(index).find(".review_like").removeClass('on');
			}else{
				alertPopup("리뷰 좋아요 실패하였습니다.");
			}
		},
		error : function(error){
			console.log(error);
		}
	})
	
	
}



