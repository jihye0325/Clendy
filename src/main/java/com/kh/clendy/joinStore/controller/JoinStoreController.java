package com.kh.clendy.joinStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.clendy.joinStore.model.service.JoinStoreServiceImpl;
import com.kh.clendy.joinStore.model.vo.ApplyStore;
import com.kh.clendy.member.model.vo.UserImpl;

@Controller
@RequestMapping("/common")
public class JoinStoreController {
	
	private JoinStoreServiceImpl joinStoreService;
	
	@Autowired
	public JoinStoreController(JoinStoreServiceImpl joinStoreService) {
		this.joinStoreService = joinStoreService;
	}
	
	@GetMapping("joinStore")
	public void toJoinStore() {}
	
	@PostMapping("joinStore")
	public String applyStore(ApplyStore newStore,  RedirectAttributes redirectAttr) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		newStore.setUser_no(user_no);
		
		int result = joinStoreService.applyStore(newStore);
		
		if(result>0) {
			redirectAttr.addFlashAttribute("msg", "입점 신청이 완료되었습니다.");
		}else {
			redirectAttr.addFlashAttribute("msg", "입점 신청에 실패하였습니다.");
		}
		
		return "redirect:/common/joinStore";
	}
	
	

}
