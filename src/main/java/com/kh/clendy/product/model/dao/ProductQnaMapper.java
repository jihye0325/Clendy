package com.kh.clendy.product.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.product.model.vo.ProductQnaQ;

@Mapper
public interface ProductQnaMapper {
	
	// 상품 문의 등록(ajax)
	int qnaInsert(ProductQnaQ productQnaQ);

	// 상품 문의 정보
	ProductQnaQ qnaModifyView(int piqCode);

	// 상품 문의 수정
	int qnaModify(ProductQnaQ productQnaQ);

	// 상품문의 삭제(ajax)
	int qnaDelete(int piqCode);
	
	// 상품문의 답변 있는지
	int qnaACount(int piqCode);
	
	// 상품문의 답변글 삭제
	int qnaADelete(int qnaACount);

	// 상품문의 게시글 등록 갯수
	int qnaGetListCount(Map<String, Object> mapReturn);

	// 상품문의 목록
	List<ProductQnaQ> qnaAllSelectList(Map<String, Object> mapReturn);
	
}
