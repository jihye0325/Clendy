package com.kh.clendy.common.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.product.model.vo.Product;

@Mapper
public interface SearchProductMapper {
	
	List<Product> searchProductList(String keyword);
	
	int countSearchProductList(String keyword);

}
