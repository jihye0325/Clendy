package com.kh.clendy.sellerAsk.model.vo;

import java.sql.Date;

public class SellerAsk {
	private int sellerCode;
	private int piqCode;
	private int piaCode;
	private String pName;
	private String piqTitle;
	private Date piqcDate;
	private Date piacDate;
	private String id;
	private String piqContent;
	private int pNo;
	private String piaContent;
	private int userNo;
	private String picateName;
	private int picateCode;
	
	public SellerAsk() {
		super();
	}

	public SellerAsk(int sellerCode, int piqCode, int piaCode, String pName, String piqTitle, Date piqcDate,
			Date piacDate, String id, String piqContent, int pNo, String piaContent, int userNo, String picateName,
			int picateCode) {
		super();
		this.sellerCode = sellerCode;
		this.piqCode = piqCode;
		this.piaCode = piaCode;
		this.pName = pName;
		this.piqTitle = piqTitle;
		this.piqcDate = piqcDate;
		this.piacDate = piacDate;
		this.id = id;
		this.piqContent = piqContent;
		this.pNo = pNo;
		this.piaContent = piaContent;
		this.userNo = userNo;
		this.picateName = picateName;
		this.picateCode = picateCode;
	}

	public int getSellerCode() {
		return sellerCode;
	}

	public void setSellerCode(int sellerCode) {
		this.sellerCode = sellerCode;
	}

	public int getPiqCode() {
		return piqCode;
	}

	public void setPiqCode(int piqCode) {
		this.piqCode = piqCode;
	}

	public int getPiaCode() {
		return piaCode;
	}

	public void setPiaCode(int piaCode) {
		this.piaCode = piaCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getPiqTitle() {
		return piqTitle;
	}

	public void setPiqTitle(String piqTitle) {
		this.piqTitle = piqTitle;
	}

	public Date getPiqcDate() {
		return piqcDate;
	}

	public void setPiqcDate(Date piqcDate) {
		this.piqcDate = piqcDate;
	}

	public Date getPiacDate() {
		return piacDate;
	}

	public void setPiacDate(Date piacDate) {
		this.piacDate = piacDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPiqContent() {
		return piqContent;
	}

	public void setPiqContent(String piqContent) {
		this.piqContent = piqContent;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public String getPiaContent() {
		return piaContent;
	}

	public void setPiaContent(String piaContent) {
		this.piaContent = piaContent;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getPicateName() {
		return picateName;
	}

	public void setPicateName(String picateName) {
		this.picateName = picateName;
	}

	public int getPicateCode() {
		return picateCode;
	}

	public void setPicateCode(int picateCode) {
		this.picateCode = picateCode;
	}

	@Override
	public String toString() {
		return "SellerAsk [sellerCode=" + sellerCode + ", piqCode=" + piqCode + ", piaCode=" + piaCode + ", pName="
				+ pName + ", piqTitle=" + piqTitle + ", piqcDate=" + piqcDate + ", piacDate=" + piacDate + ", id=" + id
				+ ", piqContent=" + piqContent + ", pNo=" + pNo + ", piaContent=" + piaContent + ", userNo=" + userNo
				+ ", picateName=" + picateName + ", picateCode=" + picateCode + "]";
	}
	
	
}