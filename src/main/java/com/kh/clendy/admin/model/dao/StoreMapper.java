package com.kh.clendy.admin.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.admin.model.vo.CancelStore;
import com.kh.clendy.admin.model.vo.Seller;
import com.kh.clendy.common.model.vo.ApplyStore;

@Mapper
public interface StoreMapper {
	
	/* 스토어 전체 리스트 */
	int sellerGetListCount();
	List<Seller> selectAllSellerList(Map<String, Object> mapMapper);
	
	/* 판매자관리에서 입점 취소 */
	int updateSellerStatus(int seller_code);
	
	// 입점신청리스트 전체 개수 - 페이징
	int joinStoreGetListCount();
	List<ApplyStore> selectAllJoinStoreList(Map<String, Object> mapMapper);
	
	/* 입점 신청 승인 */
	int admitJoinStore(int a_no);
	
	/* 입점 신청 승인 후 판매자 권한 부여 */
	int changeUserAuthToSeller(int user_no);

	// 입점 취소 신청 리스트 전체 개수 - 페이징
	int cancelStoreGetListCount();
	List<CancelStore> selectAllCancelStoreList(Map<String, Object> mapMapper);
	
	/* 입점 취소 승인 */
	int admitCancelStore(int can_no);
	/* 입점 취소 승인 날짜 입력 */
	int insertAdmitCancelDate(int can_no);
	/* 입점 취소 후 일반회원으로 권한 부여 */
	int changeUserAuthToUser(int user_no);

	

}
