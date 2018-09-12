package com.software.domain;

import java.sql.Timestamp;

public class Message {

	private int mesId;
	private String handlers;
	private int parentNode;
	private Timestamp time;
	private String contents;
	private String flag;
	public int getMesId() {
		return mesId;
	}
	public void setMesId(int mesId) {
		this.mesId = mesId;
	}
	public String getHandlers() {
		return handlers;
	}
	public void setHandlers(String handlers) {
		this.handlers = handlers;
	}
	public int getParentNode() {
		return parentNode;
	}
	public void setParentNode(int parentNode) {
		this.parentNode = parentNode;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Message(int mesId, String handlers, int parentNode, Timestamp time,
			String contents, String flag) {
		super();
		this.mesId = mesId;
		this.handlers = handlers;
		this.parentNode = parentNode;
		this.time = time;
		this.contents = contents;
		this.flag = flag;
	}
	public Message() {
		super();
	}
	
	
	
	
}
