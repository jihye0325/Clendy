package com.kh.clendy.sellerProduct.model.service;

import java.util.List;

import com.kh.clendy.sellerProduct.model.vo.ProductList;
import com.kh.clendy.sellerProduct.model.vo.SellerProduct;
import com.kh.clendy.sellerProduct.model.vo.SellerProductCategory;

public interface SellerProductService {
	
	int registNewProduct(SellerProduct newSellerProduct);

	List<SellerProductCategory> findAllCategory();

	List<ProductList> selectProductList();

	List<ProductList> selectProductListById();

	List<SellerProduct> sellerProductList();
}