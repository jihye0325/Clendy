package com.kh.clendy.mypage.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.clendy.mypage.model.dao.MyboardMapper;
import com.kh.clendy.product.model.vo.ProductQnaQ;

@Service
public class MyboardServiceImpl implements MyboardService{

	private MyboardMapper myboardMapper;
	
	@Autowired
	public MyboardServiceImpl(MyboardMapper myboardMapper) {
		this.myboardMapper = myboardMapper;
	}
	
	
	// 내가 쓴 글 -상품문의글 리스트
	@Override
	public List<ProductQnaQ> selectP_Qna_List(int user_no) {
		List<ProductQnaQ> p_qna_list = myboardMapper.selectP_Qna_List(user_no);
		System.out.println(p_qna_list);
		return p_qna_list;
	}
}
