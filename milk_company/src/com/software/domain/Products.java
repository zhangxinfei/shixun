package com.software.domain;

public class Products {
	private int proId;
	private String proName;
	private String contents;
	private String picturePath;
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public Products(int proId, String proName, String contents,
			String picturePath) {
		super();
		this.proId = proId;
		this.proName = proName;
		this.contents = contents;
		this.picturePath = picturePath;
	}
	public Products() {
		super();
	}

	

}
