package com.kh.clendy.admin.model.service;

import java.util.List;
import java.util.Map;

import org.apache.catalina.Store;

public interface StoreService {
	
	/* 셀러 전체 리스트 */
	Map<String, Object> selectAllSellerList(int page);
	
	/* 입점 신청 리스트 */
	Map<String, Object> selectAllJoinStoreList(int page);
	
	/* 입점 신청 승인 */
	int admitJoinStore(int a_no, int user_no);
	
	/* 입점취소 신청 리스트 */
	Map<String, Object> selectAllCancelStoreList(int page);
	
	/* 입점 취소 승인 */
	int admitCancelStore(int a_no, int user_no);
	
	
}
