package com.kh.clendy.mypage.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.mypage.model.vo.Coupon;
import com.kh.clendy.mypage.model.vo.Point;
import com.kh.clendy.mypage.model.vo.Wishlist;
import com.kh.clendy.product.model.vo.ProductQnaQ;

@Mapper
public interface MypageMapper {

	Member selectMember(int user_no);

	int modifyMember(Member m);
	
	int deleteMemberRole(int user_no);

	int deleteMember(int user_no);

	List<Point> selectPoint(int user_no);

	List<Coupon> selectCou_List(int user_no);

	List<Coupon> selectDisable_Cou_List(int user_no);

	List<Coupon> selectUse_Cou_List(int user_no);

	Wishlist selectOuterlist(int user_no);

	Wishlist selectToplist(int user_no);

	Wishlist selectBottomlist(int user_no);

	Wishlist selectAcclist(int user_no);
	
	List<ProductQnaQ> selectP_Qna_List(int user_no);


}
