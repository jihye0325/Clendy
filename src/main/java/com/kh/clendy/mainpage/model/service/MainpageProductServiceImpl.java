package com.kh.clendy.mainpage.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.mainpage.model.dao.MainpageMapper;
import com.kh.clendy.mainpage.model.service.MainpageService;
import com.kh.clendy.mainpage.model.vo.MainProduct;

@Service
@Transactional
public class MainpageProductServiceImpl implements MainpageService {
	
	private MainpageMapper mainpageMapper;
	
	@Autowired
	public MainpageProductServiceImpl(MainpageMapper mainpageMapper) {
		this.mainpageMapper = mainpageMapper;
	}

	@Override
	public List<MainProduct> selectMainProdudct() {
		List<MainProduct> mainpageProductList = mainpageMapper.selectMainProduct();
		return mainpageProductList;
		
	}

}
