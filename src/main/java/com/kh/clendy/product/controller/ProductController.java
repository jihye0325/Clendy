package com.kh.clendy.product.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.clendy.product.model.service.ProductService;
import com.kh.clendy.product.model.vo.PageInfo;
import com.kh.clendy.product.model.vo.ProductQnaQ;

@Controller
@RequestMapping("/product/")
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	// type = 공용, 남성, 여성 카테고리 들어감
	// 상품 목록
	@GetMapping("/list/{type}")
	public String productListPage(@PathVariable String type) {
		
		return "product/product_list";
	}
	
	// 상품 상세(상품번호)
	@GetMapping("/view/{pNo}")
	public String productViewPage(@PathVariable String pNo) {
		
		
		return "product/product_view";
	}
	
	// 상품 문의 등록(ajax)
	@PostMapping("/qnaInsert")
	@ResponseBody
	public String qnaInsert(@RequestBody ProductQnaQ productQnaQ) {
		System.out.println(productQnaQ);
		
		int result = productService.qnaInsert(productQnaQ);
		
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
		
		// System.out.println(piqCode);
		
		ProductQnaQ modifyQna = productService.qnaModifyView(piqCode);
		
		return modifyQna;
	}
	
	// 상품문의 수정(ajax)
	@PostMapping("/qnaModify")
	@ResponseBody
	public String qnaModify(@RequestBody ProductQnaQ qnaModifyView) {
	
		System.out.println(qnaModifyView);
		
		int result = productService.qnaModify(qnaModifyView);
		
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
		// System.out.println(piqCode);
		
		// 상품문의 질문 삭제후
		int result = productService.qnaDelete(piqCode);
		
		String msg = "";
		
		if(result > 0) {
			msg = "success";
		}else {
			msg = "fail";
		}
		
		return msg;
	}
	
	// 상품문의 목록
	@PostMapping("/qnaAllSelectList")
	@ResponseBody
	public ModelAndView qnaAllSelectList(@RequestBody Map<String, Object> mapReturn, Model model, ModelAndView mv){
		
		// System.out.println(mapReturn);
		Map<String, Object> mapList = productService.qnaAllSelectList(mapReturn);
		// model.addAttribute("mapList", mapList);
		 
		 // model.addAttribute("selectList", mapList.get("selectList"));
		 mv.addObject("selectList", mapList.get("selectList"));
		 mv.addObject("pageInfo", mapList.get("pageInfo"));
		 System.out.println(mapList.get("pageInfo"));
		 mv.setViewName("product/product_view :: #view_qna");
		
		// return "product/product_view :: #view_qna";
		 return mv;
	}
	
	// 페이징
	@PostMapping("/paging")
	@ResponseBody
	public PageInfo commonPaging(@RequestBody Map<String, Object> mapReturn){
		
		PageInfo pageInfo = productService.commonPaging(mapReturn);
		// System.out.println(pageInfo);
		
		
		return pageInfo;
	}
	
}
