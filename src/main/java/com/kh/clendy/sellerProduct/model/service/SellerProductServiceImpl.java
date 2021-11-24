package com.kh.clendy.sellerProduct.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.clendy.sellerProduct.model.dao.SellerProductMapper;
import com.kh.clendy.sellerProduct.model.vo.SellerProduct;
import com.kh.clendy.sellerProduct.model.vo.SellerProductCategory;

@Service
public class SellerProductServiceImpl implements SellerProductService {

	private SellerProductMapper sellerProductMapper;
	
	@Autowired
	public SellerProductServiceImpl(SellerProductMapper sellerProductMapper) {
		this.sellerProductMapper = sellerProductMapper;
	}
	
	@Override
	public int registNewProduct(SellerProduct newSellerProduct) {
		return sellerProductMapper.registNewProduct(newSellerProduct);
	}

	@Override
	public List<SellerProductCategory> findAllCategory() {
		return sellerProductMapper.findAllCategory();
	}
}