package com.example.demo;

public class Post {
	
	private int id;
	private int userId;
	private String title;
	private String body;
	
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer Id) {
		this.id = id;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId() {
		this.userId = userId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String setTitle(String title) {
		this.title = title;
		return this.title;
	}
	
	public String getBody() {
		return body;
	}
	
	public String setBody(String body) {
		this.body = body;
		return this.body;
	}

}
