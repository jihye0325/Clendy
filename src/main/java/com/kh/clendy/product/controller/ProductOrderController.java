package com.kh.clendy.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product/")
public class ProductOrderController {

	/* 결제 페이지 */
	@GetMapping("/order")
	public String orderPage() {
		return "product/order";
	}
	
	/* 주문 완료 페이지*/
	@GetMapping("/orderComplete")
	public String orderCompletePage() {
		return "product/order_complete";
	}
}
