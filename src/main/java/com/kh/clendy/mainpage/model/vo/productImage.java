package com.kh.clendy.mainpage.model.vo;

public class productImage {
	private int pNo;
	private int imgNo;
	public productImage() {
		super();
	}
	public productImage(int pNo, int imgNo) {
		super();
		this.pNo = pNo;
		this.imgNo = imgNo;
	}
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public int getImgNo() {
		return imgNo;
	}
	public void setImgNo(int imgNo) {
		this.imgNo = imgNo;
	}
	@Override
	public String toString() {
		return "productImage [pNo=" + pNo + ", imgNo=" + imgNo + "]";
	}
	
	

}
