package com.kh.clendy.CScenter.model.vo;

import org.springframework.web.multipart.MultipartFile;

public class SmartEditorSingle {
	private MultipartFile filedata;
	private String callback;
	private String callback_func;	
	
	public SmartEditorSingle() {}

	public SmartEditorSingle(MultipartFile filedata, String callback, String callback_func) {
		super();
		this.filedata = filedata;
		this.callback = callback;
		this.callback_func = callback_func;
	}

	public MultipartFile getfiledata() {
		return filedata;
	}

	public void setfiledata(MultipartFile filedata) {
		this.filedata = filedata;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public String getCallback_func() {
		return callback_func;
	}

	public void setCallback_func(String callback_func) {
		this.callback_func = callback_func;
	}

	@Override
	public String toString() {
		return "SmartEditorSingle [filedata=" + filedata + ", callback=" + callback + ", callback_func=" + callback_func
				+ "]";
	}
	
}
