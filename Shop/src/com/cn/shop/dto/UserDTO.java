package com.cn.shop.dto;


/*用户数据传输层*/

public class UserDTO {

	
	private String name; //用户名
	
	private  int password1; //密码
	
	private int password2; //确定密码
	
	private String address; //地址
	
	private String postCode; //邮编
	
	private String email; //email地址
	
	private String homePhone;// 家庭电话号码
	
	private String cellPhone; //手机号码
	
	private String officePhone; //办公室电话号码
	
	
	private String rand;
	
	

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPassword1() {
		return password1;
	}

	public void setPassword1(int password1) {
		this.password1 = password1;
	}

	public int getPassword2() {
		return password2;
	}

	public void setPassword2(int password2) {
		this.password2 = password2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	
	
	
	
	
	
	
	
}
