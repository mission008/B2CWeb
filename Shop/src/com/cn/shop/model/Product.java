package com.cn.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



public class Product {
	
	private Long id; // 主键
	
	private String name; //商品名称
	
	private String description; //商品描述
	
	private String imageSrc; //图片地址
	
	private Double price; //价格 

	//无参构造函数
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	//传递商品名称
	public Product(String name) {
		super();
		this.name = name;
	}



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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
	
	
	

}
