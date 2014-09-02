package com.cn.shop.service;

import java.util.List;

import com.cn.shop.model.Order;

public interface OrderService {
	
	//生成订单
	
	public String generateOrder( Order order );
	
	//获得所有订单
	
	public List<Order> getAllOrder( );
	
	//通过ID获得订单对象
	
	public Order getOrderById( long id );
	
	//将订单的状态转到下一步
	
	public void nextOrderStatus( long id );
	
	
	

}
