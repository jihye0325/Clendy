package com.kh.clendy.mypage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.clendy.member.model.vo.UserImpl;
import com.kh.clendy.mypage.model.service.MyboardService;
import com.kh.clendy.product.model.vo.ProductQnaQ;

@Controller
@RequestMapping("/mypage")
public class MyboardController {

	private MyboardService myboardService;
	
	@Autowired
	public MyboardController(MyboardService myboardService) {
		this.myboardService = myboardService;
	}
	
	// 내가 쓴 글 화면 
	@GetMapping("/myBoard")
	public ModelAndView myBoard(ModelAndView mv) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		// 상품 문의글 리스트 
		List<ProductQnaQ> p_qna_list = myboardService.selectP_Qna_List(user_no); 
		mv.addObject("p_qna_list", p_qna_list);
		// 리뷰 리스트
		
		// 1:1 문의 리스트
		
		// 교환/환불 리스트
		
		
		mv.setViewName("mypage/myBoard");
		return mv;
	}
}
