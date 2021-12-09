package com.kh.clendy.reviewboard.model.service;

import java.util.Map;

public interface ReviewService {

	//모든 리뷰 조회
	Map<String, Object> selectReviewAllList(int page);
	
	
	Map<String, Object> selectReviewSearchList(String keyword);
		
	
	
	

}
