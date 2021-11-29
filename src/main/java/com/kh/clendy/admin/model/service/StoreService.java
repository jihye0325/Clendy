package com.kh.clendy.admin.model.service;

import java.util.List;
import java.util.Map;

import org.apache.catalina.Store;

public interface StoreService {
	
	/* 입점승인 신청 리스트 */
	Map<String, Object> selectAllJoinStoreList(int page);
	
	/* 입점취소 신청 리스트 */
	Map<String, Object> selectAllCancelStoreList(int page);
	
	
}
