package com.kh.clendy.product.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.clendy.product.model.vo.ProductCart;

@Controller
@RequestMapping("/product/")
public class ProductOrderController {

	/* 결제 페이지 */
	@PostMapping("/order")
	public String orderPage(HttpServletRequest request, @RequestParam int userNo, @RequestParam int pNo) {
		System.out.println("userNo : " + userNo);
		System.out.println("pNo : " + pNo);
		
		String[] pOptionNos = request.getParameterValues("pOptionNo");
		String[] cartAmounts = request.getParameterValues("cartAmount");
		int size = pOptionNos.length;
		
		List<ProductCart> cartList = new ArrayList<>();
		
		for(int i = 0; i < size; i++) {
			ProductCart pc = new ProductCart();
			pc.setpNo(pNo);
			pc.setUserNo(userNo);
			pc.setpOptionNo(Integer.parseInt(pOptionNos[i]));
			pc.setCartAmount(Integer.parseInt(cartAmounts[i]));
			
			cartList.add(pc);
		}
		
		System.out.println(cartList);
		
		
		
		return "product/order";
	}
	
	/* 주문 완료 페이지*/
	@GetMapping("/orderComplete")
	public String orderCompletePage() {
		return "product/order_complete";
	}
}
