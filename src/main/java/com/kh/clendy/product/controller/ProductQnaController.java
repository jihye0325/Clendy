package com.kh.clendy.product.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.clendy.member.model.vo.UserImpl;
import com.kh.clendy.product.model.service.ProductQnaService;
import com.kh.clendy.product.model.vo.PageInfo;
import com.kh.clendy.product.model.vo.ProductQnaQ;

@Controller
@RequestMapping("/product/")
public class ProductQnaController {
private ProductQnaService productQnaService;
	
	@Autowired
	public ProductQnaController(ProductQnaService productQnaService) {
		this.productQnaService = productQnaService;
	}
	
	// 상품문의 목록
	@PostMapping("/qnaAllSelectList")
	@ResponseBody
	public ModelAndView qnaAllSelectList(@RequestBody Map<String, Object> mapReturn, ModelAndView mv){
	
		List<ProductQnaQ> selectList = productQnaService.qnaAllSelectList(mapReturn);
		
		for(ProductQnaQ pq : selectList) {
			pq.setLoginUno((int)mapReturn.get("loginUno"));
		}
		 
		 mv.addObject("selectList", selectList);
		 mv.setViewName("product/product_view :: #view_qna");
		 
		 // LOG.info(mapList.get("pageInfo"));
		
		 return mv;
	}
		
	// 페이징
	@PostMapping("/paging")
	@ResponseBody
	public PageInfo commonPaging(@RequestBody Map<String, Object> mapReturn){

		PageInfo pageInfo = productQnaService.commonPaging(mapReturn);

		return pageInfo;
	}

	// 상품 문의 등록(ajax)
	@PostMapping("/qnaInsert")
	@ResponseBody
	public String qnaInsert(@RequestBody ProductQnaQ productQnaQ) {
		
		int result = productQnaService.qnaInsert(productQnaQ);
		
		String msg = "";
		
		if(result > 0) {
			msg = "success";
		}else {
			msg = "fail";
		}
		
		return msg;
	}
	
	// 상품 문의 정보
	@PostMapping("/qnaModifyView")
	@ResponseBody
	public ProductQnaQ qnaModifyView(@RequestParam int piqCode) {
		
		
		ProductQnaQ modifyQna = productQnaService.qnaModifyView(piqCode);
		
		return modifyQna;
	}
	
	// 상품문의 수정(ajax)
	@PostMapping("/qnaModify")
	@ResponseBody
	public String qnaModify(@RequestBody ProductQnaQ qnaModifyView) {
		
		int result = productQnaService.qnaModify(qnaModifyView);
		
		String msg = "";
		
		if(result > 0) {
			msg = "success";
		}else {
			msg = "fail";
		}
		
		return msg;
	}
	
	// 상품문의 삭제(ajax)
	@PostMapping("/qnaDelete")
	@ResponseBody
	public String qnaDelete(@RequestBody int piqCode) {
		
		// 상품문의 질문 삭제후
		int result = productQnaService.qnaDelete(piqCode);
		
		String msg = "";
		
		if(result > 0) {
			msg = "success";
		}else {
			msg = "fail";
		}
		
		return msg;
	}
	
	
	
	
	
	
}
