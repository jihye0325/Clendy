package com.kh.clendy.admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.clendy.admin.model.service.StoreService;

@Controller
@RequestMapping("/admin")
public class StoreController {
	
	private StoreService storeSerivce;
	
	@Autowired
	public StoreController(StoreService storeSerivce) {
		this.storeSerivce = storeSerivce;
	}
	
	/* 판매자 리스트 */
	@GetMapping("/sellerList")
	public void toStore(Model model, @RequestParam(defaultValue="1") int page) {
		
		Map<String, Object> sellerListMap = storeSerivce.selectAllSellerList(page);
		
		/* 리스트, 페이징 */
		model.addAttribute("sellerList", sellerListMap.get("sellerList"));
		model.addAttribute("pi", sellerListMap.get("pi"));
	}
	
	/* 판매자 리스트에서 입점 취소 */
	@PostMapping("/sellerList/cancelStore")
	public String cancelStoreInSellerList(RedirectAttributes redirectAttr, int seller_code, int user_no) {
		
		int result = storeSerivce.admitCancelStoreInSellerList(seller_code, user_no);
		
		if(result>1) {
			redirectAttr.addFlashAttribute("msg","입점 취소가 완료되었습니다.");
		}else {
			redirectAttr.addFlashAttribute("msg","입점 취소에 실패했습니다.");
		}
		return "redirect:/admin/sellerList";
	}
	
	
	/* 입점 신청 리스트 */
	@GetMapping("/joinStore")
	public void tojoinStore(Model model, @RequestParam(defaultValue="1") int page) {
		
		Map<String, Object> applyStoreList = storeSerivce.selectAllJoinStoreList(page);
		
		/* 입점 승인 리스트, 페이징 */
		model.addAttribute("applyStoreList", applyStoreList.get("applyStoreList"));
		model.addAttribute("applyPi", applyStoreList.get("applyPi"));

	}
	
	/* 입점 신청 승인 */
	@PostMapping("/joinStore")
	public String admitJoinStore(int a_no, int user_no, Model model, RedirectAttributes redirectAttr) {
		
		int result = storeSerivce.admitJoinStore(a_no, user_no);
		
		if(result>1) {
			redirectAttr.addFlashAttribute("msg","입점 승인이 완료되었습니다.");
		}else {
			redirectAttr.addFlashAttribute("msg","입점 승인에 실패했습니다.");
		}
		
		return "redirect:/admin/joinStore";
	}
	
	/* 입점 취소 신청 리스트 */
	@GetMapping("/cancelStore")
	public void tocancelStore(Model model, @RequestParam(defaultValue="1") int page) {
		
		Map<String, Object> cancelStoreList = storeSerivce.selectAllCancelStoreList(page);

		/* 입점 취소 리스트, 페이징 */
		model.addAttribute("cancelStoreList",cancelStoreList.get("cancelStoreList"));
		model.addAttribute("cancelPi",cancelStoreList.get("cancelPi"));
	}
	
	/* 입점 취소 신청 승인 */
	@PostMapping("/cancelStore")
	public String admitCancelStore(int can_no, int user_no, RedirectAttributes redirectAttr) {
		
		int result = storeSerivce.admitCancelStore(can_no, user_no);
		
		if(result>1) {
			redirectAttr.addFlashAttribute("msg","입점 취소가 완료되었습니다.");
		}else {
			redirectAttr.addFlashAttribute("msg","입점 취소에 실패했습니다.");
		}
		
		return "redirect:/admin/cancelStore";
	}

	


}
