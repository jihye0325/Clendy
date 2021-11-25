package com.kh.clendy.mypage.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.product.model.vo.ProductQnaQ;

@Mapper
public interface MyboardMapper {

	List<ProductQnaQ> selectP_Qna_List(int user_no);
}
