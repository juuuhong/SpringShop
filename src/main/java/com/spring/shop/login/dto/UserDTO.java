package com.spring.shop.login.dto;

public class UserDTO {
	
	private String id;
	private String name;
	private String pw;
	private String gender;
	private String birthday;
	private String createAt;
	private String preAddr;
	private String sufAddr;
	private String addr;
	private String newPw;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDTO(String id, String name, String pw, String gender, String birthday, String createAt, String preAddr,
			String sufAddr, String addr, String newPw) {
		super();
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.gender = gender;
		this.birthday = birthday;
		this.createAt = createAt;
		this.preAddr = preAddr;
		this.sufAddr = sufAddr;
		this.addr = addr;
		this.newPw = newPw;
	}
	
	public String getNewPw() {
		return newPw;
	}

	public void setNewPw(String newPw) {
		this.newPw = newPw;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getCreateAt() {
		return createAt;
	}
	
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	
	public String getPreAddr() {
		return preAddr;
	}
	
	public void setPreAddr(String preAddr) {
		this.preAddr = preAddr;
	}
	
	public String getSufAddr() {
		return sufAddr;
	}
	
	public void setSufAddr(String sufAddr) {
		this.sufAddr = sufAddr;
	}
}
