package com.kh.clendy.mypage.model.vo;

public class Refund_Category {
	private int ref_id;
	private String ref_name;
	
	public Refund_Category() {}

	public Refund_Category(int ref_id, String ref_name) {
		super();
		this.ref_id = ref_id;
		this.ref_name = ref_name;
	}

	public int getRef_id() {
		return ref_id;
	}

	public void setRef_id(int ref_id) {
		this.ref_id = ref_id;
	}

	public String getRef_name() {
		return ref_name;
	}

	public void setRef_name(String ref_name) {
		this.ref_name = ref_name;
	}

	@Override
	public String toString() {
		return "Refund_Category [ref_id=" + ref_id + ", ref_name=" + ref_name + "]";
	}
	
	
}
