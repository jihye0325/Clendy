package com.kh.clendy.product.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.member.model.vo.UserImpl;
import com.kh.clendy.mypage.model.vo.Coupon;
import com.kh.clendy.product.model.service.ProductOrderService;
import com.kh.clendy.product.model.vo.Order;
import com.kh.clendy.product.model.vo.ProductCart;

@Controller
@RequestMapping("/product/")
public class ProductOrderController {
	
	private ProductOrderService productOrderService;
	
	public ProductOrderController(ProductOrderService productOrderService) {
		this.productOrderService = productOrderService;
	}

	/* 결제 페이지 */
	@PostMapping("/order")
	public String orderPage(HttpServletRequest request, @RequestParam int userNo, @RequestParam int pNo, @RequestParam int sellerCode,  Model model) {
		
		String[] pOptionNos = request.getParameterValues("pOptionNo");
		String[] cartAmounts = request.getParameterValues("cartAmount");
		
		int size = pOptionNos.length;
		
		List<ProductCart> cartList = new ArrayList<>();
		
		for(int i = 0; i < size; i++) {
			ProductCart pc = new ProductCart();
			pc.setSellerCode(sellerCode);
			pc.setpNo(pNo);
			pc.setUserNo(userNo);
			pc.setpOptionNo(Integer.parseInt(pOptionNos[i]));
			pc.setCartAmount(Integer.parseInt(cartAmounts[i]));
			
			cartList.add(pc);
		}
		
		// 배송정보
		Member member = productOrderService.orderMemberSelect(userNo);
		
		// 주문내역
		Map<String, List<ProductCart>> cartMap = new HashMap<>();
		List<ProductCart> list = new ArrayList<>();
		for(ProductCart pc : cartList) {
			if(cartMap.containsKey(pc.getSellerCode() + "")) {
				list = cartMap.get(pc.getSellerCode() + "");
				list.add(pc);
			}else {
				list.add(pc);
			}
			cartMap.put(pc.getSellerCode() + "", list);
		}
		
		Map<String, List<Order>> orderInfo = productOrderService.orderInfoSelect(cartMap);
		
		// 포인트 정보
		int point = productOrderService.orderPointSelect(userNo);
		
		// 쿠폰리스트
		// List<Coupon> couponList = productOrderService.orderCouponSelectList(userNo);
		// System.out.println(couponList);
		
		// 결제금액 정보
		System.out.println(orderInfo);
		Map<String, Integer> payPrice = new HashMap<>();
		
		int productPrice = 0;	 // 상품금액
		int productPost = 0;	 // 배송금액
		
		for(String key : orderInfo.keySet()) {
			int price = 0;
			
			for(Order order : orderInfo.get(key)) {
				productPrice += (order.getpPrice() - (order.getpPrice() * (order.getpDiscount() / 100.0))) * order.getCartMount();
				price += (order.getpPrice() - (order.getpPrice() * (order.getpDiscount() / 100.0))) * order.getCartMount();
			}
			
			if(price <= 80000) {
				productPost += 2500;
			}
		}
		
		payPrice.put("productPrice", productPrice);
		payPrice.put("productPost", productPost);
		
		model.addAttribute("postMember", member);
		model.addAttribute("orderInfo", orderInfo);
		model.addAttribute("point", point);
		// model.addAttribute("couponList", couponList);
		model.addAttribute("payPrice", payPrice);

		return "product/order";
	}
	
	/* 주문 결제 검증 */
	@PostMapping("/orderPay")
	@ResponseBody
	public String order(@RequestBody Map<String, Object> parameters) {
		
		System.out.println(parameters);
		
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userNo = user.getUser_no();
		int amount = Integer.parseInt(((String)parameters.get("amount")).replace(",", ""));
		int postPrice = Integer.parseInt(((String)parameters.get("postPrice")).replace(",", ""));
		
		parameters.put("userNo", userNo);
		parameters.put("postPrice", postPrice);
		parameters.put("amount", amount);
		
		int result = productOrderService.order(parameters);
		
		return "success";
	}
	
	/* 주문 완료 페이지*/
	@GetMapping("/orderComplete")
	public String orderCompletePage() {
		return "product/order_complete";
	}
}

