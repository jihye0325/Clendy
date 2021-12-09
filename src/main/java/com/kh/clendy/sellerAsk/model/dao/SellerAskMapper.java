package com.kh.clendy.sellerAsk.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.sellerAsk.model.vo.SellerAsk;

@Mapper
public interface SellerAskMapper {

	int sellerAskListCount(int user_no);

	List<SellerAsk> selectAskAllList(Map<String, Object> mapMapper);



}
