package com.cn.shop.model;

import java.util.HashMap;
import java.util.Map;




import com.cn.shop.common.Constants;


public class Order {
	
	private Long id; //主键
	
	private String orderNum; //订单号
	
	private Integer status; //订单状态
	
	private User user; //所属用户
	
	private Double cost; //总价
	
	private Map<Long,Item > items = new HashMap<Long, Item >( ); //包含的订单项，产品id为key

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//传递状态值、所属用户的构造方法
	public Order( Integer status , User user )
	{
		super( );
		
		this.status = status;
		
		this.user = user;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}


	
	public Integer getStatus( ) {
		return  status;
	}
	
/*	public String  getStatus( ) {
		
		String text = null;
		switch (status) {
		case Constants.ORDER_STATUS_POST:
			text = "订单已提交";
			break;
		case Constants.ORDER_STATUS_SEND:
			text = "已发货";
			break;
		case Constants.ORDER_STATUS_RECEIVE:
			text = "用户已收货";
			break;
		case Constants.ORDER_STATUS_END:
			text = "订单完成";
			break;
		default:
			break;
		}
		return text;
	 
	}
	 */
	

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getCost() {
		
		double sum = 0;
		
		for( Long id : items.keySet() )
		{
			Item item = items.get(id);
			
			sum += item.getCost();
		}
		
		this.cost = sum;
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Map<Long, Item> getItems() {
		return items;
	}

	public void setItems(Map<Long, Item> items) {
		this.items = items;
	}
	
	
	
	

}
