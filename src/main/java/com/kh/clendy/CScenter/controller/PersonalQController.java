package com.kh.clendy.CScenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/CScenter/personalQ")
public class PersonalQController {
	
	
	@GetMapping("")
	public void toPersonalQ() {}

}
