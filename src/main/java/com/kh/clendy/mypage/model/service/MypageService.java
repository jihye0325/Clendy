package com.kh.clendy.mypage.model.service;

import com.kh.clendy.member.model.vo.Member;

public interface MypageService{
	Member selectMember(String id);
	
	int deleteMember(Member member);
	
}
