package com.software.domain;

import java.sql.Timestamp;

public class News {
	private int newsId;
	private String title;
	private String handlers;
	private Timestamp time;
	private String path;
	
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public News(int newsId, String title, String handlers, Timestamp time,
			String path) {
		super();
		this.newsId = newsId;
		this.title = title;
		this.handlers = handlers;
		this.time = time;
		this.path = path;
	}
	public News() {
		super();
	}
	
	

}
