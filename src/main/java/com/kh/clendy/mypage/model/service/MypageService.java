package com.kh.clendy.mypage.model.service;

import java.util.List;

import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.mypage.model.vo.Coupon;
import com.kh.clendy.mypage.model.vo.Point;
import com.kh.clendy.mypage.model.vo.Wishlist;

public interface MypageService{
	Member selectMember(int user_no);
	
	int modifyMember(Member m);

	int deleteMember(int user_no);

	List<Point> selectPoint(int user_no);

	List<Coupon> selectCou_List(int user_no);

	List<Coupon> selectDisable_Cou_List(int user_no);

	List<Coupon> selectUse_Cou_List(int user_no);

	List<Wishlist> selectWishlist(int user_no);

}
