package com.kh.clendy.product.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.clendy.member.model.vo.UserImpl;
import com.kh.clendy.product.model.service.ProductReviewService;
import com.kh.clendy.product.model.vo.PageInfo;
import com.kh.clendy.product.model.vo.ProductReview;

@Controller
@RequestMapping("/product/")
public class ProductReviewController {
	
	private ProductReviewService productReviewService;
	
	@Autowired
	public ProductReviewController(ProductReviewService productReviewService) {
		this.productReviewService = productReviewService;
	}

	// 리뷰 목록
	@PostMapping("/reviewAllSelectList")
	@ResponseBody
	public ModelAndView reviewAllSelectList(ModelAndView mv, @RequestBody Map<String, Object> mapReturn) {

		List<ProductReview> reviewList = productReviewService.reviewAllSelectList(mapReturn);
		
		mv.addObject("reviewList", reviewList);
		mv.setViewName("product/product_view :: #review_board");
		
		return mv;
	}
	
	// 페이징
	@PostMapping("/reviewPaging")
	@ResponseBody
	public PageInfo reviewPaging(@RequestBody Map<String, Object> mapReturn) {
		PageInfo pageInfo = productReviewService.reviewPaging(mapReturn);
		
		return pageInfo;
	}
	
	// 리뷰 상세
	@PostMapping("/reviewView/{rNo}")
	@ResponseBody
	public ProductReview reviewView(@PathVariable int rNo, ModelAndView mv) {
		
		ProductReview productReview = productReviewService.reviewView(rNo);
		
		return productReview;
	}
	
	// 리뷰 좋아요 기능
	@PostMapping("/reviewLike")
	@ResponseBody
	public String reviewLike(@RequestBody Map<String, Object> returnMap) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		int loginUno = user.getUser_no();
		
		returnMap.put("loginUno", loginUno);
		
		int result = productReviewService.reviewLike(returnMap);
		
		String msg = "";
		if(result == -1) { 
			msg = "error";
		}else if(result == 1) {
			msg = "delete";
		}else if(result == 2) {
			msg = "insert";
		}
		
		return msg;
	}
	
	
}
