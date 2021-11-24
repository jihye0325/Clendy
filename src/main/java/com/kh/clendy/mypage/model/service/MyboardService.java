package com.kh.clendy.mypage.model.service;

import java.util.List;

import com.kh.clendy.product.model.vo.ProductQnaQ;

public interface MyboardService {
	List<ProductQnaQ> selectP_Qna_List(int user_no);
}
