package com.cn.shop.model;

import com.cn.shop.dto.UserDTO;



/*用户*/

public class User {
	
	private Long id; //主键   主键和manager主键问题
	
	private String name; //用户名
	
	private  int password; //密码
	
	private String address; //地址
	
	private String postCode; //邮编
	
	private String email; //email地址
	
	private String homePhone;// 家庭电话号码
	
	private String cellPhone; //手机号码
	
	private String officePhone; //办公室电话号码
	
	/*
	 * 
	 * manager问题
	 * private String type;
	
	private String workNo;*/
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	//传递用户名和密码的构造方法
	public User(String name, int password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	//Id生成策略 有问题


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
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

	
	
	
	
	public void set( UserDTO userDTO )
	{
		this.name = userDTO.getName();
		
		this.password = userDTO.getPassword1();
		
		this.address = userDTO.getAddress();

		
		this.postCode = userDTO.getPostCode();
		
		this.email = userDTO.getEmail();
		
		this.homePhone = userDTO.getHomePhone();
		
		this.cellPhone = userDTO.getCellPhone();
		
		this.officePhone = userDTO.getOfficePhone();
	}
	
	

}
