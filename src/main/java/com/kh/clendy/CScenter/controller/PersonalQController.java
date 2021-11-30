package com.kh.clendy.CScenter.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.clendy.CScenter.model.service.PersonalQService;
import com.kh.clendy.CScenter.model.vo.PersonalQ;
import com.kh.clendy.member.model.vo.UserImpl;

@Controller
@RequestMapping("/CScenter/personalQ")
public class PersonalQController {
	
	private PersonalQService personalQService;
	
	@Autowired
	public PersonalQController(PersonalQService personalQService) {
		this.personalQService = personalQService;
	}
	
	/* 1:1문의 리스트 조회 */
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
		model.addAttribute("personalQList", resultList.get("personalQList"));
		model.addAttribute("pi", resultList.get("pi"));
	}

	/* 1:1 문의 상세 페이지 */
	@GetMapping("/detail")
	public String selectPersonalQDetail(@RequestParam int p_no, Model model) {
		PersonalQ result = personalQService.selectPersonalQDetail(p_no); 
		
		model.addAttribute("personalQ" , result);
		
		return "CScenter/detailPersonal";
	}
	
	/* 1:1 문의 답변 삭제 */
	@GetMapping("/delete")
	public String deleteAnswer(@RequestParam int p_no, Model model) {
		
		int result = personalQService.deleteAnswer(p_no);
		
		if(result>0) {
			model.addAttribute("msg", "답변이 삭제되었습니다.");
		}else {
			model.addAttribute("msg","답변 삭제에 실패하였습니다.");
		}
		PersonalQ resultList = personalQService.selectPersonalQDetail(p_no); 
		model.addAttribute("personalQ" , resultList);
		
		return "CScenter/detailPersonal";
	}
	
	/* 1:1 문의 답변 등록 */
	@GetMapping("/insertAnswer")
	public String insertAnswer(@RequestParam int p_no, @RequestParam String p_answer, Model model) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		
		PersonalQ newAnswer = new PersonalQ();
		newAnswer.setP_no(p_no);
		newAnswer.setP_answer(p_answer);
		newAnswer.setA_writer(user_no);
		
		int result = personalQService.insertAnswer(newAnswer);
		
		if(result>0) {
			model.addAttribute("msg", "답변이 등록되었습니다.");
		}else {
			model.addAttribute("msg", "답변 등록에 실패하였습니다.");
		}
		
		PersonalQ resultList = personalQService.selectPersonalQDetail(p_no); 
		model.addAttribute("personalQ" , resultList);
		
		return "CScenter/detailPersonal";
	}
	
	/* 1:1문의 답변 수정 */
	@GetMapping("/modify")
	public String updateAnswer(@RequestParam int p_no, @RequestParam String p_answer, Model model) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		
		PersonalQ updateAnswer = new PersonalQ();
		updateAnswer.setP_no(p_no);
		updateAnswer.setP_answer(p_answer);
		updateAnswer.setA_writer(user_no);
		
		int result = personalQService.updateAnswer(updateAnswer);
		
		if(result>0) {
			model.addAttribute("msg", "답변이 수정되었습니다.");
		}else {
			model.addAttribute("msg", "답변 수정에 실패하였습니다.");
		}
		
		PersonalQ resultList = personalQService.selectPersonalQDetail(p_no); 
		model.addAttribute("personalQ" , resultList);
		
		return "CScenter/detailPersonal";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
