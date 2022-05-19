package com.spring.shop.notice.dto;

public class NoticeDTO {

	private int num;
	private String userId;
	private String title;
	private String content;
	private String createAt;
	private int readcount;
	
	public NoticeDTO() {
		
	}

	public NoticeDTO(int num, String userId, String title, String content, String createAt, int readcount) {
		super();
		this.num = num;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.createAt = createAt;
		this.readcount = readcount;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
}
