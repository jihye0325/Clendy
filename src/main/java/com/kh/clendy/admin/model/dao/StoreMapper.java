package com.kh.clendy.admin.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.admin.model.vo.CancelStore;
import com.kh.clendy.joinStore.model.vo.ApplyStore;

@Mapper
public interface StoreMapper {
	
	// 입점신청리스트 전체 개수 - 페이징
	int joinStoreGetListCount();
	List<ApplyStore> selectAllJoinStoreList(Map<String, Object> mapMapper);

	// 입점 취소 신청 리스트 전체 개수 - 페이징
	int cancelStoreGetListCount();
	List<CancelStore> selectAllCancelStoreList(Map<String, Object> mapMapper);

}
