package com.kh.clendy.product.model.service;

import java.util.Map;

import com.kh.clendy.product.model.vo.PageInfo;
import com.kh.clendy.product.model.vo.ProductQnaQ;

public interface ProductService {

	// 상품 문의 등록(ajax)
	int qnaInsert(ProductQnaQ productQnaQ);

	// 상품 문의 정보
	ProductQnaQ qnaModifyView(int piqCode);

	// 상품 문의 수정
	int qnaModify(ProductQnaQ productQnaQ);

	// 상품문의 삭제(ajax)
	int qnaDelete(int piqCode);

	// 상품문의 목록
	Map<String, Object> qnaAllSelectList(Map<String, Object> mapReturn);

	// 페이징
	PageInfo commonPaging(Map<String, Object> mapReturn);
}
