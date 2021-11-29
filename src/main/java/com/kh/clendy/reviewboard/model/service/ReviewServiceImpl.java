package com.kh.clendy.reviewboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.reviewboard.model.dao.ReviewMapper;
import com.kh.clendy.reviewboard.model.vo.Review;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService{
	
	private ReviewMapper reviewMapper;
	
	@Autowired
	public ReviewServiceImpl(ReviewMapper reviewMapper) {
		this.reviewMapper = reviewMapper;
	}

	@Override
	public List<Review> selectReviewAllList() {
		List<Review> reviewList = reviewMapper.selectReviewAllList();

		return reviewList;
	}

}
