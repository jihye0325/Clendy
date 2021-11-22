package com.kh.clendy.product.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.clendy.product.model.service.ProductService;
import com.kh.clendy.product.model.vo.Product;

@Controller
@RequestMapping("/product/")
public class ProductController {
	
	private static final Log LOG = LogFactory.getLog( ProductController.class );
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	// type = 공용, 남성, 여성 카테고리 들어감
	// 상품 목록
	@GetMapping("/list/{type}")
	public String productListPage(@PathVariable String type, Model model, @RequestParam(defaultValue = "1") int page) {
		
		Map<String, Object> mapReturn = productService.productSelectList(page);
		
		// 상품 목록
		model.addAttribute("productList", mapReturn.get("productList"));
		// 페이징
		model.addAttribute("pi", mapReturn.get("pageInfo"));
		
		return "product/product_list";
	}
	
	// 상품 상세(상품번호)
	@GetMapping("/view/{pNo}")
	public String productViewPage(@PathVariable String pNo, Model model) {
		int userNo = 1; // 유저번호 임시 지정
		
		Map<String, Object> mapInfo = new HashMap<>();
		mapInfo.put("pNo", pNo);
		mapInfo.put("userNo", userNo);
		
		Product productInfo = productService.productViewInfo(mapInfo);
		// System.out.println(productInfo);
		
		model.addAttribute("info", productInfo);
		
		return "product/product_view";
	}
	
	// 상품 상세 - 위시리스트
	@PostMapping("/wishStatus")
	@ResponseBody
	public String productViewWish(@RequestBody Map<String, Integer> returnMap) {
		
		int result = productService.productViewWish(returnMap);
		System.out.println(result);
		
		String msg = "fail";
		
		switch(result) {
			case 0 : msg = "insert"; break;
			case 1 : msg = "delete"; break;
		}
		
		return msg;
	}
	
}
