package com.kh.clendy.joinStore.model.service;

import com.kh.clendy.joinStore.model.vo.ApplyStore;

public interface JoinStoreService {
	
	/* 입점신청 */
	int applyStore(ApplyStore newStore);
	
	/* 스토어 이름 중복 검사 */
	int checkSellerName(String seller_name);
	
	/* 사업자등록번호 중복 검사 */
	int checkBLicense(int b_license);
	
	/* 통신판매업신고번호 중복 검사 */
	int checkOBLicense(String o_b_license);
}
