package com.kh.clendy.admin.model.service;

import java.util.Map;

public interface StoreService {
	
	/* 셀러 전체 리스트 */
	Map<String, Object> selectAllSellerList(int page);
	
	/* 입점 신청 리스트 */
	Map<String, Object> selectAllJoinStoreList(int page);
	
	/* 판매자 관리에서 입점 취소 */
	int admitCancelStoreInSellerList(int seller_code, int user_no);
	
	/* 입점 신청 승인 */
	int admitJoinStore(int a_no, int user_no);
	
	/* 입점취소 신청 리스트 */
	Map<String, Object> selectAllCancelStoreList(int page);
	
	/* 입점 취소 승인 */
	int admitCancelStore(int a_no, int user_no);


	
	
}
