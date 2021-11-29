package com.kh.clendy.product.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.mypage.model.vo.Coupon;
import com.kh.clendy.product.model.dao.ProductOrderMapper;
import com.kh.clendy.product.model.vo.Order;
import com.kh.clendy.product.model.vo.ProductCart;
import com.kh.clendy.product.service.ProductOrderService;

@Service
@Transactional
public class ProductOrderServiceImpl implements ProductOrderService{
	
	private ProductOrderMapper productOrderMapper;
	
	public ProductOrderServiceImpl(ProductOrderMapper productOrderMapper) {
		this.productOrderMapper = productOrderMapper;
	}

	// 회원 정보 조회
	@Override
	public Member orderMemberSelect(int userNo) {
		return productOrderMapper.orderMemberSelect(userNo);
	}

	// 주문 내역
	@Override
	public Map<String, List<Order>> orderInfoSelect(Map<String, List<ProductCart>> cartMap) {
		Map<String, List<Order>> returnMap = new HashMap<>();
		
		int result = 0;
		
		Iterator<String> keys = cartMap.keySet().iterator();
		while(keys.hasNext()) {
			
			
			String key = keys.next();
			
			List<ProductCart> lists = cartMap.get(key);
			List<Order> newList = new ArrayList<>();
			
			for(ProductCart cart : lists) {
				Order order = productOrderMapper.orderInfoSelect(cart);
				newList.add(order);
			}
			
			returnMap.put(key, newList);
		}
		
		return returnMap;
	}

	// 포인트 조회
	@Override
	public int orderPointSelect(int userNo) {
		return productOrderMapper.orderPointSelect(userNo);
	}

	// 쿠폰 조회
	@Override
	public List<Coupon> orderCouponSelectList(int userNo) {
		return productOrderMapper.orderCouponSelectList(userNo);
	}

}
