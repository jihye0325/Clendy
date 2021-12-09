package com.kh.clendy.sellerAsk.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.product.model.vo.PageInfo;
import com.kh.clendy.sellerAsk.model.dao.SellerAskMapper;
import com.kh.clendy.sellerAsk.model.vo.SellerAsk;

@Service
@Transactional
public class SellerAskServiceImpl  implements SellerAskService{
	
	private SellerAskMapper sellerAskMapper;
	
	@Autowired
	public SellerAskServiceImpl(SellerAskMapper sellerAskMapper) {
		this.sellerAskMapper = sellerAskMapper;
	}

	@Override
	public Map<String, Object> selectAskAllList(int page, int user_no) {
		
		int listCount = sellerAskMapper.sellerAskListCount(user_no);
		
		PageInfo pageInfo = new PageInfo(page, listCount, 10, 10);
		
		int startRow = (pageInfo.getPage()-1) * pageInfo.getBoardLimit() + 1;
		int endRow = startRow + pageInfo.getBoardLimit() -1;
		
		Map<String, Object> mapMapper = new HashMap<>();
		mapMapper.put("user_no", user_no);
		mapMapper.put("page", page);
		mapMapper.put("startRow", startRow);
		mapMapper.put("endRow", endRow);
		
		List<SellerAsk> selectAskAllList = sellerAskMapper.selectAskAllList(mapMapper);
		
		Map<String, Object> result = new HashMap<>();
		result.put("selectAskAllList", selectAskAllList);
		result.put("pageInfo", pageInfo);
		
		return result;
	}

}
