package com.kh.clendy.product.model.service;

import java.util.List;
import java.util.Map;

import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.mypage.model.vo.Coupon;
import com.kh.clendy.product.model.vo.Order;
import com.kh.clendy.product.model.vo.ProductCart;

public interface ProductOrderService {

	// 회원정보
	Member orderMemberSelect(int userNo);

	// 주문내역
	Map<String, List<Order>> orderInfoSelect(Map<String, List<ProductCart>> cartMap);

	// 포인트 조회
	int orderPointSelect(int userNo);

	List<Coupon> orderCouponSelectList(int userNo);

}
