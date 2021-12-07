package com.kh.clendy.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
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
	public ModelAndView findId(ModelAndView mv, Member member) {
		String id = memberService.findId(member.getUser_name(), member.getPhone());

		if(id == null) {
			mv.addObject("noId", "noId");
			mv.setViewName("member/findId");
		} else {
			mv.addObject("id", id);
			mv.setViewName("member/findIdResult");
		}
		
		return mv;
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
	
	 @GetMapping("/findPwdResult")
	 public void findPwdResult() {}
	

	// 비밀번호 찾기
	//Email과 name의 일치여부를 check
	 @PostMapping("/findPwd")
		public String findPwd(HttpServletRequest request, HttpServletResponse response , Member member, RedirectAttributes redirectAttr) {
			
		 	int findMember = memberService.findMemberById_Email(member, response);

			String msg ="";
			if(findMember > 0) {
				msg="성공";
			} else {
				msg = "해당 정보와 일치하는 회원이 존재하지 않습니다.";
			}
					
			redirectAttr.addFlashAttribute("msg", msg);
			
			return "redirect:/member/findPwd";
	 }
	 
}














