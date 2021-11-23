package com.kh.clendy.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("/storeList")
	public void toStore() {}
	
	@GetMapping("/manageStore")
	public void toManageStore() {}
	
	@GetMapping("/calculation")
	public void toCalculation() {}
	
	@GetMapping("/coupon")
	public void toCoupon() {}

}
