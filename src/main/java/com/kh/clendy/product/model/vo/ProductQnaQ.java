package com.kh.clendy.product.model.vo;

import java.sql.Date;

public class ProductQnaQ {
	private int piqCode;
	private String piCateCode;
	private String piCateName;
	private int pNo;
	private int userNo;
	private int loginUno;
	private String id;
	private String piqTitle;
	private String piqContent;
	private String piqSecret;
	private Date piqCreateDate;
	private Date piqModifyDate;
	private String piqDelStatus;
	private ProductQnaA productQnaA;
	
	public ProductQnaQ() { 	}

	public int getPiqCode() {
		return piqCode;
	}

	public void setPiqCode(int piqCode) {
		this.piqCode = piqCode;
	}

	public String getPiCateCode() {
		return piCateCode;
	}

	public void setPiCateCode(String piCateCode) {
		this.piCateCode = piCateCode;
	}

	public String getPiCateName() {
		return piCateName;
	}

	public void setPiCateName(String piCateName) {
		this.piCateName = piCateName;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getLoginUno() {
		return loginUno;
	}

	public void setLoginUno(int loginUno) {
		this.loginUno = loginUno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPiqTitle() {
		return piqTitle;
	}

	public void setPiqTitle(String piqTitle) {
		this.piqTitle = piqTitle;
	}

	public String getPiqContent() {
		return piqContent;
	}

	public void setPiqContent(String piqContent) {
		this.piqContent = piqContent;
	}

	public String getPiqSecret() {
		return piqSecret;
	}

	public void setPiqSecret(String piqSecret) {
		this.piqSecret = piqSecret;
	}

	public Date getPiqCreateDate() {
		return piqCreateDate;
	}

	public void setPiqCreateDate(Date piqCreateDate) {
		this.piqCreateDate = piqCreateDate;
	}

	public Date getPiqModifyDate() {
		return piqModifyDate;
	}

	public void setPiqModifyDate(Date piqModifyDate) {
		this.piqModifyDate = piqModifyDate;
	}

	public String getPiqDelStatus() {
		return piqDelStatus;
	}

	public void setPiqDelStatus(String piqDelStatus) {
		this.piqDelStatus = piqDelStatus;
	}

	public ProductQnaA getProductQnaA() {
		return productQnaA;
	}

	public void setProductQnaA(ProductQnaA productQnaA) {
		this.productQnaA = productQnaA;
	}

	@Override
	public String toString() {
		return "ProductQnaQ [piqCode=" + piqCode + ", piCateCode=" + piCateCode + ", piCateName=" + piCateName
				+ ", pNo=" + pNo + ", userNo=" + userNo + ", loginUno=" + loginUno + ", id=" + id + ", piqTitle="
				+ piqTitle + ", piqContent=" + piqContent + ", piqSecret=" + piqSecret + ", piqCreateDate="
				+ piqCreateDate + ", piqModifyDate=" + piqModifyDate + ", piqDelStatus=" + piqDelStatus
				+ ", productQnaA=" + productQnaA + "]";
	}

	
	

	
}

	