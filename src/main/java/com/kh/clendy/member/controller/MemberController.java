package com.kh.clendy.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.clendy.member.model.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/login")
	public void loginForm() {}
	
	@GetMapping("/memberJoinForm")
	public void JoinForm() {}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}













