package com.cn.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.shop.dao.UserDAO;
import com.cn.shop.model.User;
import com.cn.shop.service.UserService;

public class UserTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void login( )
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserService userService = (UserService)ctx.getBean("userServiceTarget");
		
	 
	   
	   User u1 =  userService.login("throne212", "123" );
	   
	   System.out.println( u1.getName() );
		
	}

}
