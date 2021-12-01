package com.kh.clendy.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.clendy.member.model.service.MemberService;
import com.kh.clendy.member.model.vo.Member;

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
	
	@PostMapping("/loginfail")
	public String loginfail() {
		return "member/login";
	}
	
	@GetMapping("/signUp")
	public void signUpForm() {}
	
	@PostMapping("/signUp")	
	public String signUp(Member member, HttpServletRequest request) {
		String rec_id = request.getParameter("recommender");
		
		memberService.signUp(member, rec_id);
		
		return "redirect:/";
	}
	
	@GetMapping("/deletePage")
	public void deletePage() {}
	
	@GetMapping("/findId")
	public void findId() {}
	
	@PostMapping("/findId")
	public String findId(HttpServletRequest request, Member member) {
		String id = memberService.findId(member.getUser_name(), member.getPhone());
		
		if(id == null) {
			request.setAttribute("noId", "noId");
			return "member/findId";
		} else {
			request.setAttribute("id", id);
		}
		
		return "member/findIdResult";
	}
	
	@GetMapping("/findIdResult")
	public void findIdResult() {}
	
	@GetMapping("/findPwd")
	public void findPwd() {}
	
	
	@PostMapping("/rec_idCheck")
	@ResponseBody
	public int rec_idCheck(@RequestParam String rec_id) {
		
		String id = memberService.findMember(rec_id);
		
		int result = 0;
		
		if(id != null)
			result = 1;
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
}














