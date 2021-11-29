package com.kh.clendy.product.model.dao;

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

}
