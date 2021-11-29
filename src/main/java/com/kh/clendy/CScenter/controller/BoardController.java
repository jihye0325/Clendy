package com.kh.clendy.CScenter.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.clendy.CScenter.model.service.BoardService;
import com.kh.clendy.CScenter.model.vo.Board;

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
	public String deleteBoard(@RequestParam int b_no, RedirectAttributes redirectAttr, Model model) {
		
		int result = boardService.deleteBoard(b_no);
		String resultPage;
		
		if(result>0) {
			redirectAttr.addFlashAttribute("msg", "공지사항이 삭제되었습니다.");
			resultPage = "redirect:/CScenter/board";
		}else {
			Board resultBoard = boardService.selectOneBoard(b_no);
			model.addAttribute("board", resultBoard);
			model.addAttribute("msg", "공지사항 삭제에 실패하였습니다.");
			resultPage = "/CScenter/detailBoard";
		}
		
		return resultPage;
	}
	
	/* 공지사항 등록페이지로 이동 */
	@GetMapping("/insert")
	public String toInsertBoard() {
		return "/CScenter/insertBoard";
	}
	
	/* 싱글이미지 등록 */
/*	@RequestMapping(value="/singleImageUploader.do")
		public String singleImageUploader(HttpServletRequest req, 
				SmartEditorSingle smartEditorSingle) throws UnsupportedEncodingException{
		String callback = smartEditorSingle.getCallback();
		String callback_func = smartEditorSingle.getCallback_func();
		String file_result ="";
		String result ="";
		
		MultipartFile multiFile = smartEditorSingle.getfiledata();
		try {
			if(multiFile != null && multiFile.getSize() > 0 && 
					StringUtils.is(multiFile.getName())) {
				
			}
		} 
	}*/
	
	
	
	
	
	
	
	

}
