package com.kh.clendy.reviewboard.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.kh.clendy.product.model.service.ProductReviewService;
import com.kh.clendy.reviewboard.model.service.ReviewService;

@Controller
@RequestMapping("review/review")
public class reviewboardController {
	
	private ReviewService reviewService;
	private ProductReviewService productReviewService;
	
	@Autowired
	public reviewboardController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	//리뷰리스트
	@GetMapping("")
	   public void toReview( @RequestParam(defaultValue="")String keyword, Model  model, @RequestParam(defaultValue="1") int page) {
		
		if(keyword.equals("")) {
			Map<String, Object> result = reviewService.selectReviewAllList(page);	
			model.addAttribute("reviewList",result.get("reviewList"));
			model.addAttribute("pi",result.get("pageInfo"));
			System.out.println("키워드 없음");
			System.out.println("Result"+ model);
			
		}else {
			Map<String, Object> searchResult = reviewService.selectReviewSearchList(keyword,page);
			model.addAttribute("reviewList",searchResult.get("reviewList"));
			model.addAttribute("pi",searchResult.get("pageInfo"));
			System.out.println("키워드 있음");
			System.out.println("dd:"+keyword);
			System.out.println("searchResult"+ model);
		}
		
	}
	
	// 
//		@PostMapping("/reviewLike")
//		public String reviewLike(int rNo) {
//			UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//			
//			int loginUno = user.getUser_no();
//			
//			returnMap.put("loginUno", loginUno);
//			
//			int result = productReviewService.reviewLike(returnMap);
//			
//			}
}


