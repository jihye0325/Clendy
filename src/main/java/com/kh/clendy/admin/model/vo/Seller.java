package com.kh.clendy.admin.model.vo;

import java.util.Date;

public class Seller {
	private int seller_code;
	private int a_no;		// 입점신청 코드
	private String seller_name;
	private String rep_name;
	private int rep_num;
	private long b_license;
	private String o_b_license;
	private long phone;
	private String email;
	private String address;
	private String account_bank;
	private long account_num;
	private Date apply_date;
	private int user_no;
	private long sales; 			// 매출액
	private long commission; 		// 수수료
	
	public Seller() {}

	public Seller(int seller_code, int a_no, String seller_name, String rep_name, int rep_num, long b_license,
			String o_b_license, long phone, String email, String address, String account_bank, long account_num,
			Date apply_date, int user_no, long sales, long commission) {
		super();
		this.seller_code = seller_code;
		this.a_no = a_no;
		this.seller_name = seller_name;
		this.rep_name = rep_name;
		this.rep_num = rep_num;
		this.b_license = b_license;
		this.o_b_license = o_b_license;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.account_bank = account_bank;
		this.account_num = account_num;
		this.apply_date = apply_date;
		this.user_no = user_no;
		this.sales = sales;
		this.commission = commission;
	}

	public int getSeller_code() {
		return seller_code;
	}

	public void setSeller_code(int seller_code) {
		this.seller_code = seller_code;
	}

	public int getA_no() {
		return a_no;
	}

	public void setA_no(int a_no) {
		this.a_no = a_no;
	}

	public String getSeller_name() {
		return seller_name;
	}

	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}

	public String getRep_name() {
		return rep_name;
	}

	public void setRep_name(String rep_name) {
		this.rep_name = rep_name;
	}

	public int getRep_num() {
		return rep_num;
	}

	public void setRep_num(int rep_num) {
		this.rep_num = rep_num;
	}

	public long getB_license() {
		return b_license;
	}

	public void setB_license(long b_license) {
		this.b_license = b_license;
	}

	public String getO_b_license() {
		return o_b_license;
	}

	public void setO_b_license(String o_b_license) {
		this.o_b_license = o_b_license;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccount_bank() {
		return account_bank;
	}

	public void setAccount_bank(String account_bank) {
		this.account_bank = account_bank;
	}

	public long getAccount_num() {
		return account_num;
	}

	public void setAccount_num(long account_num) {
		this.account_num = account_num;
	}

	public Date getApply_date() {
		return apply_date;
	}

	public void setApply_date(Date apply_date) {
		this.apply_date = apply_date;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public long getSales() {
		return sales;
	}

	public void setSales(long sales) {
		this.sales = sales;
	}

	public long getCommission() {
		return commission;
	}

	public void setCommission(long commission) {
		this.commission = commission;
	}

	@Override
	public String toString() {
		return "Seller [seller_code=" + seller_code + ", a_no=" + a_no + ", seller_name=" + seller_name + ", rep_name="
				+ rep_name + ", rep_num=" + rep_num + ", b_license=" + b_license + ", o_b_license=" + o_b_license
				+ ", phone=" + phone + ", email=" + email + ", address=" + address + ", account_bank=" + account_bank
				+ ", account_num=" + account_num + ", apply_date=" + apply_date + ", user_no=" + user_no + ", sales="
				+ sales + ", commission=" + commission + "]";
	}

}
