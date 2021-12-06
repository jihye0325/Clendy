package com.kh.clendy.admin.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.admin.model.dao.StoreMapper;
import com.kh.clendy.admin.model.vo.CancelStore;
import com.kh.clendy.admin.model.vo.Seller;
import com.kh.clendy.common.model.vo.ApplyStore;
import com.kh.clendy.product.model.vo.PageInfo;

@Service
@Transactional
public class StoreServiceImpl implements StoreService{
	
	private final StoreMapper storeMapper;
	
	@Autowired
	public StoreServiceImpl(StoreMapper storeMapper) {
		this.storeMapper = storeMapper;
	}

	/* 스토어 전체 목록 리스트 */
	@Override
	public Map<String, Object> selectAllSellerList(int page) {
		// 공지사항 개수 
		int listCount = storeMapper.sellerGetListCount();
		
		// 페이징 
		PageInfo pageInfo = new PageInfo(page, listCount, 10, 10);
		
		// 목록 호출에 필요한 값
		int startRow = (pageInfo.getPage()-1) * pageInfo.getBoardLimit() + 1;
		int endRow = startRow + pageInfo.getBoardLimit() -1;
		
		// 목록 호출에 넘기는 값
		Map<String, Object> mapMapper = new HashMap<>();
		mapMapper.put("page", page);
		mapMapper.put("startRow", startRow);
		mapMapper.put("endRow", endRow);
		
		// 목록 조회
		List<Seller> sellerList = storeMapper.selectAllSellerList(mapMapper);
		
		Map<String, Object> result = new HashMap<>();
		result.put("sellerList", sellerList);
		result.put("pi", pageInfo);
		
		return result;
	}
	
	/* 판매자페이지에서 입점 취소 */
	@Override
	public int admitCancelStoreInSellerList(int seller_code, int user_no) {
		
		int changeUserAuth = storeMapper.changeUserAuthToUser(user_no);
		int updateSellerStatus = storeMapper.updateSellerStatus(seller_code);
		
		return changeUserAuth+updateSellerStatus;
	}
	
	/* 입점 신청 리스트, 페이징*/
	@Override
	public Map<String, Object> selectAllJoinStoreList(int page) {
		// 공지사항 개수 
		int listCount = storeMapper.joinStoreGetListCount();
		
		// 페이징 
		PageInfo pageInfo = new PageInfo(page, listCount, 10, 8);
		
		// 목록 호출에 필요한 값
		int startRow = (pageInfo.getPage()-1) * pageInfo.getBoardLimit() + 1;
		int endRow = startRow + pageInfo.getBoardLimit() -1;
		
		// 목록 호출에 넘기는 값
		Map<String, Object> mapMapper = new HashMap<>();
		mapMapper.put("page", page);
		mapMapper.put("startRow", startRow);
		mapMapper.put("endRow", endRow);
		
		// 목록 조회
		List<ApplyStore> applyStoreList = storeMapper.selectAllJoinStoreList(mapMapper);
		
		Map<String, Object> result = new HashMap<>();
		result.put("applyStoreList", applyStoreList);
		result.put("applyPi", pageInfo);
		
		return result;
	}

	/* 입점 취소 신청 리스트, 페이징 */
	@Override
	public Map<String, Object> selectAllCancelStoreList(int page) {
		// 공지사항 개수 
		int listCount = storeMapper.cancelStoreGetListCount();
		
		// 페이징 
		PageInfo pageInfo = new PageInfo(page, listCount, 10, 8);
		
		// 목록 호출에 필요한 값
		int startRow = (pageInfo.getPage()-1) * pageInfo.getBoardLimit() + 1;
		int endRow = startRow + pageInfo.getBoardLimit() -1;
		
		// 목록 호출에 넘기는 값
		Map<String, Object> mapMapper = new HashMap<>();
		mapMapper.put("page", page);
		mapMapper.put("startRow", startRow);
		mapMapper.put("endRow", endRow);
		
		// 목록 조회
		List<CancelStore> cancelStoreList = storeMapper.selectAllCancelStoreList(mapMapper);
		
		Map<String, Object> result = new HashMap<>();
		result.put("cancelStoreList", cancelStoreList);
		result.put("cancelPi", pageInfo);
		
		return result;
	}

	/* 입점 신청 승인 */
	@Override
	public int admitJoinStore(int a_no, int user_no) {
		
		int insertSeller = storeMapper.admitJoinStore(a_no);
		int changeUserAuth = storeMapper.changeUserAuthToSeller(user_no);
		
		return insertSeller + changeUserAuth;
	}

	/* 입점 취소 승인 */
	@Override
	public int admitCancelStore(int can_no, int user_no) {

		int updateSeller = storeMapper.admitCancelStore(can_no);
		int changeUserAuth = storeMapper.changeUserAuthToUser(user_no);
		int updateCancelDate = storeMapper.insertAdmitCancelDate(can_no);
		
		return updateSeller + changeUserAuth + updateCancelDate;
	}




	
	

}
