package com.kh.clendy.product.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.product.model.dao.ProductQnaMapper;
import com.kh.clendy.product.model.vo.PageInfo;
import com.kh.clendy.product.model.vo.ProductQnaQ;

@Service
@Transactional
public class ProductQnaServiceImpl implements ProductQnaService{
	
	private ProductQnaMapper productQnaMapper;
	
	@Autowired
	public ProductQnaServiceImpl(ProductQnaMapper productQnaMapper) {
		this.productQnaMapper = productQnaMapper;
	}
	
	// 상품문의 목록
	@Override
	public List<ProductQnaQ> qnaAllSelectList(Map<String, Object> mapReturn) {
		
		// 상품문의 게시글 등록 갯수
		int listCount = productQnaMapper.qnaGetListCount(mapReturn);
		
		int page = Integer.parseInt(mapReturn.get("page") + "");
		
		PageInfo pageInfo = new PageInfo(page, listCount, 10, 10);
		
		int startRow = (pageInfo.getPage() - 1) * pageInfo.getBoardLimit() + 1;
		int endRow = startRow + pageInfo.getBoardLimit() - 1;
		mapReturn.put("startRow", startRow);
		mapReturn.put("endRow", endRow);
		
		List<ProductQnaQ> selectList = productQnaMapper.qnaAllSelectList(mapReturn);
		
		return selectList;
	}
	
	// 페이징
	@Override
	public PageInfo commonPaging(Map<String, Object> mapReturn) {
		
		// 상품문의 게시글 등록 갯수
		int listCount = productQnaMapper.qnaGetListCount(mapReturn);
		
		int page = Integer.parseInt(mapReturn.get("page") + "");
		
		PageInfo pageInfo = new PageInfo(page, listCount, 10, 10);
		
		return pageInfo;
	}

	// 상품 문의 등록(ajax)
	@Override
	public int qnaInsert(ProductQnaQ productQnaQ) {
		return productQnaMapper.qnaInsert(productQnaQ);
	}

	// 상품 문의 정보(ajax)
	@Override
	public ProductQnaQ qnaModifyView(int piqCode) {
		return productQnaMapper.qnaModifyView(piqCode);
	}

	// 상품 문의 수정
	@Override
	public int qnaModify(ProductQnaQ productQnaQ) {
		return productQnaMapper.qnaModify(productQnaQ);
	}

	// 상품문의 삭제(ajax)
	@Override
	public int qnaDelete(int piqCode) {
		
		int result1 = productQnaMapper.qnaDelete(piqCode);
		
		int qnaACount = productQnaMapper.qnaACount(piqCode);
		
		int result2 = 0;
		if(qnaACount > 0) {
			result2 = productQnaMapper.qnaADelete(qnaACount);
		}
		
		return result1 > 0  ? 1 : 0; 
	}

		

}
