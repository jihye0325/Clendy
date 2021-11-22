package com.kh.clendy.product.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
		
		// System.out.println(mapReturn);
		
		List<ProductReview> reviewList = productReviewService.reviewAllSelectList(mapReturn);
		// System.out.println(reviewList);
		
		mv.addObject("reviewList", reviewList);
		mv.setViewName("product/product_view :: #review_board");
		
		return mv;
	}
	
	// 페이징
	@PostMapping("/reviewPaging")
	@ResponseBody
	public PageInfo reviewPaging(@RequestBody Map<String, Object> mapReturn) {
		PageInfo pageInfo = productReviewService.reviewPaging(mapReturn);
		// System.out.println(pageInfo);
		
		return pageInfo;
	}
	
	// 리뷰 상세
	@PostMapping("/reviewView/{rNo}")
	@ResponseBody
	public ProductReview reviewView(@PathVariable int rNo, ModelAndView mv) {
		
		ProductReview productReview = productReviewService.reviewView(rNo);
		
		return productReview;
	}
	
	
}
