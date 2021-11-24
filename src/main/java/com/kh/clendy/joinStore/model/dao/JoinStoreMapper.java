package com.kh.clendy.joinStore.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.joinStore.model.vo.ApplyStore;

@Mapper
public interface JoinStoreMapper {
	
		int applyStore(ApplyStore newStore);
	
}
