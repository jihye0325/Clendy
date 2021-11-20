package com.kh.clendy.member.model.vo;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserImpl extends User{
	private int user_no;
	private String id;
	private String password;
	private String user_name;
	private String email;
	private String phone;
	private String address;
	private String gender;
	private String height;
	private String weight;
	private Date sign_date;
	private Date modify_date;
	private String user_status;
	private String temp_pwd_yn;
	/* 한 멤버가 여러 권한 가질 수 있음 - Member_Role과 조인한 결과 값 */
	private List<MemberRole> memberRoleList;	// 보유 권한 목록
	
	public UserImpl(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	// member 객체에서 전달받아서 설정
	public void setDetails(Member member) {
		this.user_no = member.getUser_no();
		this.id = member.getId();
		this.password = member.getPassword();
		this.user_name = member.getUser_name();
		this.email = member.getEmail();
		this.phone = member.getPhone();
		this.address = member.getAddress();
		this.gender = member.getGender();
		this.height = member.getHeight();
		this.weight = member.getWeight();
		this.sign_date = member.getSign_date();
		this.modify_date = member.getModify_date();
		this.user_status = member.getUser_status();
		this.temp_pwd_yn = member.getTemp_pwd_yn();
		this.memberRoleList = member.getMemberRoleList();
	}

	public int getUser_no() {
		return user_no;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public String getGender() {
		return gender;
	}

	public String getHeight() {
		return height;
	}

	public String getWeight() {
		return weight;
	}

	public Date getSign_date() {
		return sign_date;
	}

	public Date getModify_date() {
		return modify_date;
	}

	public String getUser_status() {
		return user_status;
	}

	public String getTemp_pwd_yn() {
		return temp_pwd_yn;
	}

	public List<MemberRole> getMemberRoleList() {
		return memberRoleList;
	}
	
}
