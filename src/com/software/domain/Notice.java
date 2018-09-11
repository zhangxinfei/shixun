package com.software.domain;

import java.sql.Timestamp;

public class Notice {
	private int noticeId;
	private String title;
	private String handlers;
	private Timestamp time;
	private String contents;
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHandlers() {
		return handlers;
	}
	public void setHandlers(String handlers) {
		this.handlers = handlers;
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
	public Notice(int noticeId, String title, String handlers, Timestamp time,
			String contents) {
		super();
		this.noticeId = noticeId;
		this.title = title;
		this.handlers = handlers;
		this.time = time;
		this.contents = contents;
	}
	public Notice() {
		super();
	}
	
	

}
