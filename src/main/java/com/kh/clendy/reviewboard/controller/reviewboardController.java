package com.kh.clendy.reviewboard.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.clendy.reviewboard.model.service.ReviewService;

@Controller
@RequestMapping("review/review")
public class reviewboardController {
	
	private ReviewService reviewService;
	
	@Autowired
	public reviewboardController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	//리뷰리스트
	@GetMapping("")
	
	   public void toReview( @RequestParam(defaultValue="")String keyword, Model  model, @RequestParam(defaultValue="1") int page) {
		
//		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		int user_no = user.getUser_no();
//		System.out.println("111"+user_no);
		System.out.println("123123:"+keyword);
		
		Map<String, Object> result = reviewService.selectReviewAllList(keyword, page);
		//리뷰 리스트
		//List<Review> reviewList = reviewService.selectReviewAllList(page);
	
		
		model.addAttribute("reviewList",result.get("reviewList"));
		model.addAttribute("pi",result.get("pageInfo"));
	
		
		System.out.println("그냥:"+result);
		
	}	
	
}


