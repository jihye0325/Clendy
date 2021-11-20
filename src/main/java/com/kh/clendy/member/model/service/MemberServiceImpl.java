package com.kh.clendy.member.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.member.model.dao.MemberMapper;
import com.kh.clendy.member.model.vo.Authority;
import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.member.model.vo.MemberRole;
import com.kh.clendy.member.model.vo.UserImpl;

@Service
public class MemberServiceImpl implements MemberService{

	private MemberMapper memberMapper;
	
	@Autowired
	public MemberServiceImpl(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	/* 사용자 아이디를 통해 사용자 정보 조회하는 기능 */
	/* String username : 사용자가 입력한 아이디를 모듈을 통해 받아옴 */	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/* 만들어둔 타입으로 유저 조회 */
		Member member = memberMapper.findMemberById(username);
		
		/* null 값 없도록 조회된 값 없으면 빈 객체 */
		if(member == null) {
			member = new Member();
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		if(member.getMemberRoleList() != null) {
			List<MemberRole> roleList = member.getMemberRoleList();
			
			for(MemberRole role : roleList) {
				Authority authority = role.getAuthority();
				
				if(authority != null) {
					authorities.add(new SimpleGrantedAuthority(authority.getAuth_name()));
				}
			}
		}
		
		/* Member의 id, password 외의 다른 정보를 담기 위해 User를 상속한 UserImpl 만들고 해당 타입으로  처리*/
		UserImpl user = new UserImpl(member.getId(), member.getPassword(), authorities);
		user.setDetails(member);
		
		System.out.println("확인!! : " + user);
		
		return user;
	}

	// Member, Member_Role에 insert 처리 			// ++ 추천인 로직 
	@Transactional
	@Override
	public void signUp(Member member) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		memberMapper.insertMember(member);
		
		MemberRole memberRole = new MemberRole();
		memberRole.setAuth_code(1);
		memberMapper.insertMemberRole(memberRole);
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
