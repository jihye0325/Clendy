package com.kh.clendy.mypage.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.member.model.vo.Authority;
import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.member.model.vo.MemberRole;
import com.kh.clendy.member.model.vo.UserImpl;
import com.kh.clendy.mypage.model.dao.MypageMapper;

@Service	
public class MypageServiceImpl implements MypageService {

	private MypageMapper mypageMapper;
	
	@Autowired
	public MypageServiceImpl(MypageMapper mypageMapper) {
		this.mypageMapper = mypageMapper;
	}
	
		
	// 로그인한 아이디로 해당 유저 정보 읽어오기
	@Override
	public Member selectMember(String id) {
		Member member = mypageMapper.selectMember(id);
		
		return member;
	}
	
	// Member_Role, Member에서 delete 처리
	@Transactional
	@Override
	public int deleteMember(Member member) {
		int result = 0;
		
		int result1 = mypageMapper.deleteMemberRole(member);

		int result2 = mypageMapper.deleteMember(member);
	
		if(result1 > 0 && result2 > 0)
			result = 1;
		
		return result;
	}

}
