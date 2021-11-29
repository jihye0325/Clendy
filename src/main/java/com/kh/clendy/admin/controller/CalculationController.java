package com.kh.clendy.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class CalculationController {
	
	@GetMapping("/calculation")
	public void toCalculation() {}

}
