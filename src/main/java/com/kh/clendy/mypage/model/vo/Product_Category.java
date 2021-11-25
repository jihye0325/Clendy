package com.kh.clendy.mypage.model.vo;

public class Product_Category {
	private int category_code;
	private String category_name;
	private int ref_category_code;
	
	public Product_Category() {}

	public Product_Category(int category_code, String category_name, int ref_category_code) {
		super();
		this.category_code = category_code;
		this.category_name = category_name;
		this.ref_category_code = ref_category_code;
	}

	public int getCategory_code() {
		return category_code;
	}

	public void setCategory_code(int category_code) {
		this.category_code = category_code;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public int getRef_category_code() {
		return ref_category_code;
	}

	public void setRef_category_code(int ref_category_code) {
		this.ref_category_code = ref_category_code;
	}

	@Override
	public String toString() {
		return "Product_Category [category_code=" + category_code + ", category_name=" + category_name
				+ ", ref_category_code=" + ref_category_code + "]";
	}
	
}
