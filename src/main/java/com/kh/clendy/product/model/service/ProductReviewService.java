package com.kh.clendy.product.model.service;

import java.util.List;
import java.util.Map;

import com.kh.clendy.product.model.vo.PageInfo;
import com.kh.clendy.product.model.vo.ProductReview;

public interface ProductReviewService {

	// 상품 상세 리뷰 목록
	List<ProductReview> reviewAllSelectList(Map<String, Object> mapReturn);

	// 상품 상세 리뷰 목록 페이징
	PageInfo reviewPaging(Map<String, Object> mapReturn);

	// 상품 상세 리뷰 상세
	ProductReview reviewView(int rNo);

	// 상품 상세 리뷰 좋아요
	int reviewLike(Map<String, Object> returnMap);
	
	
}
