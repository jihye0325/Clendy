package com.kh.clendy.sellerProduct.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.sellerProduct.model.vo.SellerProduct;
import com.kh.clendy.sellerProduct.model.vo.SellerProductCategory;

@Mapper
public interface SellerProductMapper {
	
	int registNewProduct(SellerProduct newSellerProduct);

	List<SellerProductCategory> findAllCategory();
}