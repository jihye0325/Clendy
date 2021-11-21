package com.kh.clendy.mypage.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.member.model.vo.UserImpl;
import com.kh.clendy.mypage.model.service.MypageService;

@Controller
@RequestMapping("/mypage")
public class MypageController {

	private MypageService mypageService;
	
	@Autowired
	public MypageController(MypageService mypageService) {
		this.mypageService = mypageService;
	}
	
	// 회원정보 수정화면
	@GetMapping("/modify")
	public ModelAndView modifyForm(ModelAndView mv) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		// System.out.println(user_no);
		Member m = mypageService.selectMember(user_no);
		String address[] = m.getAddress().split(",");
		
		
		//System.out.println(address[0]);
		//System.out.println(address[1]);
		//System.out.println(address[2]);
		
		mv.addObject("m", m);
		mv.setViewName("mypage/modify");
		
		return mv;
	}
	
	// 회원정보 수정
	@PostMapping("/modify")
	public String memberModify(Model model, Member m, @RequestParam Map<String, String> parameters, RedirectAttributes redirectAttr) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		m.setUser_no(user_no);
		
		String originPwd = parameters.get("originPwd");
		
		// 현재 비밀번호 일치 확인
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(encoder.matches(originPwd,user.getPassword())) {
			System.out.println("비밀번호 일치");
			
			//새로운 비밀번호로 등록
			m.setPassword(encoder.encode(m.getPassword()));
	
			int result =  mypageService.modifyMember(m);
			
			if(result > 0 ) {
				redirectAttr.addFlashAttribute("msg", "회원정보 수정 성공했습니다.");
				return "redirect:/mypage/modify";
			}
			else {
				redirectAttr.addFlashAttribute("msg", "회원정보 수정 실패했습니다.");
				return "redirect:/mypage/modify";
			}
			
		} else {
			System.out.println("비밀번호 불일치");
			redirectAttr.addFlashAttribute("msg", "비밀번호가 일치하지 않습니다.");
			model.addAttribute(m);
			
			return "redirect:/mypage/modify";
		}			
	}
	
	@GetMapping("/confirmPwd")
	public void confirmPwd() {}
	
	@PostMapping("/deleteMember")
	public String deleteMember(RedirectAttributes redirectAttr, @RequestParam String password) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();		
		String originPwd = user.getPassword();
		
		/* 암호화 되어있는 기존 암호와 입력받은 암호 일치 확인 */
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(encoder.matches(password, originPwd)) {
			System.out.println("일치");
			
			int result = mypageService.deleteMember(user_no);
					
			if(result > 0) {
				System.out.println("탈퇴 성공");		
				SecurityContextHolder.clearContext();
				redirectAttr.addFlashAttribute("msg", "Clendy 탈퇴가 완료되었습니다. 감사합니다.");	// ** 개행처리 **
			}
			else {
				System.out.println("탈퇴 실패");
				redirectAttr.addFlashAttribute("msg", "탈퇴에 실패하셨습니다.");
				
			}
			
			return "redirect:/";
			
		} else {
			System.out.println("불일치");
			redirectAttr.addFlashAttribute("msg", "비밀번호가 일치하지 않습니다.");
			
			return "redirect:/mypage/confirmPwd";
		}
	}
}
