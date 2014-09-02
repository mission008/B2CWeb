package com.cn.shop.model;

public class Item {
	
	private Long id; //主键
	
	private Integer number; //商品数量
	
	private Product product; //商品类
	
	private Double cost; //总价
	
	private Order order; //所属订单

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	//数量和产品类别
	public Item(Integer number, Product product) {
		super();
		this.number = number;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getCost() {
		return ( product.getPrice() * number );
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	
	
}
