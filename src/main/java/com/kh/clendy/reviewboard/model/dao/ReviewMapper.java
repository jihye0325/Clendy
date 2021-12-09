package com.kh.clendy.reviewboard.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.reviewboard.model.vo.Review;
@Mapper
public interface ReviewMapper {

	List<Review> selectReviewAllList(Map<String, Object> mapMapper);

	int reviewListCount();

	



	List<Review> selectReviewSearchList(Map<String, Object> mapMapper);








	

}
