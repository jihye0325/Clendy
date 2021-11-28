package com.kh.clendy.mainpage.model.vo;

public class MainProduct {
	private int pNo;
	private String pName;
	private int pPrice;
	private String pStatus;
	
	public MainProduct() {}
	
	public MainProduct(int pNo, String pName, int pPrice, String pStatus) {
		super();
		this.pNo = pNo;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pStatus = pStatus;
	}
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public String getpStatus() {
		return pStatus;
	}
	public void setpStatus(String pStatus) {
		this.pStatus = pStatus;
	}
	@Override
	public String toString() {
		return "MainProduct [pNo=" + pNo + ", pName=" + pName + ", pPrice=" + pPrice + ", pStatus=" + pStatus + "]";
	}
	
	
}

	