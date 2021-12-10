package com.kh.clendy.sellerAsk.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.clendy.CScenter.model.vo.FAQ;
import com.kh.clendy.member.model.vo.UserImpl;
import com.kh.clendy.sellerAsk.model.service.SellerAskService;
import com.kh.clendy.sellerAsk.model.vo.SellerAsk;

@Controller
@RequestMapping("seller/sellerAsk")
public class SellerAskController {

	private SellerAskService sellerAskService;

	@Autowired
	public SellerAskController(SellerAskService sellerAskService) {
		this.sellerAskService = sellerAskService;
	}

	@GetMapping("")
	public void toSellerAsk(Model model, @RequestParam(defaultValue = "1") int page) {
		
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		 Map<String, Object> result = sellerAskService.selectAskAllList(page,user_no);
		 
		 model.addAttribute("selectAskAllList", result.get("selectAskAllList"));
		 model.addAttribute("pi", result.get("pageInfo"));
		 		
	}
	
	@GetMapping("/detail")
	public void toSellerDetail() {}
	
	
	


}
