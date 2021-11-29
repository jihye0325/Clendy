package com.kh.clendy.sellerProduct.model.vo;

public class SellerProductCategory {
	private int categoryCode;
	private String categoryName;
	private int refcategoryCode;

	public SellerProductCategory() {
		super();
	}

	public SellerProductCategory(int categoryCode, String categoryName, int refcategoryCode) {
		super();
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
		this.refcategoryCode = refcategoryCode;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getRefcategoryCode() {
		return refcategoryCode;
	}

	public void setRefcategoryCode(int refcategoryCode) {
		this.refcategoryCode = refcategoryCode;
	}

	@Override
	public String toString() {
		return "SellerProductCategory [categoryCode=" + categoryCode + ", categoryName=" + categoryName
				+ ", refcategoryCode=" + refcategoryCode + "]";
	}
}