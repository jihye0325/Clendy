package com.kh.clendy.product.model.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.product.model.vo.Order;
import com.kh.clendy.product.model.vo.ProductCart;

@Mapper
public interface ProductOrderMapper {

	// 회원 정보
	Member orderMemberSelect(int userNo);

	// 주문 내역
	Order orderInfoSelect(ProductCart cart);

	// 포인트 조회
	int orderPointSelect(int userNo);

	// 상품 주문목록 추가
	int orderProductOrder(Map<String, Object> parameters);
	
	// 상품 주문옵션 추가
	int orderOrderOption(ProductCart cart);

	// 포인트 차감
	int orderPoint(Map<String, Object> parameters);

	// 상품 주문 배송지 관리 추가
	int orderDelInfo(Map<String, Object> parameters);

	// 상품 주문 재고 재설정
	int orderStock(ProductCart cart);

	// 결제 PAYMENT 추가
	int orderPayment(Map<String, Object> parameters);
	
	

	


}
