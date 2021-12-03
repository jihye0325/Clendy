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

import com.kh.clendy.admin.model.service.CalculationService;

@Controller
@RequestMapping("/admin/calculation")
public class CalculationController {
	
	private CalculationService calculationService;
	
	@Autowired
	public CalculationController(CalculationService calculationService) {
		this.calculationService = calculationService;
	}
	
	/* 정산 전 리스트 조회 */
	@GetMapping("/before")
	public String toCalculationBefore(Model model, @RequestParam(defaultValue="1") int page) {
		
		Map<String, Object> beforeCalculation = calculationService.selectBeforeCalculation(page);
		
		model.addAttribute("beforeCalculation", beforeCalculation.get("beforeCalculation"));
		model.addAttribute("pi", beforeCalculation.get("pi"));
		
		return "/admin/beforeCalculation";
	}

	/* 정산 후 리스트 조회 */
	@GetMapping("/after")
	public String toCalculationAfter(Model model, @RequestParam(defaultValue="1") int page) {
		
		Map<String, Object> afterCalculation = calculationService.selectAfterCalculation(page);
		
		model.addAttribute("afterCalculation", afterCalculation.get("afterCalculation"));
		model.addAttribute("pi", afterCalculation.get("pi"));
		
		return "/admin/afterCalculation";
		
	}
	
	/* 정산 상태 변경 */
	@PostMapping("/change")
	public String updateBeforeToAfter(int cal_no, RedirectAttributes redirectAttr) {
		
		int result = calculationService.updateBeforeToAfter(cal_no);
		
		if(result > 0) {
			redirectAttr.addFlashAttribute("msg", "정산이 완료되었습니다.");
		}else {
			redirectAttr.addFlashAttribute("msg", "정산에 실패하였습니다.");
		}
		
		return "redirect:/admin/calculation/before";
	}
	
}











