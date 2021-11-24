package com.kh.clendy.sellerProduct.model.vo;

public class SellerProductImage {
	private int imgNo;
	private String route;
	private String imgName;
	private String imgrName;
	private int imgLevel;
	private String imgStatus;

	public SellerProductImage() {
		super();
	}

	public SellerProductImage(int imgNo, String route, String imgName, String imgrName, int imgLevel,
			String imgStatus) {
		super();
		this.imgNo = imgNo;
		this.route = route;
		this.imgName = imgName;
		this.imgrName = imgrName;
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

	public String getImgrName() {
		return imgrName;
	}

	public void setImgrName(String imgrName) {
		this.imgrName = imgrName;
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
		return "SellerProductImage [imgNo=" + imgNo + ", route=" + route + ", imgName=" + imgName + ", imgrName="
				+ imgrName + ", imgLevel=" + imgLevel + ", imgStatus=" + imgStatus + "]";
	}
}