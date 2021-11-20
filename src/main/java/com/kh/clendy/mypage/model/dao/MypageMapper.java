package com.kh.clendy.mypage.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.member.model.vo.Member;

@Mapper
public interface MypageMapper {

	Member selectMember(String id);
	
	int deleteMemberRole(Member member);

	int deleteMember(Member member);

}
