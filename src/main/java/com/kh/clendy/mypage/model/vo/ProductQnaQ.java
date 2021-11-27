package com.kh.clendy.mypage.model.vo;

import java.sql.Date;

import com.kh.clendy.product.model.vo.ProductQnaA;

public class ProductQnaQ {
	private int p_i_q_code;
	private String p_i_cate_code;
	private String p_i_cate_name;
	private int p_no;
	private String p_name;
	private String p_i_q_title;
	private String p_i_q_content;
	private Date p_i_q_create_date;
	private Date p_i_q_modify_date;
	
	private ProductQnaA productQnaA;

	public ProductQnaQ() {}

	public ProductQnaQ(int p_i_q_code, String p_i_cate_code, String p_i_cate_name, int p_no, String p_name,
			String p_i_q_title, String p_i_q_content, Date p_i_q_create_date, Date p_i_q_modify_date,
			ProductQnaA productQnaA) {
		super();
		this.p_i_q_code = p_i_q_code;
		this.p_i_cate_code = p_i_cate_code;
		this.p_i_cate_name = p_i_cate_name;
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_i_q_title = p_i_q_title;
		this.p_i_q_content = p_i_q_content;
		this.p_i_q_create_date = p_i_q_create_date;
		this.p_i_q_modify_date = p_i_q_modify_date;
		this.productQnaA = productQnaA;
	}

	public int getP_i_q_code() {
		return p_i_q_code;
	}

	public void setP_i_q_code(int p_i_q_code) {
		this.p_i_q_code = p_i_q_code;
	}

	public String getP_i_cate_code() {
		return p_i_cate_code;
	}

	public void setP_i_cate_code(String p_i_cate_code) {
		this.p_i_cate_code = p_i_cate_code;
	}

	public String getP_i_cate_name() {
		return p_i_cate_name;
	}

	public void setP_i_cate_name(String p_i_cate_name) {
		this.p_i_cate_name = p_i_cate_name;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_i_q_title() {
		return p_i_q_title;
	}

	public void setP_i_q_title(String p_i_q_title) {
		this.p_i_q_title = p_i_q_title;
	}

	public String getP_i_q_content() {
		return p_i_q_content;
	}

	public void setP_i_q_content(String p_i_q_content) {
		this.p_i_q_content = p_i_q_content;
	}

	public Date getP_i_q_create_date() {
		return p_i_q_create_date;
	}

	public void setP_i_q_create_date(Date p_i_q_create_date) {
		this.p_i_q_create_date = p_i_q_create_date;
	}

	public Date getP_i_q_modify_date() {
		return p_i_q_modify_date;
	}

	public void setP_i_q_modify_date(Date p_i_q_modify_date) {
		this.p_i_q_modify_date = p_i_q_modify_date;
	}

	public ProductQnaA getProductQnaA() {
		return productQnaA;
	}

	public void setProductQnaA(ProductQnaA productQnaA) {
		this.productQnaA = productQnaA;
	}

	@Override
	public String toString() {
		return "ProductQnaQ [p_i_q_code=" + p_i_q_code + ", p_i_cate_code=" + p_i_cate_code + ", p_i_cate_name="
				+ p_i_cate_name + ", p_no=" + p_no + ", p_name=" + p_name + ", p_i_q_title=" + p_i_q_title
				+ ", p_i_q_content=" + p_i_q_content + ", p_i_q_create_date=" + p_i_q_create_date
				+ ", p_i_q_modify_date=" + p_i_q_modify_date + ", productQnaA=" + productQnaA + "]";
	}
	
}
