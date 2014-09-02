package com.cn.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.shop.model.Order;
import com.cn.shop.model.User;
import com.cn.shop.service.OrderService;
import com.cn.shop.service.UserService;

public class OrderTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void get( )
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		OrderService Service = (OrderService)ctx.getBean("orderServiceTarget");
		
		 Order order = Service.getOrderById( ( long )1 );
		
		System.out.println( order.getStatus() );
		
		Service.nextOrderStatus( (long)1); 
		
		  order = Service.getOrderById( ( long )1 );
		
		System.out.println( order.getStatus() );
		
	}
	
	@Test
	public void list( )
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		OrderService Service = (OrderService)ctx.getBean("orderServiceTarget");
		
		List<Order> orders = Service.getAllOrder();
		
		for(  Order  o : orders )
		{
			System.out.println( o.getStatus() );
		}
	}
	@Test
	public void gen( )
	{
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		OrderService Service = (OrderService)ctx.getBean("orderServiceTarget");
		
		
		UserService userService = (UserService)ctx.getBean("userServiceTarget");
		
	 
	   
	   User u1 =  userService.login("throne212", "123" );
		
		Order order = new Order( );
		
		order.setStatus(1);
		
		order.setUser(u1);
		
		
		
		 
		
		
		Service.generateOrder(order);
		
		
		
		
	}

	
}
