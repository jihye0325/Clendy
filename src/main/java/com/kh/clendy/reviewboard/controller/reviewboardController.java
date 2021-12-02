package com.kh.clendy.reviewboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.clendy.CScenter.model.vo.FAQ;
import com.kh.clendy.reviewboard.model.service.ReviewService;
import com.kh.clendy.reviewboard.model.vo.Review;

@Controller
@RequestMapping("/review")
public class reviewboardController {
	
	private ReviewService reviewService;
	
	@Autowired
	public reviewboardController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@GetMapping("/review")
	   public void toReview(Model model) {
		List<Review> reviewList = reviewService.selectReviewAllList();
		
		model.addAttribute("reviewList",reviewList);
		
		System.out.println(reviewList);
	}
	      
	@PostMapping("/review/search")
	public String searchReviewKeyword(String keyword, Model model) {
		System.out.println("!" + keyword);
		List<Review> resultList = reviewService.searchReviewByKeyword(keyword);
				
		model.addAttribute("reviewList",resultList);
		System.out.println(resultList);
		
		
		return "/review/review";
	}
	
}


