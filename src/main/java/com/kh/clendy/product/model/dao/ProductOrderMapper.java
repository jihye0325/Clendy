package com.kh.clendy.product.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.mypage.model.vo.Coupon;
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

	// 쿠폰 조회
	List<Coupon> orderCouponSelectList(int userNo);

}
