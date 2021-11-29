package com.kh.clendy.CScenter.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.clendy.CScenter.model.service.PersonalQService;
import com.kh.clendy.member.model.vo.UserImpl;

@Controller
@RequestMapping("/CScenter/personalQ")
public class PersonalQController {
	
	private PersonalQService personalQService;
	
	@Autowired
	public PersonalQController(PersonalQService personalQService) {
		this.personalQService = personalQService;
	}
	
	@GetMapping("")
	public void toPersonalQ(@AuthenticationPrincipal UserImpl user, Model model, @RequestParam(defaultValue="1") int page) {
		
		int user_no = user.getUser_no();
		String user_roll = user.getAuthorities().toString();	
	
		Map<String, Object> resultList;
		
		/* 유저 권한에 따라 다른 서비스 메소드 실행 */
		// 관리자 로그인 시 모든 1:1문의 리스트
		if(user_roll.contains("ROLE_ADMIN")) {
			resultList = personalQService.selectAllPersonalQList(page);
		// 관리자 외 유저의 1:1문의 리스트
		}else {
			resultList = personalQService.selectMyPersonalQList(user_no, page);
		}
		System.out.println(user.getAuthorities());
		model.addAttribute("personalQList", resultList.get("personalQList"));
		model.addAttribute("pi", resultList.get("pi"));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
