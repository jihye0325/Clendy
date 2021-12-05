package com.kh.clendy.sellerAsk.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.clendy.sellerAsk.model.service.SellerAskService;

@Controller
@RequestMapping("/seller")
public class SellerAskController {

	private SellerAskService sellerAskService;

	@Autowired
	public SellerAskController(SellerAskService sellerAskService) {
		this.sellerAskService = sellerAskService;
	}

	@GetMapping("/sellerAsk")
	public void toSellerAsk(Model model, @RequestParam(defaultValue = "1") int page) {

		
		 Map<String, Object> result = sellerAskService.selectAskAllList(page);
		 
		 model.addAttribute("sellerAskList", result.get("sellerAskList"));
		 model.addAttribute("pi", result.get("pageInfo"));
		 
		 System.out.println(result);
		
	}

}
