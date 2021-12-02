package com.kh.clendy.reviewboard.model.service;

import java.util.List;

import com.kh.clendy.reviewboard.model.vo.Review;

public interface ReviewService {

	//모든 리뷰 조회
	List<Review> selectReviewAllList();
	
	//리뷰 검색
	List<Review> searchReviewByKeyword(String keyword);

}
