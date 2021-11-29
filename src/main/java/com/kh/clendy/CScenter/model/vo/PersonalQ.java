package com.kh.clendy.CScenter.model.vo;

import java.util.Date;

public class PersonalQ {
	private int p_no;
	private String p_title;
	private String p_content;
	private String p_answer;
	private Date p_enroll_date;
	private Date p_answer_date;
	private Date p_a_modify_date;
	private int qc_no;
	private String qc_name;
	private int q_writer;
	private int a_writer;

	public PersonalQ() {}

	public PersonalQ(int p_no, String p_title, String p_content, String p_answer, Date p_enroll_date,
			Date p_answer_date, Date p_a_modify_date, int qc_no, String qc_name, int q_writer, int a_writer) {
		super();
		this.p_no = p_no;
		this.p_title = p_title;
		this.p_content = p_content;
		this.p_answer = p_answer;
		this.p_enroll_date = p_enroll_date;
		this.p_answer_date = p_answer_date;
		this.p_a_modify_date = p_a_modify_date;
		this.qc_no = qc_no;
		this.qc_name = qc_name;
		this.q_writer = q_writer;
		this.a_writer = a_writer;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_title() {
		return p_title;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public String getP_answer() {
		return p_answer;
	}

	public void setP_answer(String p_answer) {
		this.p_answer = p_answer;
	}

	public Date getP_enroll_date() {
		return p_enroll_date;
	}

	public void setP_enroll_date(Date p_enroll_date) {
		this.p_enroll_date = p_enroll_date;
	}

	public Date getP_answer_date() {
		return p_answer_date;
	}

	public void setP_answer_date(Date p_answer_date) {
		this.p_answer_date = p_answer_date;
	}

	public Date getP_a_modify_date() {
		return p_a_modify_date;
	}

	public void setP_a_modify_date(Date p_a_modify_date) {
		this.p_a_modify_date = p_a_modify_date;
	}

	public int getQc_no() {
		return qc_no;
	}

	public void setQc_no(int qc_no) {
		this.qc_no = qc_no;
	}

	public int getQ_writer() {
		return q_writer;
	}

	public void setQ_writer(int q_writer) {
		this.q_writer = q_writer;
	}

	public int getA_writer() {
		return a_writer;
	}

	public void setA_writer(int a_writer) {
		this.a_writer = a_writer;
	}

	public String getQc_name() {
		return qc_name;
	}

	public void setQc_name(String qc_name) {
		this.qc_name = qc_name;
	}

	@Override
	public String toString() {
		return "PersonalQ [p_no=" + p_no + ", p_title=" + p_title + ", p_content=" + p_content + ", p_answer="
				+ p_answer + ", p_enroll_date=" + p_enroll_date + ", p_answer_date=" + p_answer_date
				+ ", p_a_modify_date=" + p_a_modify_date + ", qc_no=" + qc_no + ", qc_name=" + qc_name + ", q_writer="
				+ q_writer + ", a_writer=" + a_writer + "]";
	}

	
}
