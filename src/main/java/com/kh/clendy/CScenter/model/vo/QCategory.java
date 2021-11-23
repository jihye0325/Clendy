package com.kh.clendy.CScenter.model.vo;

public class QCategory {
	/*QC_NO	NUMBER
QC_NAME	VARCHAR2(20 CHAR)*/
	private int qc_no;
	private String qc_name;
	
	public QCategory() {}

	public QCategory(int qc_no, String qc_name) {
		super();
		this.qc_no = qc_no;
		this.qc_name = qc_name;
	}

	public int getQc_no() {
		return qc_no;
	}

	public void setQc_no(int qc_no) {
		this.qc_no = qc_no;
	}

	public String getQc_name() {
		return qc_name;
	}

	public void setQc_name(String qc_name) {
		this.qc_name = qc_name;
	}

	@Override
	public String toString() {
		return "QCategory [qc_no=" + qc_no + ", qc_name=" + qc_name + "]";
	}
	
		
}
