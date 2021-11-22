package com.kh.clendy.product.model.service;

import java.util.Map;

import com.kh.clendy.product.model.vo.Product;

public interface ProductService {

	Map<String, Object> productSelectList(int page);

	Product productViewInfo(Map<String, Object> mapInfo);

	int productViewWish(Map<String, Integer> returnMap);

	
}
