package com.cn.shop.dto;

import java.io.File;

public class ProductDTO {
	
	private String name; //商品名称
	
	private Double price; //价格
	
	private String description; //商品描述
	
	private File file;  //图片

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	
	
	
	
	

}
