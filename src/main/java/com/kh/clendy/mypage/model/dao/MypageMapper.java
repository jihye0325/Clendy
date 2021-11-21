package com.kh.clendy.mypage.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.member.model.vo.Member;

@Mapper
public interface MypageMapper {

	Member selectMember(int user_no);

	int modifyMember(Member m);
	
	int deleteMemberRole(int user_no);

	int deleteMember(int user_no);

}
