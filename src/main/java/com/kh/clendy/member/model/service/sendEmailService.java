package com.kh.clendy.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.clendy.member.dto.MailDto;
import com.kh.clendy.member.model.dao.MemberMapper;

@Service
public class sendEmailService {

	private static MemberMapper memberMapper;
	
	@Autowired
	public sendEmailService(MemberMapper memberMapper) {
		sendEmailService.memberMapper = memberMapper;
	}
	
	private static JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "clendy1210@gmail.com";
    
    public static MailDto createMailAndChangePassword(String email, String id){
        String pwd = getTempPassword();
        MailDto dto = new MailDto(pwd, pwd, pwd);
        dto.setAddress(email);
        dto.setTitle("Clendy 임시비밀번호 안내 이메일 입니다.");
        dto.setMessage("안녕하세요. Clendy 임시비밀번호 안내 관련 이메일 입니다." + "[" + id + "]" +"님의 임시 비밀번호는 "
        + pwd + " 입니다.");
        updatePassword(id, pwd);
        return dto;        
    }
    
    public static void updatePassword(String id, String pwd){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String tmpPwd = passwordEncoder.encode(pwd);
        memberMapper.updatePassword(id, tmpPwd);
    }


    public static String getTempPassword(){
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        return str;
    }
    
    public static void mailSend(MailDto mailDto){
        System.out.println("이메일 전송 완료!");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDto.getAddress());
        message.setFrom(sendEmailService.FROM_ADDRESS);
        message.setSubject(mailDto.getTitle());
        message.setText(mailDto.getMessage());

        mailSender.send(message);
    }
    
    
    
    
    
    
    
    
    
    
}
