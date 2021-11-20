package com.kh.clendy.member.model.vo;

import java.util.Date;
import java.util.List;

public class Member {
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
	
	public Member() {}

	public Member(int user_no, String id, String password, String user_name, String email, String phone, String address,
			String gender, String height, String weight, Date sign_date, Date modify_date, String user_status,
			String temp_pwd_yn, List<MemberRole> memberRoleList) {
		super();
		this.user_no = user_no;
		this.id = id;
		this.password = password;
		this.user_name = user_name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.sign_date = sign_date;
		this.modify_date = modify_date;
		this.user_status = user_status;
		this.temp_pwd_yn = temp_pwd_yn;
		this.memberRoleList = memberRoleList;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Date getSign_date() {
		return sign_date;
	}

	public void setSign_date(Date sign_date) {
		this.sign_date = sign_date;
	}

	public Date getModify_date() {
		return modify_date;
	}

	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}

	public String getUser_status() {
		return user_status;
	}

	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}

	public String getTemp_pwd_yn() {
		return temp_pwd_yn;
	}

	public void setTemp_pwd_yn(String temp_pwd_yn) {
		this.temp_pwd_yn = temp_pwd_yn;
	}

	public List<MemberRole> getMemberRoleList() {
		return memberRoleList;
	}

	public void setMemberRoleList(List<MemberRole> memberRoleList) {
		this.memberRoleList = memberRoleList;
	}

	@Override
	public String toString() {
		return "Member [user_no=" + user_no + ", id=" + id + ", password=" + password + ", user_name=" + user_name
				+ ", email=" + email + ", phone=" + phone + ", address=" + address + ", gender=" + gender + ", height="
				+ height + ", weight=" + weight + ", sign_date=" + sign_date + ", modify_date=" + modify_date
				+ ", user_status=" + user_status + ", temp_pwd_yn=" + temp_pwd_yn + ", memberRoleList=" + memberRoleList
				+ "]";
	}

}
