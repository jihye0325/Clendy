package com.kh.clendy.CScenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.clendy.CScenter.model.service.BoardServiceImpl;
import com.kh.clendy.CScenter.model.service.FAQServiceImpl;
import com.kh.clendy.CScenter.model.vo.FAQ;

@Controller
@RequestMapping("/CScenter")
public class CScenterController {
	
	private FAQServiceImpl faqService;
	private BoardServiceImpl boardService;
	private MessageSource messageSource;
	
	@Autowired
	public CScenterController(FAQServiceImpl faqService, MessageSource messageSource,
							  BoardServiceImpl boardService) {
		this.faqService = faqService;
		this.messageSource = messageSource;
		this.boardService = boardService;
	}
	
	/* faq 전체 조회 */
	@GetMapping("FAQ")
	public void toFAQ(Model model) {
		List<FAQ> faqList = faqService.selectAllFAQ();	
		
		model.addAttribute("faqList", faqList);			
	}
	
	/* faq 카테고리별 조회 */
	@GetMapping("/FAQ/category/{categoryCode}")
	@ResponseBody
	public List<FAQ> selectFAQByCategory(@PathVariable int categoryCode){
		return faqService.selectFAQByCategory(categoryCode);
	}
	
	/* faq 수정 */
	@PostMapping("/FAQ/modify")
	public String updateQna(FAQ newFaq, Model model) {
		System.out.println(newFaq);
		int result = faqService.updateFAQ(newFaq);
		if(result>0) {
			model.addAttribute("message", "수정완료");
		}else {
			model.addAttribute("message", "수정실패");
		}
		
		return "redirect:/CScenter/FAQ";
	}
	
	/* faq 등록페이지 */
	@GetMapping("insertFAQ")
	public void toInsertFAQ() {}
	
	@PostMapping("/FAQ/insert")
	public String insertFAQ(FAQ newFAQ, Model model) {
		newFAQ.setUser_no(1);
		
		int result = faqService.insertFAQ(newFAQ);
		if(result>0) {
			model.addAttribute("message", "등록완료");
		}else {
			model.addAttribute("message", "등록실패");
		}
		
		return "redirect:/CScenter/FAQ";
	}
	
	
	@GetMapping("/board")
	public void toBoard() {}
	
	@GetMapping("/personalQ")
	public void toPersonalQ() {}

}
