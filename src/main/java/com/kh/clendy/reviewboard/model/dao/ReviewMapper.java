package com.kh.clendy.reviewboard.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.reviewboard.model.vo.Review;
@Mapper
public interface ReviewMapper {

	List<Review> selectReviewAllList();

	List<Review> searchReviewByKeyword(String keyword);

}
