package com.kh.clendy.admin.model.vo;

import java.util.Date;

public class Calculation {
	private int cal_no;
	private String cal_status;
	private long sales_price;	// 매출액
	private long cal_price;		// 정산금액
	private Date complete_date;
	private int seller_code;
	private int commission;		// 수수료
	private String seller_name;
	private String account_bank;
	private long account_num;

	public Calculation() {}

	public Calculation(int cal_no, String cal_status, long sales_price, long cal_price, Date complete_date,
			int seller_code, int commission, String seller_name, String account_bank, long account_num) {
		super();
		this.cal_no = cal_no;
		this.cal_status = cal_status;
		this.sales_price = sales_price;
		this.cal_price = cal_price;
		this.complete_date = complete_date;
		this.seller_code = seller_code;
		this.commission = commission;
		this.seller_name = seller_name;
		this.account_bank = account_bank;
		this.account_num = account_num;
	}

	public int getCal_no() {
		return cal_no;
	}

	public void setCal_no(int cal_no) {
		this.cal_no = cal_no;
	}

	public String getCal_status() {
		return cal_status;
	}

	public void setCal_status(String cal_status) {
		this.cal_status = cal_status;
	}

	public long getSales_price() {
		return sales_price;
	}

	public void setSales_price(long sales_price) {
		this.sales_price = sales_price;
	}

	public long getCal_price() {
		return cal_price;
	}

	public void setCal_price(long cal_price) {
		this.cal_price = cal_price;
	}

	public Date getComplete_date() {
		return complete_date;
	}

	public void setComplete_date(Date complete_date) {
		this.complete_date = complete_date;
	}

	public int getSeller_code() {
		return seller_code;
	}

	public void setSeller_code(int seller_code) {
		this.seller_code = seller_code;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}

	public String getSeller_name() {
		return seller_name;
	}

	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
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

	@Override
	public String toString() {
		return "Calculation [cal_no=" + cal_no + ", cal_status=" + cal_status + ", sales_price=" + sales_price
				+ ", cal_price=" + cal_price + ", complete_date=" + complete_date + ", seller_code=" + seller_code
				+ ", commission=" + commission + ", seller_name=" + seller_name + ", account_bank=" + account_bank
				+ ", account_num=" + account_num + "]";
	}

	
}
