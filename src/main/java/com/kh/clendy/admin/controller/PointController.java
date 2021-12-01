package com.kh.clendy.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.clendy.admin.model.service.PointService;
import com.kh.clendy.admin.model.vo.PointCategory;

@Controller
@RequestMapping("/admin/point")
public class PointController {
	
	private PointService pointService;
	
	@Autowired
	public PointController(PointService pointService) {
		this.pointService = pointService;
	}
	
	/* 포인트 조회 */
	@GetMapping("")
	public void toPoint(Model model, @RequestParam(defaultValue="1") int page) {
		
		List<PointCategory> basicPointList = pointService.selectBasicPoint();
		Map<String, Object> eventPointResult = pointService.selectEventPoint(page);
		
		model.addAttribute("basicPointList" , basicPointList);
		
		model.addAttribute("eventPointList", eventPointResult.get("eventPointList"));
		model.addAttribute("pi", eventPointResult.get("pageInfo"));
		
	}
	
	/* 포인트 등록 페이지로 */
	@GetMapping("/insert")
	public String toInsertPoint() {
		return "/admin/insertPoint";
	}
	
	/* 포인트 등록 */
	@PostMapping("/insert")
	public String insertPoint(PointCategory newPoint, Model model) {
		
		int result = pointService.insertPoint(newPoint);
		
		if(result>0) {
			model.addAttribute("msg", "포인트 등록이 완료되었습니다.");
		}else {
			model.addAttribute("msg", "포인트 등록에 실패하였습니다.");
		}
		return "/admin/result";
	}
	
	/* 포인트 삭제 */
	@GetMapping("/delete")
	public String deletePoint(int point_code, RedirectAttributes redirectAttr ) {
		
		int result = pointService.deletePoint(point_code);
		
		if(result>0) {
			redirectAttr.addFlashAttribute("msg", "포인트가 삭제 되었습니다.");
		}else {
			redirectAttr.addFlashAttribute("msg", "포인트 삭제에 실패하였습니다.");
		}
		return "redirect:/admin/point";
	}
	
	/* 포인트 수정 */
	@PostMapping("/update")
	public String updateBasicPoint(PointCategory updatePoint, RedirectAttributes redirectAttr) {
		
		int result = pointService.updateBasicPoint(updatePoint);
		
		if(result>0) {
			redirectAttr.addFlashAttribute("msg", "포인트 수정이 완료되었습니다.");
		}else {
			redirectAttr.addFlashAttribute("msg", "포인트 수정에 실패하였습니다.");
		}
		return "redirect:/admin/point";
	}
	

}
