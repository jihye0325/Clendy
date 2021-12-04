package com.kh.clendy.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.clendy.common.model.service.JoinStoreServiceImpl;
import com.kh.clendy.common.model.vo.ApplyStore;
import com.kh.clendy.member.model.vo.UserImpl;

@Controller
@RequestMapping("/common")
public class JoinStoreController {
	
	private JoinStoreServiceImpl joinStoreService;
	
	@Autowired
	public JoinStoreController(JoinStoreServiceImpl joinStoreService) {
		this.joinStoreService = joinStoreService;
	}
	
	/* 입점 신청 페이지 */
	@GetMapping("joinStore")
	public void toJoinStore(Model model) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		
		model.addAttribute("user_no", user_no);
	}
	
	/* 입점 신청 */
	@PostMapping("joinStore")
	public String applyStore(ApplyStore newStore, @RequestParam String detailAddress, RedirectAttributes redirectAttr) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		newStore.setUser_no(user_no);
		newStore.setAddress(newStore.getAddress()+" " + detailAddress);
		
		int result = joinStoreService.applyStore(newStore);
		
		if(result>0) {
			redirectAttr.addFlashAttribute("msg", "입점 신청이 완료되었습니다.");
		}else {
			redirectAttr.addFlashAttribute("msg", "입점 신청에 실패하였습니다.");
		}
		
		return "redirect:/common/joinStore";
	}
	
	/* 스토어 이름 중복 검사 */
	@PostMapping("/checkSellerList")
	@ResponseBody
	public int checkSellerName(@RequestParam String seller_name) {
		return joinStoreService.checkSellerName(seller_name);
	}
	
	/* 사업자등록번호 중복 검사 */
	@PostMapping("/checkBLicense")
	@ResponseBody
	public int checkBLicense(@RequestParam int b_license) {
		return joinStoreService.checkBLicense(b_license);
	}
	
	/* 통신판매업신고번호 중복 검사 */
	@PostMapping("/checkOBLicense")
	@ResponseBody
	public int checkOBLicense(@RequestParam String o_b_license) {
		return joinStoreService.checkOBLicense(o_b_license);
	}
	
	/* 이미 신청한 유저 번호 검사 */
	@PostMapping("/checkUserNo")
	@ResponseBody
	public int checkUserNo(@RequestParam int user_no) {
		return joinStoreService.checkUserNo(user_no);
	}
	

}
