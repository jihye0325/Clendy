package com.kh.clendy.member.model.vo;

public class Authority {
	private int auth_code;
	private String auth_name;
	private String auth_desc;
	
	public Authority() {}

	public Authority(int auth_code, String auth_name, String auth_desc) {
		super();
		this.auth_code = auth_code;
		this.auth_name = auth_name;
		this.auth_desc = auth_desc;
	}

	public int getAuth_code() {
		return auth_code;
	}

	public void setAuth_code(int auth_code) {
		this.auth_code = auth_code;
	}

	public String getAuth_name() {
		return auth_name;
	}

	public void setAuth_name(String auth_name) {
		this.auth_name = auth_name;
	}

	public String getAuth_desc() {
		return auth_desc;
	}

	public void setAuth_desc(String auth_desc) {
		this.auth_desc = auth_desc;
	}

	@Override
	public String toString() {
		return "Authority [auth_code=" + auth_code + ", auth_name=" + auth_name + ", auth_desc=" + auth_desc + "]";
	}
	
}
