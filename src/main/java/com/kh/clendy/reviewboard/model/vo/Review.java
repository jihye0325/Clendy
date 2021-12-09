package com.kh.clendy.reviewboard.model.vo;

public class Review {
	private int loginUno;
	private String pName;
	private int pNo;
	private int rNo;
	private int pPrice;
	private String pImgRName;
	private int height;
	private int weight;
	private String rTitle;
	private String rContent;
	private String id;
	private String gender;
	private double ss;
	private int cntlike;
	private String rvimg;
	private String rvroute;
	private String route;
	private String pColor;
	private String pSize;
	private String openSize;
	private String categoryName;
	private int likeCount;

	public Review() {
		super();
	}

	public Review(int loginUno, String pName, int pNo, int rNo, int pPrice, String pImgRName, int height, int weight,
			String rTitle, String rContent, String id, String gender, double ss, int cntlike, String rvimg,
			String rvroute, String route, String pColor, String pSize, String openSize, String categoryName,
			int likeCount) {
		super();
		this.loginUno = loginUno;
		this.pName = pName;
		this.pNo = pNo;
		this.rNo = rNo;
		this.pPrice = pPrice;
		this.pImgRName = pImgRName;
		this.height = height;
		this.weight = weight;
		this.rTitle = rTitle;
		this.rContent = rContent;
		this.id = id;
		this.gender = gender;
		this.ss = ss;
		this.cntlike = cntlike;
		this.rvimg = rvimg;
		this.rvroute = rvroute;
		this.route = route;
		this.pColor = pColor;
		this.pSize = pSize;
		this.openSize = openSize;
		this.categoryName = categoryName;
		this.likeCount = likeCount;
	}

	public int getLoginUno() {
		return loginUno;
	}

	public void setLoginUno(int loginUno) {
		this.loginUno = loginUno;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public String getpImgRName() {
		return pImgRName;
	}

	public void setpImgRName(String pImgRName) {
		this.pImgRName = pImgRName;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSs() {
		return ss;
	}

	public void setSs(double ss) {
		this.ss = ss;
	}

	public int getCntlike() {
		return cntlike;
	}

	public void setCntlike(int cntlike) {
		this.cntlike = cntlike;
	}

	public String getRvimg() {
		return rvimg;
	}

	public void setRvimg(String rvimg) {
		this.rvimg = rvimg;
	}

	public String getRvroute() {
		return rvroute;
	}

	public void setRvroute(String rvroute) {
		this.rvroute = rvroute;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getpColor() {
		return pColor;
	}

	public void setpColor(String pColor) {
		this.pColor = pColor;
	}

	public String getpSize() {
		return pSize;
	}

	public void setpSize(String pSize) {
		this.pSize = pSize;
	}

	public String getOpenSize() {
		return openSize;
	}

	public void setOpenSize(String openSize) {
		this.openSize = openSize;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	@Override
	public String toString() {
		return "Review [loginUno=" + loginUno + ", pName=" + pName + ", pNo=" + pNo + ", rNo=" + rNo + ", pPrice="
				+ pPrice + ", pImgRName=" + pImgRName + ", height=" + height + ", weight=" + weight + ", rTitle="
				+ rTitle + ", rContent=" + rContent + ", id=" + id + ", gender=" + gender + ", ss=" + ss + ", cntlike="
				+ cntlike + ", rvimg=" + rvimg + ", rvroute=" + rvroute + ", route=" + route + ", pColor=" + pColor
				+ ", pSize=" + pSize + ", openSize=" + openSize + ", categoryName=" + categoryName + ", likeCount="
				+ likeCount + "]";
	}

	
}