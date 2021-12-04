package com.kh.clendy.mypage.model.vo;

import java.util.Date;

import com.kh.clendy.member.model.vo.Member;

public class Review {
	private int r_no;
	private String r_title;
	private int score;
	private String open_size;
	private String r_content;
	private Date r_create_date;
	private Date r_modify_date;
	private int user_no;
	private int order_option_code;
	// 리뷰 좋아요 수
	private int like_cnt;
	
	private Member member;
	
	private Order_Option order_option;
	
	public Review() {}

	public Review(int r_no, String r_title, int score, String open_size, String r_content, Date r_create_date,
			Date r_modify_date, int user_no, int order_option_code, int like_cnt, Member member,
			Order_Option order_option) {
		super();
		this.r_no = r_no;
		this.r_title = r_title;
		this.score = score;
		this.open_size = open_size;
		this.r_content = r_content;
		this.r_create_date = r_create_date;
		this.r_modify_date = r_modify_date;
		this.user_no = user_no;
		this.order_option_code = order_option_code;
		this.like_cnt = like_cnt;
		this.member = member;
		this.order_option = order_option;
	}
	
	public Review(String r_title, int score, String open_size, String r_content, int user_no, int order_option_code) {
		super();
		this.r_title = r_title;
		this.score = score;
		this.open_size = open_size;
		this.r_content = r_content;
		this.user_no = user_no;
		this.order_option_code = order_option_code;
	}

	public Review(int r_no, String r_title, int score, String open_size, String r_content, int user_no,
			int order_option_code) {
		super();
		this.r_no = r_no;
		this.r_title = r_title;
		this.score = score;
		this.open_size = open_size;
		this.r_content = r_content;
		this.user_no = user_no;
		this.order_option_code = order_option_code;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getR_title() {
		return r_title;
	}

	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getOpen_size() {
		return open_size;
	}

	public void setOpen_size(String open_size) {
		this.open_size = open_size;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public Date getR_create_date() {
		return r_create_date;
	}

	public void setR_create_date(Date r_create_date) {
		this.r_create_date = r_create_date;
	}

	public Date getR_modify_date() {
		return r_modify_date;
	}

	public void setR_modify_date(Date r_modify_date) {
		this.r_modify_date = r_modify_date;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getOrder_option_code() {
		return order_option_code;
	}

	public void setOrder_option_code(int order_option_code) {
		this.order_option_code = order_option_code;
	}

	public int getLike_cnt() {
		return like_cnt;
	}

	public void setLike_cnt(int like_cnt) {
		this.like_cnt = like_cnt;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Order_Option getOrder_option() {
		return order_option;
	}

	public void setOrder_option(Order_Option order_option) {
		this.order_option = order_option;
	}

	@Override
	public String toString() {
		return "Review [r_no=" + r_no + ", r_title=" + r_title + ", score=" + score + ", open_size=" + open_size
				+ ", r_content=" + r_content + ", r_create_date=" + r_create_date + ", r_modify_date=" + r_modify_date
				+ ", user_no=" + user_no + ", order_option_code=" + order_option_code + ", like_cnt=" + like_cnt
				+ ", member=" + member + ", order_option=" + order_option + "]";
	}
	
}
