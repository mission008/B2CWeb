package com.cn.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;








import com.cn.shop.common.Constants;
import com.cn.shop.dao.BaseDAO;
import com.cn.shop.dao.UserDAO;
import com.cn.shop.dao.UserDAOImpl;
import com.cn.shop.model.Administrator;
import com.cn.shop.model.Item;
import com.cn.shop.model.Order;
import com.cn.shop.model.Product;
import com.cn.shop.model.User;

public class Test1 {

	
	private static SessionFactory sf ;
	

	
	@BeforeClass
	
	public static void beforeClass( )
	{
		
		//new SchemaExport( new AnnotationConfiguration().configure()).create(false, true);
		
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		
	}
	
	
	@AfterClass
	
	public static void afterClass( )
	{
		sf.close();
		
	}
	
	@Test
	
	public void testSchemaExport( )
	{
		new SchemaExport( new AnnotationConfiguration().configure()).create(false, true);
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	
	
	@Test
	public void SaveUser( )
	{
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		Integer s= new Integer(2);
		
		Long id  = Long.parseLong(s.toString());
		
		 User user = (  User )session.get(User.class, id );
		 
		 Product product = ( Product )session.get(Product.class , id );
		
		 System.out.println( user.getName() );
		 
		 Item item = new Item( 2, product );
		 
		 
		 
		 Order order =new Order ( 1 , user);
		 
		 order.setOrderNum("12211");
		 
		 
		 
		 item.setOrder(order);
		 
		 order.getItems().put(item.getProduct().getId(), item );
		 
		 
		 
		 session.save(item);
		 
		
		 session.save(order);
		 
		 
		 
		session.getTransaction().commit();
		
		
		
		//System.out.println(order.getUser() );
		
		for( Long id1 : order.getItems().keySet() )
		{
			System.out.println( order.getItems().get(id1).getProduct().getName() );
			
		}
		
		System.out.println( Constants.OrderStatus( order.getStatus() ));
		
	}
	
	@Test
	
	public void save( )
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		BaseDAO baseDAO = (BaseDAO)ctx.getBean("baseDAO");
		
		/*Administrator u2 =  baseDAO.getEntityById(Administrator.class, (long)2 );
		
		System.out.println( u2.getName() );
		
		
		Order o1 = new Order( );
		
		
	
		Item t1 = new Item( );
		
		Product p1 = new Product( );
		
		p1.setName("122");
		
		p1.setPrice(12.6);
		
		t1.setProduct(p1);
		
		t1.setNumber(2);
		
		Map<Long, Item >items =  new HashMap<Long, Item >( );
		
		
		
		
		t1.setOrder(o1);
		
		items.put(p1.getId(),  t1 );
		
		o1.setItems(items);
		
		o1.setOrderNum("444111");
		
		o1.setStatus(1);
		
		o1.setUser(u2);
		
	
		
		
		
		
		baseDAO.saveEntity(p1);
		
		baseDAO.saveEntity(t1);
		
	
		
		baseDAO.saveEntity(o1);

		*/
		
		

		User user = baseDAO.getEntityById(User.class, (long)1);
		Product p1 = baseDAO.getEntityById(Product.class, (long)1);
		Product p2 = baseDAO.getEntityById(Product.class, (long)2);
		
		Item item1 = new Item();
		item1.setProduct(p1);
		item1.setNumber(2);
		item1.setCost(item1.getNumber() * p1.getPrice());
		
		Item item2 = new Item();
		item2.setProduct(p2);
		item2.setNumber(1);
		item2.setCost(item2.getNumber() * p2.getPrice());
		
		Map<Long, Item> items = new HashMap<Long, Item>();
		items.put(p1.getId(), item1);
		items.put(p2.getId(), item2);
		
		Order order = new Order(Constants.ORDER_STATUS_POST,user);
		item1.setOrder(order);
		item2.setOrder(order);
		order.setItems(items);
		
		order.setOrderNum("89");
		
		baseDAO.saveEntity(order);
		
		

		
	}
	
	@Test
	public void list( )
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		BaseDAO baseDAO = (BaseDAO)ctx.getBean("baseDAO");
	
		
		List <Order> orders = baseDAO.getAllEntity( "Order" );
		
		for( Order  o : orders )
		{
			System.out.println( o.getStatus() );
		}
		
	}
	
	@Test
	
	public void test1( )
	{
		
		System.out.print();
		
	}
	
	@Test
	
	public void query( )
	{
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		BaseDAO baseDAO = (BaseDAO)ctx.getBean("baseDAO");
		
	/*	Product p1 = baseDAO.getEntityById(Product.class, (long)1);
		
		System.out.println(p1.getName());
		
		
		
		baseDAO.deleteEntity(p1);*/
		
	/*	baseDAO.deleteEntityById(Product.class, (long)2);
		*/
		
		Product p1 = baseDAO.getEntityById(Product.class, (long)3);
		
		System.out.println( p1.getName() );
		
		p1.setName("111");
		
		baseDAO.updateEntity(p1);
		
		
		
		
	}
	
	@Test
	public void user( )
	{
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserDAO userDAO = (UserDAO)ctx.getBean("userDAO");
		
	   User user =	userDAO.getEntityById(User.class, (long)1 );
	   
	   String name = user.getName();
	   
	     String password =  String.valueOf(user.getPassword() );
	   
	   System.out.println(name);
	   
	   System.out.println( password);
	   
	   User u1 =  userDAO.loginCheck("throne212", "123" );
	   
	   System.out.println( u1);
		
	}
	
	@Test
	public void test2( )
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserDAOImpl userDAO = (UserDAOImpl)ctx.getBean("userDAO");
		
		String hql = "from com.cn.shop.model.User u where u.name = ? and u.password = ? ";
		
		List<User> list = userDAO.getHibernateTemplate().find( hql, new String []{"throne212", "123" });
		
		System.out.println( list.size() );
	}

}
