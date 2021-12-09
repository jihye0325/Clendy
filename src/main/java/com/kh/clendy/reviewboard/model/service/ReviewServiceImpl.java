package com.kh.clendy.reviewboard.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.product.model.vo.PageInfo;
import com.kh.clendy.reviewboard.model.dao.ReviewMapper;
import com.kh.clendy.reviewboard.model.vo.Review;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

	private ReviewMapper reviewMapper;

	@Autowired
	public ReviewServiceImpl(ReviewMapper reviewMapper) {
		this.reviewMapper = reviewMapper;
	}

	@Override
	public Map<String, Object> selectReviewAllList(int page) {

		int listCount = reviewMapper.reviewListCount();

		PageInfo pageInfo = new PageInfo(page, listCount, 10, 5);

		int startRow = (pageInfo.getPage() - 1) * pageInfo.getBoardLimit() + 1;
		int endRow = startRow + pageInfo.getBoardLimit() - 1;

		Map<String, Object> mapMapper = new HashMap<>();
		mapMapper.put("page", page);
		mapMapper.put("startRow", startRow);
		mapMapper.put("endRow", endRow);

		List<Review> reviewList = reviewMapper.selectReviewAllList(mapMapper);

		Map<String, Object> result = new HashMap<>();
		result.put("reviewList", reviewList);
		result.put("pageInfo", pageInfo);

		return result;
	}
	
	

	@Override
	public Map<String, Object> selectReviewSearchList(String keyword) {
		Map<String, Object> mapMapper = new HashMap<>();
		mapMapper.put("keyword", keyword);
		
		List<Review> reviewList = reviewMapper.selectReviewSearchList(mapMapper);
		
		Map<String, Object> result = new HashMap<>();
		result.put("reviewList", reviewList);
		
		return result;
	}

}
