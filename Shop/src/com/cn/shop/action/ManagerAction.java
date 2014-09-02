package com.cn.shop.action;

import java.util.List;

import com.cn.shop.common.Constants;
import com.cn.shop.model.Order;
import com.cn.shop.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;

public class ManagerAction extends ActionSupport  {
	
	private OrderService orderService;
	
	private List<Order> orders;
	
	private Long orderId;
	
	private String msg ;
	

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String index( )
	{
		orders = orderService.getAllOrder();
		
		for( Order o : orders )
		{
			System.out.println( o.getCost() );
		}
		
		return "manager";
		
	}
	
	public String next( )
	{
		
		orderService.nextOrderStatus(orderId);
		
		
		
		return "next";
	}

}
