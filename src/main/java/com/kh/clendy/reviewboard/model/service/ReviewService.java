package com.kh.clendy.reviewboard.model.service;

import java.util.Map;

public interface ReviewService {

	//모든 리뷰 조회
	Map<String, Object> selectReviewAllList(int page);
	//검색결과 조회
	Map<String, Object> selectReviewSearchList(String keyword,int page);
	
	//리뷰 좋아요
	int reviewLike(int user_no, int rNo);
		
	
	
	

}
