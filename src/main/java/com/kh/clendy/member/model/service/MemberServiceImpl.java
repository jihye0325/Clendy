package com.kh.clendy.member.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
	private JavaMailSender mailSender;
	
	@Autowired
	public MemberServiceImpl(MemberMapper memberMapper, JavaMailSender mailSender) {
		this.memberMapper = memberMapper;
		this.mailSender = mailSender;
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
		
		
		return user;
	}

	// Member, Member_Role insert, 추천인 적립금 
	@Transactional
	@Override
	public int signUp(Member member, String rec_id) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		
		int result = 0;
		int result1 = memberMapper.insertMember(member);
				
		MemberRole memberRole = new MemberRole();
		memberRole.setAuth_code(1);
		int result2 = memberMapper.insertMemberRole(memberRole);
		
		// 회원가입 적립금
		int result3 = memberMapper.addPoint(member.getUser_no());
		
		if(rec_id != "") {
			// 추천인 적립금
			int result4 = memberMapper.addRecPoint(member.getId(), rec_id);	
			if(result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0)
				result = 1;
		} else {
			// 추천인 없을 때
			if(result1 > 0 && result2 > 0 && result3 > 0)
				result = 1;
		}

		return result;
	}

	// 아이디 찾기
	@Override
	public String findId(String user_name, String phone) {
		return memberMapper.findId(user_name, phone);
	}

	// 추천인 아이디찾기
	@Override
	public String findMember(String rec_id) {
		return memberMapper.findMember(rec_id);
	}

	// 아이디 중복검사
	@Override
	public int idCheck(String id) {
		return memberMapper.idCheck(id);
	}

	// 전화번호 중복검사
	@Override
	public int phoneCheck(String phone) {
		return memberMapper.phoneCheck(phone);
	}

	// 이메일 전송
	@Override
	public void sendEmail(Member member, String tempPwd) {		
		// 보내는 사람 Email, 제목, 내용
		String fromEmail = "clendy1210@gmail.com";
		String subject = "";
		String msg = "";
		
		subject = "Clendy 임시비밀번호입니다.";
		msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
		msg += "<h4 style='color: black;'>";
		msg += member.getUser_name() + "님의 임시 비밀번호 입니다. 로그인 후 비밀번호를 변경하여 사용하세요.</h3>";
		msg += "<p style='color:red;'>임시 비밀번호 : ";
		msg += tempPwd + "</p></div>";
		
		// 받는 사람 E-Mail주소
			String mail = member.getEmail();
			MimeMessage message = mailSender.createMimeMessage();
		 
	        try {
				message.addRecipient(RecipientType.TO, new InternetAddress(mail));
		        message.setFrom(fromEmail);
		        message.setSubject(subject, "UTF-8");
		        message.setText(msg, "UTF-8", "html");

			} catch (MessagingException e) {
				e.printStackTrace();
			}

	        mailSender.send(message);
	}

	@Override
	public int findMemberById_Email(Member member, HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		int result = 0;
		Member m = memberMapper.findMemberById_Email(member.getId(), member.getEmail());
		System.out.println(m);
		if(m == null) {
			result = 0;
		} else {
			// 임시비밀번호 생성
			String tempPwd =""; 
			for (int i = 0; i < 12; i++) {
				tempPwd += (char) ((Math.random() * 26) + 97);
			}
			
			// 비밀번호 변경 메일 발송
			sendEmail(m, tempPwd);
			
			// 임시비밀번호로 변경
			// 암호화
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			
			m.setPassword(passwordEncoder.encode(tempPwd));
			memberMapper.updatePwd(m);
			
			result = 1;
		}
		
		return result;
	}
	



	
	
	
	
}
