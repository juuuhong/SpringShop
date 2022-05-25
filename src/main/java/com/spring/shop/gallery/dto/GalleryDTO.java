package com.spring.shop.gallery.dto;

public class GalleryDTO {
	private int num;
	private String userId;
	private String title;
	private String content;
	private String createAt;
	private int readcount;
	private String img;

	public GalleryDTO() {
		
	}

	public GalleryDTO(int num, String userId, String title, String content, String createAt, int readcount, String img) {
		super();
		this.num = num;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.createAt = createAt;
		this.readcount = readcount;
		this.img = img;
	}
	
	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img = img;
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
