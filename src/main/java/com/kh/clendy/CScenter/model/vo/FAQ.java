package com.kh.clendy.CScenter.model.vo;

import java.util.Date;

public class FAQ {
	private int q_no;
	private String q_title;
	private String q_answer;
	private Date q_enroll_date;
	private Date q_modify_date;
	private int qc_no;
	private String qc_name;
	private int user_no;
	
	public FAQ() {}

	public FAQ(int q_no, String q_title, String q_answer, Date q_enroll_date, Date q_modify_date, int qc_no,
			String qc_name, int user_no) {
		super();
		this.q_no = q_no;
		this.q_title = q_title;
		this.q_answer = q_answer;
		this.q_enroll_date = q_enroll_date;
		this.q_modify_date = q_modify_date;
		this.qc_no = qc_no;
		this.qc_name = qc_name;
		this.user_no = user_no;
	}

	public int getQ_no() {
		return q_no;
	}

	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}

	public String getQ_title() {
		return q_title;
	}

	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}

	public String getQ_answer() {
		return q_answer;
	}

	public void setQ_answer(String q_answer) {
		this.q_answer = q_answer;
	}

	public Date getQ_enroll_date() {
		return q_enroll_date;
	}

	public void setQ_enroll_date(Date q_enroll_date) {
		this.q_enroll_date = q_enroll_date;
	}

	public Date getQ_modify_date() {
		return q_modify_date;
	}

	public void setQ_modify_date(Date q_modify_date) {
		this.q_modify_date = q_modify_date;
	}

	public int getQc_no() {
		return qc_no;
	}

	public void setQc_no(int qc_no) {
		this.qc_no = qc_no;
	}

	public String getQc_name() {
		return qc_name;
	}

	public void setQc_name(String qc_name) {
		this.qc_name = qc_name;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	@Override
	public String toString() {
		return "FAQ [q_no=" + q_no + ", q_title=" + q_title + ", q_answer=" + q_answer + ", q_enroll_date="
				+ q_enroll_date + ", q_modify_date=" + q_modify_date + ", qc_no=" + qc_no + ", qc_name=" + qc_name
				+ ", user_no=" + user_no + "]";
	}

	
}
