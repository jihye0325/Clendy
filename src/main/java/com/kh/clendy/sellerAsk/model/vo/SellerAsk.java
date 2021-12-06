package com.kh.clendy.sellerAsk.model.vo;

import java.sql.Date;

public class SellerAsk {
	private int PIQCode;
	private String pName;
	private String PIQTitle;
	private Date PIQCDate;
	private String id;
	private String PIQContent;
	private int pNo;
	private String PIAContent;
	
	
	public SellerAsk() {
		super();
	}


	public SellerAsk(int pIQCode, String pName, String pIQTitle, Date pIQCDate, String id, String pIQContent, int pNo,
			String pIAContent) {
		super();
		PIQCode = pIQCode;
		this.pName = pName;
		PIQTitle = pIQTitle;
		PIQCDate = pIQCDate;
		this.id = id;
		PIQContent = pIQContent;
		this.pNo = pNo;
		PIAContent = pIAContent;
	}


	public int getPIQCode() {
		return PIQCode;
	}


	public void setPIQCode(int pIQCode) {
		PIQCode = pIQCode;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public String getPIQTitle() {
		return PIQTitle;
	}


	public void setPIQTitle(String pIQTitle) {
		PIQTitle = pIQTitle;
	}


	public Date getPIQCDate() {
		return PIQCDate;
	}


	public void setPIQCDate(Date pIQCDate) {
		PIQCDate = pIQCDate;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPIQContent() {
		return PIQContent;
	}


	public void setPIQContent(String pIQContent) {
		PIQContent = pIQContent;
	}


	public int getpNo() {
		return pNo;
	}


	public void setpNo(int pNo) {
		this.pNo = pNo;
	}


	public String getPIAContent() {
		return PIAContent;
	}


	public void setPIAContent(String pIAContent) {
		PIAContent = pIAContent;
	}


	@Override
	public String toString() {
		return "SellerAsk [PIQCode=" + PIQCode + ", pName=" + pName + ", PIQTitle=" + PIQTitle + ", PIQCDate="
				+ PIQCDate + ", id=" + id + ", PIQContent=" + PIQContent + ", pNo=" + pNo + ", PIAContent=" + PIAContent
				+ "]";
	}
	
	
	

}
