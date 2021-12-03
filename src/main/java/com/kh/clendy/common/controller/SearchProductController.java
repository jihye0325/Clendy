package com.kh.clendy.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.clendy.common.model.service.SearchProductService;
import com.kh.clendy.product.model.vo.Product;

@Controller
@RequestMapping("/searchProduct")
public class SearchProductController {
	
	private SearchProductService searchProductService;
	
	@Autowired
	public SearchProductController(SearchProductService searchProductService) {
		this.searchProductService = searchProductService;
	}
	
	@PostMapping("")
	public String searchProductList(@RequestParam String keyword, Model model) {
		
		List<Product> productList = searchProductService.searchProductList(keyword);
		int countNum = searchProductService.countSearchProductList(keyword);
		
		model.addAttribute("productList", productList );
		model.addAttribute("count", countNum);
		model.addAttribute("keyword", '\''+keyword+'\'');
		
		return "common/searchResult";
	}

}
