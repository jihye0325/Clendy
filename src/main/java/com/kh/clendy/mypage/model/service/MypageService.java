package com.kh.clendy.mypage.model.service;

import com.kh.clendy.member.model.vo.Member;

public interface MypageService{
	Member selectMember(int user_no);
	
	int modifyMember(Member m);

	int deleteMember(int user_no);

}
