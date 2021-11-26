package com.kh.clendy.product.model.service;

import java.util.List;
import java.util.Map;

import com.kh.clendy.product.model.vo.Product;
import com.kh.clendy.product.model.vo.ProductCart;
import com.kh.clendy.product.model.vo.ProductFilter;
import com.kh.clendy.product.model.vo.ProductOption;

public interface ProductService {

	Map<String, Object> productSelectList(ProductFilter filter);

	Product productViewInfo(Map<String, Object> mapInfo);

	int productViewWish(Map<String, Integer> returnMap);

	Map<String, Object> productTabCount(int pNo);

	List<ProductOption> productOptionSelect(int pNo);

	int productCartInsert(List<ProductCart> cartList);

	
}
