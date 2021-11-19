package com.kh.clendy.member.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.member.model.vo.Member;


@Mapper
public interface MemberMapper {
	// 아이디를 가진 사용자 정보를 조회해와서 패스워드 비교는 스프링 시큐리티 모듈이 처리
	// DB에서 id, pwd를 비교하는 것이 아니라 BCryptEncoder 객체가 가진 matches 메소드를 통해 비교함
	// salt가 첨가되므로 매번 다른 문자열이 나옴
	Member findMemberById(String username);
	
	
	
	
}