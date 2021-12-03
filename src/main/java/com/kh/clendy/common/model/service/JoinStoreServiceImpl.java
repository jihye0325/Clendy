package com.kh.clendy.common.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.common.model.dao.JoinStoreMapper;
import com.kh.clendy.common.model.vo.ApplyStore;



@Service
@Transactional
public class JoinStoreServiceImpl implements JoinStoreService{

	private JoinStoreMapper joinStoreMapper;
	
	@Autowired
	public JoinStoreServiceImpl(JoinStoreMapper joinStoreMapper) {
		this.joinStoreMapper = joinStoreMapper;
	}

	/* 입점 신청 */
	@Override
	public int applyStore(ApplyStore newStore) {
		return joinStoreMapper.applyStore(newStore);
	}

	/* 스토어 이름 중복 검사 */
	@Override
	public int checkSellerName(String seller_name) {
		return joinStoreMapper.checkSellerName(seller_name);
	}

	/* 사업자번호 중복검사 */
	@Override
	public int checkBLicense(int b_license) {
		return joinStoreMapper.checkBLicense(b_license);
	}

	/* 통신판매업 중복 검사 */
	@Override
	public int checkOBLicense(String o_b_license) {
		return joinStoreMapper.checkOBLicense(o_b_license);
	}

	/* 이미 신청한 유저 검사 */
	@Override
	public int checkUserNo(int user_no) {
		return joinStoreMapper.checkUserNo(user_no);
	}

}
