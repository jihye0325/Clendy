$(function(){
	// console.log(pNoNumber)
    reviewSelect(pNoNumber, 1);
})

function reviewSelect(pNo, userNo, page){
    if(page == undefined){
        page = 1;
    }

    // userNo는 임시로 사용
    let dataLimit = {"pNo" : pNo, "userNo": userNo, "page" : page};
    // console.log(dataLimit);
   
    $.ajax({
        type : "post",
        url : "/product/reviewAllSelectList",
        contentType : "application/json; charset=utf-8",
        data : JSON.stringify(dataLimit),
    }).done(function(fragment){
            $('#review_board').replaceWith(fragment);
    		reviewPagingHandler(pNo, page);
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
		success : function(data){
			popOpen("review_view");
			console.log(data);
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
			id.find(".review_txt_box").text(data.rContent);
			
			
			
		},
		error : function(error){
		
		}
	});


}

