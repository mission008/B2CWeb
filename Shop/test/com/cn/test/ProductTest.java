package com.cn.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;





import com.cn.shop.model.Product;
import com.cn.shop.service.ProductService;
import com.cn.shop.service.UserService;

public class ProductTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	
	public void get( )
	{
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		ProductService Service = (ProductService)ctx.getBean("productServiceTarget");
		
		 Product p1 = Service.getProduct((long) 3);
		
		System.out.println( p1.getName()  );
		
		List<Product > ps = Service.getALLProducts();
		
		for( Product p : ps )
		{
			System.out.println( p.getName() );
		}
		
		
		
		
	}
	
	@Test
	public void add( )
	{
		Product p = new Product( );
		
		p.setName("Ë®±­");
		
		p.setPrice(100.2);
		
		p.setImageSrc("D:/java.text");
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		ProductService Service = (ProductService)ctx.getBean("productServiceTarget");
		
		Service.addProduct(p);
		
		
		
		
	}
	
	@Test
	public void delete( )
	{
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		ProductService Service = (ProductService)ctx.getBean("productServiceTarget");
		
		Service.deleteProduct(Long.valueOf(5));
		
		
	}
	
	@Test
	public void Update( )
	{
		
		Product p = new Product( );
		
		p.setId(Long.valueOf(4));
		
		p.setName("Ð¡±´");
		
		p.setPrice(88.8);		
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		ProductService Service = (ProductService)ctx.getBean("productServiceTarget");
		
		Service.UpdateProduct(p);
		
	}
	
	@Test
	
	public void maxpage( )
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		ProductService Service = (ProductService)ctx.getBean("productServiceTarget");
		
	
		
		int max = Service.maxSize();
		
		System.out.println( max );
		
		
	}
	
	@Test
	
	public void bypage( )
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		ProductService Service = (ProductService)ctx.getBean("productServiceTarget");
		
	
		
		List<Product> list = new ArrayList<Product>();
		
		list = Service.getByPage(1, 5);
		
		System.out.println( list.size() );
		
	}
	
	
}
