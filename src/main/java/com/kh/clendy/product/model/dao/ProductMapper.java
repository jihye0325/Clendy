package com.kh.clendy.product.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.product.model.vo.Product;
import com.kh.clendy.product.model.vo.ProductCart;
import com.kh.clendy.product.model.vo.ProductFilter;
import com.kh.clendy.product.model.vo.ProductOption;

@Mapper
public interface ProductMapper {

	// 상품 목록 갯수
	int productGetListCount(ProductFilter filter);
	
	// 상품목록
	List<Product> productSelectList(Map<String, Object> mapMapper);

	// 상품 상세 정보
	Product productViewInfo(Map<String, Object> mapInfo);
	
	int productViewIsWish(Map<String, Integer> returnMap);

	// 위시리스트 추가
	int productViewInsertWish(Map<String, Integer> returnMap);

	// 위시리스트 삭제
	int productViewDeleteWish(Map<String, Integer> returnMap);

	Map<String, Object> productTabCount(int pNo);

	List<ProductOption> productOptionSelect(int pNo);

	int cartGetCount(ProductCart productCart);

	int productCartInsert(ProductCart productCart);

	int productCartUpdate(ProductCart productCart);

	Map<String, Integer> productCategoryCount(ProductFilter filter);

	

	

	
}
