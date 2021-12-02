package com.kh.clendy.product.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.product.model.vo.Order;
import com.kh.clendy.product.model.vo.ProductCart;
import com.kh.clendy.product.model.vo.ProductComplete;

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

	// orderCode 가져오기
	int orderCodeSelect(int userNo);

	// 주문완료 - 배송정보
	Map<String, String> completeOrderInfo(Map<String, Integer> parameters);

	// 주문완료 주문내역
	List<ProductComplete> productCompleteList(Map<String, Integer> parameters);

	// 결제정보
	ProductComplete orderPayMentEnd(Map<String, Integer> parameters);

	
	

	


}
