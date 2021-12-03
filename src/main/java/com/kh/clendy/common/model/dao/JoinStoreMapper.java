package com.kh.clendy.common.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.common.model.vo.ApplyStore;

@Mapper
public interface JoinStoreMapper {
	
		/* 입점 신청 */
		int applyStore(ApplyStore newStore);
		
		/* 입점 신청한 유저 번호 검사 */
		int checkUserNo(int user_no);
		
		/* 스토어 이름 중복 검사 */
		int checkSellerName(String seller_name);
		
		/* 사업자등록번호 중복 검사 */
		int checkBLicense(int b_license);
		
		/* 통신판매업신고번호 중복 검사 */
		int checkOBLicense(String o_b_license);
	
}
