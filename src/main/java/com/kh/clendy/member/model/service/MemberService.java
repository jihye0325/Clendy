package com.kh.clendy.member.model.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.kh.clendy.member.model.vo.Member;

/* 스프링 시큐리티에서 제공하는 기능 이용해야 하므로 UserDetailsService 상속 */
public interface MemberService extends UserDetailsService{

	int signUp(Member member, String rec_id);

	String findId(String user_name, String phone);

	String findMember(String rec_id);

	int idCheck(String id);

	int phoneCheck(String phone);

	void sendEmail(Member member, String div);

	int findMemberById_Email(Member member, HttpServletResponse response);

}
