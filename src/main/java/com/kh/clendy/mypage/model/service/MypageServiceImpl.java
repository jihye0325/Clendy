package com.kh.clendy.mypage.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.mypage.model.dao.MypageMapper;
import com.kh.clendy.mypage.model.vo.Coupon;
import com.kh.clendy.mypage.model.vo.Point;
import com.kh.clendy.mypage.model.vo.Wishlist;

@Service	
public class MypageServiceImpl implements MypageService {

	private MypageMapper mypageMapper;
	
	@Autowired
	public MypageServiceImpl(MypageMapper mypageMapper) {
		this.mypageMapper = mypageMapper;
	}
	
		
	// 로그인한 user_no로 해당 유저 정보 읽어오기	
	@Override
	public Member selectMember(int user_no) {
		Member m = mypageMapper.selectMember(user_no);
		
		return m;
	}
	
	// 회원정보 수정
	@Override
	public int modifyMember(Member m) {
		
		int result = mypageMapper.modifyMember(m);
		
		if(result > 0)
			System.out.println("수정 성공");
		else 
			System.out.println("수정 실패");
		
		return result;
	}
	
	// Member_Role, Member에서 delete 처리
	@Transactional
	@Override
	public int deleteMember(int user_no) {
		int result = 0;
		
		int result1 = mypageMapper.deleteMemberRole(user_no);

		int result2 = mypageMapper.deleteMember(user_no);

		System.out.println(result1);
		System.out.println(result2);
		
		if(result1 > 0 && result2 > 0)
			result = 1;
		
		return result;
	}

	// 적립금 리스트 불러오기
	@Override
	public List<Point> selectPoint(int user_no) {
		List<Point> point_list = mypageMapper.selectPoint(user_no);
		
		System.out.println(point_list);
		
		return point_list;
	}

	// 사용가능 쿠폰 리스트
	@Override
	public List<Coupon> selectCou_List(int user_no) {
		List<Coupon> cou_list = mypageMapper.selectCou_List(user_no);
		return cou_list;
	}

	// 사용만료 쿠폰 리스트
	@Override
	public List<Coupon> selectDisable_Cou_List(int user_no) {
		List<Coupon> disable_cou_list = mypageMapper.selectDisable_Cou_List(user_no);
		return disable_cou_list;
	}

	// 사용완료 쿠폰 리스트
	@Override
	public List<Coupon> selectUse_Cou_List(int user_no) {
		List<Coupon> use_cou_list = mypageMapper.selectUse_Cou_List(user_no);
		return use_cou_list;
	}

	// 위시리스트 불러오기
	@Override
	public List<Wishlist> selectWishlist(int user_no) {
		List<Wishlist> wish_list = mypageMapper.selectWishlist(user_no);
		return wish_list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
