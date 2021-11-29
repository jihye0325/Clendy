package com.kh.clendy.admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.clendy.admin.model.service.StoreService;

@Controller
@RequestMapping("/admin")
public class StoreController {
	
	private StoreService storeSerivce;
	
	@Autowired
	public StoreController(StoreService storeSerivce) {
		this.storeSerivce = storeSerivce;
	}
	
	@GetMapping("/sellerList")
	public void toStore(Model model, @RequestParam(defaultValue="1") int page) {
		
		Map<String, Object> sellerList = storeSerivce.selectAllSellerList(page);
		
		/* 리스트, 페이징 - 매출액, 수수료 ?*/
		model.addAttribute("sellerList", sellerList.get("sellerList"));
		model.addAttribute("pi", sellerList.get("pi"));
	}
	
	
	/* 입점 신청 */
	@GetMapping("/joinStore")
	public void tojoinStore(Model model, @RequestParam(defaultValue="1") int page) {
		
		Map<String, Object> applyStoreList = storeSerivce.selectAllJoinStoreList(page);
		
		/* 입점 승인 리스트, 페이징 */
		model.addAttribute("applyStoreList", applyStoreList.get("applyStoreList"));
		model.addAttribute("applyPi", applyStoreList.get("applyPi"));

	}
	
	/* 입점 취소 신청 리스트 */
	@GetMapping("/cancelStore")
	public void tocancelStore(Model model, @RequestParam(defaultValue="1") int page) {
		
		Map<String, Object> cancelStoreList = storeSerivce.selectAllCancelStoreList(page);

		/* 입점 취소 리스트, 페이징 */
		model.addAttribute("cancelStoreList",cancelStoreList.get("cancelStoreList"));
		model.addAttribute("cancelPi",cancelStoreList.get("cancelPi"));
	}

	


}
