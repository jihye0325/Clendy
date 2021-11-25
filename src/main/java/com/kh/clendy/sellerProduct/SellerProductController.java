package com.kh.clendy.sellerProduct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seller")
public class SellerProductController {
	
	@GetMapping("/index")
	public void toIndex() {}
	
	@GetMapping("/sub02")
	public void toSub02() {}
	
	@GetMapping("/sub03")
	public void toSub03() {}
	
	@GetMapping("/sub04")
	public void toSub04() {}
	
	@GetMapping("/sub05")
	public void toSub05() {}
	
	@GetMapping("/sub06")
	public void toSub06() {}
	
	@GetMapping("/sub07")
	public void toSub07() {}
}