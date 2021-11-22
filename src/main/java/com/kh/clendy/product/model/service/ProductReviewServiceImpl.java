package com.kh.clendy.product.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.product.model.dao.ProductReviewMapper;
import com.kh.clendy.product.model.vo.PageInfo;
import com.kh.clendy.product.model.vo.ProductReview;

@Service
@Transactional
public class ProductReviewServiceImpl implements ProductReviewService{
	
	private ProductReviewMapper productReviewMapper;
	
	public ProductReviewServiceImpl(ProductReviewMapper productReviewMapper) {
		this.productReviewMapper = productReviewMapper;
	}

	// 상품 상세 리뷰 목록
	@Override
	public List<ProductReview> reviewAllSelectList(Map<String, Object> mapReturn) {

		// 상품 리뷰 등록 갯수
		int listCount = productReviewMapper.reviewGetListCount(mapReturn);
		
		int page = Integer.parseInt(mapReturn.get("page") + "");
		
		PageInfo pageInfo = new PageInfo(page, listCount, 10, 4);
		
		int startRow = (pageInfo.getPage() - 1) * pageInfo.getBoardLimit() + 1;
		int endRow = startRow + pageInfo.getBoardLimit() - 1;
		mapReturn.put("startRow", startRow);
		mapReturn.put("endRow", endRow);
		
		List<ProductReview> reviewList = productReviewMapper.reviewAllSelectList(mapReturn);
		
		return reviewList;
	}

	// 상품 상세 리뷰 목록 페이징
	@Override
	public PageInfo reviewPaging(Map<String, Object> mapReturn) {
		int listCount = productReviewMapper.reviewGetListCount(mapReturn);
		
		int page = Integer.parseInt(mapReturn.get("page") + "");
		
		PageInfo pageInfo = new PageInfo(page, listCount, 10, 4);
		
		return pageInfo;
	}

	// 상품 상세 리뷰 상세
	@Override
	public ProductReview reviewView(int rNo) {
		return productReviewMapper.reviewView(rNo);
	}

}
