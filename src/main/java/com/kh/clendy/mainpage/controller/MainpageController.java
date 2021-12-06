package com.kh.clendy.mainpage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.clendy.mainpage.model.service.MainpageService;
import com.kh.clendy.mainpage.model.vo.MainProduct;

@Controller
public class MainpageController {
	private MainpageService mainpageService;

	@Autowired
	public MainpageController(MainpageService mainpageService) {
		this.mainpageService = mainpageService;
	}

	@GetMapping(value = { "/", "/mainpage" })
	public String main(Model model) {
		List<MainProduct> mainProductList = mainpageService.selectMainProdudct();
		model.addAttribute("mainProductList", mainProductList);
		System.out.println("11: " + model);
		return "mainpage/mainpage";
	}

	

	@PostMapping(value = "/")
	public String redirectMain() {
		return "redirect:/";
	}
}
