package com.kh.clendy.mypage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.mypage.model.service.MypageService;

@Controller
@RequestMapping("/mypage")
public class MypageController {

	private MypageService mypageService;
	
	@Autowired
	public MypageController(MypageService mypageService) {
		this.mypageService = mypageService;
	}
	
	@GetMapping("/modify")
	public ModelAndView modifyForm(HttpSession session, ModelAndView mv) {
		String id = (String)session.getAttribute("id"); 
		//Member member = mypageService.selectMember(id);
		System.out.println(id);
		
		//mv.addObject(member);
		//mv.setViewName("/mypage/modify");
		
		return mv;
	}
	
	@GetMapping("/deleteMember")
	public String deleteMember(Member member) {
		
		int result = mypageService.deleteMember(member);
		
		String msg = "";
		
		if(result > 0)
			msg = "회원탈퇴 성공";
		else
			msg = "회원탈퇴 실패";
		
		return "redirect:/";
	}
	
}
