package com.kh.clendy.common.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.common.model.dao.SearchProductMapper;
import com.kh.clendy.product.model.vo.Product;

@Service
@Transactional
public class SearchProductServiceImpl implements SearchProductService{
	
	private final SearchProductMapper searchProductMapper;
	
	public SearchProductServiceImpl(SearchProductMapper searchProductMapper) {
		this.searchProductMapper = searchProductMapper;
	}

	@Override
	public List<Product> searchProductList(String keyword) {
		return searchProductMapper.searchProductList(keyword);
	}

	@Override
	public int countSearchProductList(String keyword) {
		return searchProductMapper.countSearchProductList(keyword);
	}

}
