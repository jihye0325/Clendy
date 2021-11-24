package com.kh.clendy.CScenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.clendy.CScenter.model.service.BoardServiceImpl;
import com.kh.clendy.CScenter.model.service.FAQServiceImpl;
import com.kh.clendy.CScenter.model.vo.FAQ;
import com.kh.clendy.member.model.vo.UserImpl;

@Controller
@RequestMapping("/CScenter")
public class CScenterController {
	
	private FAQServiceImpl faqService;
	private BoardServiceImpl boardService;

	
	@Autowired
	public CScenterController(FAQServiceImpl faqService, BoardServiceImpl boardService) {
		this.faqService = faqService;
		this.boardService = boardService;
	}
	
	/*-------------------------------- faq ----------------------------------------*/
	
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
	
	/* faq 검색 */
	@PostMapping("/FAQ/search")
	public String searchFAQByKeyword(String keyword, Model model) {
		
		List<FAQ> resultList = faqService.searchFAQByKeyword(keyword);
				
		model.addAttribute("faqList",resultList);
		
		return "/CScenter/FAQ";
	}
	
	
	/* faq 수정 */
	@PostMapping("/FAQ/modify")
	public String updateQna(FAQ newFaq, Model model, RedirectAttributes redirectAttr) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		
		newFaq.setUser_no(user_no);
		
		int result = faqService.updateFAQ(newFaq);
		if(result>0) {
			redirectAttr.addFlashAttribute("msg", "FAQ가 수정되었습니다.");
		}else {
			redirectAttr.addFlashAttribute("msg", "FAQ 수정에 실패하였습니다.");
		}
		
		return "redirect:/CScenter/FAQ";
	}
	
	/* faq 삭제 */
	@PostMapping("/FAQ/delete")
	@ResponseBody
	public int deleteFAQ(@RequestParam int q_no){
		return faqService.deleteFAQ(q_no);
	}
	
	/* faq 등록페이지 */
	@GetMapping("insertFAQ")
	public void toInsertFAQ() {}
	
	/* faq 등록 */
	@PostMapping("/FAQ/insert")
	public String insertFAQ(FAQ newFAQ, Model model, RedirectAttributes redirectAttr) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		
		int result = faqService.insertFAQ(newFAQ);
		if(result>0) {
			redirectAttr.addFlashAttribute("msg", "새로운 FAQ가 등록 되었습니다.");
		}else {
			redirectAttr.addFlashAttribute("msg", "FAQ 등록에 실패하였습니다.");
		}
		
		return "redirect:/CScenter/FAQ";
	}
	
	
	/*--------------------------------- 공지사항 ---------------------------------*/
	
	/**/
	@GetMapping("/board")
	public void toBoard() {}
	
	
	/*--------------------------------- 1:1 문의 ---------------------------------*/
	@GetMapping("/personalQ")
	public void toPersonalQ() {}

}
