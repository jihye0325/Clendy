package com.kh.clendy.mainpage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainpageController {
	
	@GetMapping(value = {"/mainpage"})
	   public String main() {
	      return "mainpage/mainpage";
	   }

	@PostMapping(value="/")
	   public String redirectMain() {
	      return "redirect:/";
	   }
}
