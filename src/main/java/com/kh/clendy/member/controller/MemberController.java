package com.kh.clendy.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String signUp(Member member, HttpServletRequest request, RedirectAttributes redirectAttr) {
		int result = 0;
		String rec_id = "";
		
		if(request.getParameter("recommender") != null) {
			rec_id = request.getParameter("recommender");
			result = memberService.signUp(member, rec_id);
		} else {
			result = memberService.signUp(member, rec_id);
		}
		
		if(result > 0) {
			redirectAttr.addFlashAttribute("msg", "성공");
		} else {
			redirectAttr.addFlashAttribute("msg", "실패");
		}
		
		return "redirect:/member/signUp";
	}
	
	// 이용약관
	@GetMapping("/clause1")
	public void clause1() {}
	
	@GetMapping("/clause2")
	public void clause2() {}
	
	@GetMapping("/deletePage")
	public void deletePage() {}
	
	@GetMapping("/findId")
	public void findId() {}
	
	// 아이디찾기
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
	
	// 추천인 아이디	
	@PostMapping("/rec_idCheck")
	@ResponseBody
	public int rec_idCheck(@RequestParam String rec_id) {
		
		String id = memberService.findMember(rec_id);
		
		int result = 0;
		
		if(id != null)
			result = 1;
		
		return result;
	}
	
	
	// 아이디 중복 검사
	@PostMapping("/idCheck")
	@ResponseBody
	public int idCheck(@RequestParam String id) {
		int result = memberService.idCheck(id);
		return result;
	}
	
	// 전화번호 중복 검사
	@PostMapping("/phoneCheck")
	@ResponseBody
	public int phoneCheck(@RequestParam String phone) {
		int result = memberService.phoneCheck(phone);
		return result;
	}
	
	// 비밀번호 찾기
	//Email과 name의 일치여부를 check하는 컨트롤러
	 @PostMapping("/findPwd")
		public String findPw(HttpServletRequest request, Member member, RedirectAttributes redirectAttr) {
			String id = member.getId();
			String email = member.getEmail();
			
			String pwd = memberService.findPwd(id, email);
			
			if(pwd == null) {
				request.setAttribute("noPwd", "noPwd");
				return "member/findPwd";
			} else {
				request.setAttribute("pwd", pwd);
			}
			
			return "member/findPwdResult";
	 }
	 
	 @GetMapping("/findPwdResult")
	 public void findPwdResult() {}
}














