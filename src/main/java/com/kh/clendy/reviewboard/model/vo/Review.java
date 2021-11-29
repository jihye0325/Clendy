package com.kh.clendy.reviewboard.model.vo;

public class Review {
	private String pName;
	private int pPrice;
	private String pImgName;
	private String userName;
	private int height;
	private int weight;
	private String rTitle;
	private String rContent;
	private String rImgName;
	public Review() {
		super();
	}
	public Review(String pName, int pPrice, String pImgName, String userName, int height, int weight, String rTitle,
			String rContent, String rImgName) {
		super();
		this.pName = pName;
		this.pPrice = pPrice;
		this.pImgName = pImgName;
		this.userName = userName;
		this.height = height;
		this.weight = weight;
		this.rTitle = rTitle;
		this.rContent = rContent;
		this.rImgName = rImgName;
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
	public String getpImgName() {
		return pImgName;
	}
	public void setpImgName(String pImgName) {
		this.pImgName = pImgName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getrTitle() {
		return rTitle;
	}
	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public String getrImgName() {
		return rImgName;
	}
	public void setrImgName(String rImgName) {
		this.rImgName = rImgName;
	}
	@Override
	public String toString() {
		return "Review [pName=" + pName + ", pPrice=" + pPrice + ", pImgName=" + pImgName + ", userName=" + userName
				+ ", height=" + height + ", weight=" + weight + ", rTitle=" + rTitle + ", rContent=" + rContent
				+ ", rImgName=" + rImgName + "]";
	}
	
	
	

}
