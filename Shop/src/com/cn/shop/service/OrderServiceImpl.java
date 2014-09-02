package com.cn.shop.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.cn.shop.common.Constants;
import com.cn.shop.dao.BaseDAO;
import com.cn.shop.model.Order;

public class OrderServiceImpl implements OrderService  {
	
	private BaseDAO baseDAO;
	
	private SimpleDateFormat timeFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	
	

	public BaseDAO getBaseDAO() {
		return baseDAO;
	}

	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}

	@Override
	public String generateOrder(Order order) {
		// TODO Auto-generated method stub
		if( order == null )
		{
			return null;
		}
		
		order.setOrderNum(timeFormat.format( new Date()));
		
		baseDAO.saveEntity(order);
		
		return order.getOrderNum();
	}

	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return baseDAO.getAllEntity("Order");
	}

	@Override
	public Order getOrderById(long id) {
		// TODO Auto-generated method stub
		return baseDAO.getEntityById(Order.class, id);
	}

	@Override
	public void nextOrderStatus(long id) {
		// TODO Auto-generated method stub
		
		Order order = baseDAO.getEntityById(Order.class, id);
		
		if( order.getStatus() != Constants.ORDER_STATUS_END )
		{
			order.setStatus(order.getStatus()+1 );
			
			baseDAO.updateEntity(order);
		}
		
	}

}
