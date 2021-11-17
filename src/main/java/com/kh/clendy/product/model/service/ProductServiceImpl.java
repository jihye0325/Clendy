package com.kh.clendy.product.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.product.model.dao.ProductMapper;
import com.kh.clendy.product.model.vo.PageInfo;
import com.kh.clendy.product.model.vo.ProductQnaQ;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	private ProductMapper productMapper;
	
	@Autowired
	public ProductServiceImpl(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}

	// 상품 문의 등록(ajax)
	@Override
	public int qnaInsert(ProductQnaQ productQnaQ) {
		return productMapper.qnaInsert(productQnaQ);
	}

	// 상품 문의 정보(ajax)
	@Override
	public ProductQnaQ qnaModifyView(int piqCode) {
		return productMapper.qnaModifyView(piqCode);
	}

	// 상품 문의 수정
	@Override
	public int qnaModify(ProductQnaQ productQnaQ) {
		return productMapper.qnaModify(productQnaQ);
	}

	// 상품문의 삭제(ajax)
	@Override
	public int qnaDelete(int piqCode) {
		
		int result1 = productMapper.qnaDelete(piqCode);
		
		int qnaACount = productMapper.qnaACount(piqCode);
		System.out.println(qnaACount);
		int result2 = 0;
		if(qnaACount > 0) {
			result2 = productMapper.qnaADelete(qnaACount);
		}
		
		return result1 > 0  ? 1 : 0; 
	}

	// 상품문의 목록
	@Override
	public Map<String, Object> qnaAllSelectList(Map<String, Object> mapReturn) {
		
		// 상품문의 게시글 등록 갯수
		int listCount = productMapper.qnaGetListCount(mapReturn);
		// System.out.println("listCount : " + listCount);
		
		int page = Integer.parseInt(mapReturn.get("page") + "");
		// System.out.println("page : " + page);
		
		PageInfo pageInfo = new PageInfo(page, listCount, 10, 10);
		// System.out.println("pageInfo : " + pageInfo);
		
		int startRow = (pageInfo.getPage() - 1) * pageInfo.getBoardLimit() + 1;
		int endRow = startRow + pageInfo.getBoardLimit() - 1;
		mapReturn.put("startRow", startRow);
		mapReturn.put("endRow", endRow);
		// System.out.println(mapReturn);
		
		List<ProductQnaQ> selectList = productMapper.qnaAllSelectList(mapReturn);
		// System.out.println(selectList);
		
		Map<String, Object> mapList = new HashMap<>();
		mapList.put("selectList", selectList);
		mapList.put("pageInfo", pageInfo);
		
		return mapList;
	}

	// 페이징
	@Override
	public PageInfo commonPaging(Map<String, Object> mapReturn) {
		
		// 상품문의 게시글 등록 갯수
		int listCount = productMapper.qnaGetListCount(mapReturn);
		// System.out.println("listCount : " + listCount);
		
		int page = Integer.parseInt(mapReturn.get("page") + "");
		// System.out.println("page : " + page);
		
		PageInfo pageInfo = new PageInfo(page, listCount, 10, 10);
		// System.out.println("pageInfo : " + pageInfo);
		
		return pageInfo;
	}

}
