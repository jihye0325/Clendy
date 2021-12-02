package com.kh.clendy.product.model.service;

import java.util.List;
import java.util.Map;

import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.mypage.model.vo.Coupon;
import com.kh.clendy.product.model.vo.Order;
import com.kh.clendy.product.model.vo.ProductCart;
import com.kh.clendy.product.model.vo.ProductComplete;

public interface ProductOrderService {

	// 회원정보
	Member orderMemberSelect(int userNo);

	// 주문내역
	Map<String, List<Order>> orderInfoSelect(List<ProductCart> cartList);

	// 포인트 조회
	int orderPointSelect(int userNo);

	// 주문 결제
	int order(Map<String, Object> parameters);

	// orderCode 최신
	int orderCodeSelect(int userNo);

	// 주문완료 배송정보
	Map<String, String> completeOrderInfo(Map<String, Integer> parameters);

	// 주문완료 주문내역
	List<ProductComplete> productCompleteList(Map<String, Integer> parameters);

	// 결제정보
	ProductComplete orderPayMentEnd(Map<String, Integer> parameters);


}
