package com.kh.clendy.mainpage.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.mainpage.model.vo.MainProduct;

@Mapper
public interface MainpageMapper {

	List<MainProduct> selectMainProduct();

}
