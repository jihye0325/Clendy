package com.kh.clendy.reviewboard.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kh.clendy.reviewboard.model.service.ReviewService;

@Controller
@RequestMapping("review/reviewSearch")
public class reviewSearchController {
	
	private ReviewService reviewService;
	
	@Autowired
	public reviewSearchController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	//리뷰리스트
	@GetMapping("")
	   public void toReview(String keyword,Model  model) {
		
			Map<String, Object> result = reviewService.selectReviewSearchList(keyword);	
			model.addAttribute("reviewList",result.get("reviewList"));
		
		
		}
		
	}
	
	

