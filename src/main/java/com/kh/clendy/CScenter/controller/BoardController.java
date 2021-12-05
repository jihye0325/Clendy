package com.kh.clendy.CScenter.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.kh.clendy.CScenter.model.service.BoardService;
import com.kh.clendy.CScenter.model.vo.Board;
import com.kh.clendy.member.model.vo.UserImpl;

@Controller
@RequestMapping("/CScenter/board")
public class BoardController {
	
	private BoardService boardService;
	
	@Autowired
	public BoardController( BoardService boardService) {
		this.boardService = boardService;
	}
	
	/* 공지사항 전체 조회 */
	@GetMapping("")
	public void toBoard(Model model, @RequestParam(defaultValue="1") int page) {
		Map<String, Object> result = boardService.selectAllBoard(page);
		
		model.addAttribute("boardList", result.get("boardList"));
		model.addAttribute("pi", result.get("pageInfo"));
	}
	
	/* 공지사항 상세 페이지 */
	@GetMapping("/detail")
	public String selectOneBoard(@RequestParam int b_no, Model model) {
		
		Board result = boardService.selectOneBoard(b_no);
		
		model.addAttribute("board", result);
		
		return "CScenter/detailBoard";
	}
	
	/* 공지사항 삭제 */
	@GetMapping("/delete")
	public String deleteBoard(@RequestParam int b_no, RedirectAttributes redirectAttr) {
		
		int result = boardService.deleteBoard(b_no);
		String resultPage;
		
		if(result>0) {
			redirectAttr.addFlashAttribute("msg", "공지사항이 삭제되었습니다.");
			resultPage = "redirect:/CScenter/board";
		}else {
			
			redirectAttr.addFlashAttribute("msg", "공지사항 삭제에 실패하였습니다.");
			resultPage = "redirect:/CScenter/board/detail?b_no="+b_no;
		}
		
		return resultPage;
	}
	
	/* 공지사항 등록페이지로 이동 */
	@GetMapping("/insert")
	public String toInsertBoard() {
		return "/CScenter/insertBoard";
	}
	
	/* 공지사항 등록 */
	@PostMapping("/insert")
	public String insertBoard(Board newBoard, RedirectAttributes redirectAttr) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		newBoard.setUser_no(user.getUser_no());
		
		int result = boardService.insertBoard(newBoard);
		String resultPage;
		
		if(result >0) {
			redirectAttr.addFlashAttribute("msg","공지사항이 등록되었습니다.");
		}else {
			redirectAttr.addFlashAttribute("msg","공지사항 등록에 실패하였습니다.");
		}
		
		return "redirect:/CScenter/board";
	}
	
	/* 공지사항 수정 */
	@GetMapping("/modify")
	public String toUpdateBoard(int b_no, Model model) {
		
		Board result = boardService.selectOneBoard(b_no);
		
		model.addAttribute("board", result);	
	
		return "/CScenter/modifyBoard";
	}
	
	@PostMapping("/modify")
	public String updateBoard(Board updateBoard, RedirectAttributes redirectAttr) {
		
		int result = boardService.updateBoard(updateBoard);
		
		if(result >0) {
			redirectAttr.addFlashAttribute("msg","공지사항이 수정되었습니다.");
		}else {
			redirectAttr.addFlashAttribute("msg","공지사항 수정에 실패하였습니다.");
		}
		
		return "redirect:/CScenter/board/detail?b_no="+ updateBoard.getB_no();
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
