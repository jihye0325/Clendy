package com.kh.clendy.mypage.model.service;

import java.util.List;

import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.mypage.model.vo.Coupon;
import com.kh.clendy.mypage.model.vo.Point;
import com.kh.clendy.mypage.model.vo.Wishlist;
import com.kh.clendy.product.model.vo.ProductQnaQ;

public interface MypageService{
	Member selectMember(int user_no);
	
	int modifyMember(Member m);

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
