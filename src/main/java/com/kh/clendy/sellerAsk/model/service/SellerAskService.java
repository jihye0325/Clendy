package com.kh.clendy.sellerAsk.model.service;

import java.util.Map;

import com.kh.clendy.sellerAsk.model.vo.SellerAsk;

public interface SellerAskService {

	Map<String, Object> selectAskAllList(int page, int user_no);


}
