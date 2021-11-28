package com.kh.clendy.mainpage.model.vo;

public class image {
	private int imgNo;
	private String route;
	private String imgName;
	private String imgRName;
	private int imgLevel;
	private String imgStatus;
	public image() {
		super();
	}
	public image(int imgNo, String route, String imgName, String imgRName, int imgLevel, String imgStatus) {
		super();
		this.imgNo = imgNo;
		this.route = route;
		this.imgName = imgName;
		this.imgRName = imgRName;
		this.imgLevel = imgLevel;
		this.imgStatus = imgStatus;
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
		return "image [imgNo=" + imgNo + ", route=" + route + ", imgName=" + imgName + ", imgRName=" + imgRName
				+ ", imgLevel=" + imgLevel + ", imgStatus=" + imgStatus + "]";
	}
	
	

}
