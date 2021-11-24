package com.kh.clendy.reviewboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reviewboard")
public class reviewboardController {
	
	@GetMapping("/reviewboard")
	public void toReviewboard() {}

}
