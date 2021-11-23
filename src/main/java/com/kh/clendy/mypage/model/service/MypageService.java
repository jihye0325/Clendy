package com.kh.clendy.mypage.model.service;

import java.util.List;

import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.mypage.model.vo.Point;

public interface MypageService{
	Member selectMember(int user_no);
	
	int modifyMember(Member m);

	int deleteMember(int user_no);

	List<Point> selectPoint(int user_no);

}
