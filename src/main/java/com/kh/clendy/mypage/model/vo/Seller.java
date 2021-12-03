package com.kh.clendy.mypage.model.vo;

import com.kh.clendy.common.model.vo.ApplyStore;

public class Seller {
	private int seller_code;
	private int a_no;

	private ApplyStore applystore;
	
	public Seller() {}

	public Seller(int seller_code, int a_no, ApplyStore applystore) {
		super();
		this.seller_code = seller_code;
		this.a_no = a_no;
		this.applystore = applystore;
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

	public ApplyStore getApplystore() {
		return applystore;
	}

	public void setApplystore(ApplyStore applystore) {
		this.applystore = applystore;
	}

	@Override
	public String toString() {
		return "Seller [seller_code=" + seller_code + ", a_no=" + a_no + ", applystore=" + applystore + "]";
	}

}
