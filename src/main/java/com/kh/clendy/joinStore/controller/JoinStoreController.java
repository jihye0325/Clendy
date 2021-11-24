package com.kh.clendy.joinStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.clendy.joinStore.model.vo.ApplyStore;

@Controller
@RequestMapping("/common")
public class JoinStoreController {
	
	@GetMapping("joinStore")
	public void toJoinStore() {}
	
	@PostMapping("joinStore")
	public String applyStore(ApplyStore newStore) {
		
		
		return "redirect:/common/joinStore";
	}
	
	

}
