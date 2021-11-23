package com.kh.clendy.product.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.product.model.vo.ProductReview;

@Mapper
public interface ProductReviewMapper {
	
	int reviewGetListCount(Map<String, Object> mapReturn);
	
	List<ProductReview> reviewAllSelectList(Map<String, Object> mapReturn);

	ProductReview reviewView(int rNo);

	int reviewLikeGetCount(Map<String, Object> returnMap);

	int reviewLikeDelete(Map<String, Object> returnMap);

	int reviewLikeInsert(Map<String, Object> returnMap);
}
