package com.kh.clendy.mypage.model.vo;

public class Wishlist {
	private int user_no;
	private int p_no;
	
	public Wishlist() {}

	public Wishlist(int user_no, int p_no) {
		super();
		this.user_no = user_no;
		this.p_no = p_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	@Override
	public String toString() {
		return "Wishlist [user_no=" + user_no + ", p_no=" + p_no + "]";
	}
	
}
