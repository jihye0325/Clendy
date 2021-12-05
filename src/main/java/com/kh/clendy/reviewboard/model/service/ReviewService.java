package com.kh.clendy.reviewboard.model.service;

import java.util.List;
import java.util.Map;

import com.kh.clendy.reviewboard.model.vo.Review;

public interface ReviewService {

	//모든 리뷰 조회
	//List<Review> selectReviewAllList(int page);
	
	Map<String, Object> selectReviewAllList(int page);
	
	//리뷰 검색
	List<Review> searchReviewByKeyword(String keyword, String categoryCode);
	
	

}
