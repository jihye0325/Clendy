package com.kh.clendy.joinStore.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.joinStore.model.dao.JoinStoreMapper;
import com.kh.clendy.joinStore.model.vo.ApplyStore;

@Service
@Transactional
public class JoinStoreServiceImpl implements JoinStoreService{

	private JoinStoreMapper joinStoreMapper;
	
	
	@Autowired
	public JoinStoreServiceImpl(JoinStoreMapper joinStoreMapper) {
		this.joinStoreMapper = joinStoreMapper;
	}

	@Override
	public int applyStore(ApplyStore newStore) {
		return joinStoreMapper.applyStore(newStore);
	}

}
