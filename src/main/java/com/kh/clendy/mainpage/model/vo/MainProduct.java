package com.kh.clendy.mainpage.model.vo;

public class MainProduct {
	private int pNo;
	private String pName;
	private int pPrice;
	private String pStatus;
	private int imgNo;
	private String route;
	private String imgName;
	private String imgRName;
	private int imgLevel;
	private String imgStatus;
	public MainProduct() {
		super();
	}
	public MainProduct(int pNo, String pName, int pPrice, String pStatus, int imgNo, String route, String imgName,
			String imgRName, int imgLevel, String imgStatus) {
		super();
		this.pNo = pNo;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pStatus = pStatus;
		this.imgNo = imgNo;
		this.route = route;
		this.imgName = imgName;
		this.imgRName = imgRName;
		this.imgLevel = imgLevel;
		this.imgStatus = imgStatus;
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
	public int getImgNo() {
		return imgNo;
	}
	public void setImgNo(int imgNo) {
		this.imgNo = imgNo;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getImgRName() {
		return imgRName;
	}
	public void setImgRName(String imgRName) {
		this.imgRName = imgRName;
	}
	public int getImgLevel() {
		return imgLevel;
	}
	public void setImgLevel(int imgLevel) {
		this.imgLevel = imgLevel;
	}
	public String getImgStatus() {
		return imgStatus;
	}
	public void setImgStatus(String imgStatus) {
		this.imgStatus = imgStatus;
	}
	@Override
	public String toString() {
		return "MainProduct [pNo=" + pNo + ", pName=" + pName + ", pPrice=" + pPrice + ", pStatus=" + pStatus
				+ ", imgNo=" + imgNo + ", route=" + route + ", imgName=" + imgName + ", imgRName=" + imgRName
				+ ", imgLevel=" + imgLevel + ", imgStatus=" + imgStatus + "]";
	}

}