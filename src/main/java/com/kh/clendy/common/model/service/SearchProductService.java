package com.kh.clendy.common.model.service;

import java.util.List;

import com.kh.clendy.product.model.vo.Product;

public interface SearchProductService {

	List<Product> searchProductList(String keyword);
	
	int countSearchProductList(String keyword);
}
