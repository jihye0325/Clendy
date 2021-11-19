package com.kh.clendy.member.model.vo;

public class MemberRole {
	private int user_no;
	private int auth_code;
	
	/* 권한 코드별로 가지는 권한 - Authority */
	private Authority authority;
	
	public MemberRole() {}

	public MemberRole(int user_no, int auth_code, Authority authority) {
		super();
		this.user_no = user_no;
		this.auth_code = auth_code;
		this.authority = authority;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getAuth_code() {
		return auth_code;
	}

	public void setAuth_code(int auth_code) {
		this.auth_code = auth_code;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "MemberRole [user_no=" + user_no + ", auth_code=" + auth_code + ", authority=" + authority + "]";
	}
	
}
