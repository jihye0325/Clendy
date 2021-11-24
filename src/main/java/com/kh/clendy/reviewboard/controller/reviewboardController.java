package com.kh.clendy.reviewboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class reviewboardController {
	
	@GetMapping(value = {"/reviewboard"})
	   public String main() {
	      return "reviewboard/reviewboard";
	   }

}


