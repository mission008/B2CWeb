package com.cn.shop.service;

import java.util.List;
import java.util.Map;

import com.cn.shop.dao.BaseDAO;
import com.cn.shop.model.Product;

public class ProductServiceImpl implements ProductService  {
	
	private BaseDAO baseDAO;
	
	

	public BaseDAO getBaseDAO() {
		return baseDAO;
	}

	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}

	@Override
	public Product getProduct(long productId) {
		// TODO Auto-generated method stub
		return baseDAO.getEntityById(Product.class, productId );
	}

	@Override
	public List<Product> getALLProducts() {
		// TODO Auto-generated method stub
		return baseDAO.getAllEntity("Product");
	}

	//2014.8.28 商品增删改查
	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
		this.baseDAO.saveEntity(product);
		
		
	}

	@Override
	public void deleteProduct(long productId) {
		// TODO Auto-generated method stub
		
		this.baseDAO.deleteEntityById(Product.class, productId );
		
	}

	@Override
	public void UpdateProduct(Product product) {
		// TODO Auto-generated method stub
		
		this.baseDAO.updateEntity(product);
		
	}

	//2014.8.29 实现分页
	@Override
	public List<Product> getByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from Product";
		
		int real = baseDAO.realPage(hql);
		
		return baseDAO.getbyPage(hql, pageNo, pageSize ,real );
		
	}

	@Override
	public int maxSize() {
		// TODO Auto-generated method stub
		
		String hql = "from Product";
		
		int count  = 0;
		
		int maxpage = 0;
		
		
		count =  baseDAO.realPage(hql);
		
		maxpage = ( count + 4 )/5;
		
		return  maxpage;
	}

	//2014.8.31 实现模糊查询
	
	@Override
	public List<Product> find(Map<String, String> keymap, int pageNo,
			int pageSize) {
		
		
		String hql = "from Product as p where ";
		
				 
		 int num = 1;
		 
		 for( String key :  keymap.keySet() )
		 {
			 
			 if( num > 1 )
			 {
				 hql+= " and p.name like '%" + keymap.get(key) + "%'";
			 }
		 	else
			 {
				 hql+=" p.name like '%" + keymap.get(key) + "%'";
			 }
			 
			 num++;
			 
		 }
		 
		
		
		int real = baseDAO.realPage(hql);
		
		return baseDAO.getbyPage(hql, pageNo, pageSize ,real );
		
		
		
	}
	
	//查询的数量 2014.8.31

	@Override
	public int findnum(Map<String, String> keymap) {
		// TODO Auto-generated method stub
		
		String hql = "from Product as p where ";
		
		 
		 int num = 1;
		 
		 for( String key :  keymap.keySet() )
		 {
			 
			 if( num > 1 )
			 {
				 hql+= " and p.name like '%" + keymap.get(key) + "%'";
			 }
		 	else
			 {
				 hql+=" p.name like '%" + keymap.get(key) + "%'";
			 }
			 
			 num++;
			 
		 }
		 
		 int count  = 0;
			
		int maxpage = 0;
		
		 count = baseDAO.realPage(hql);
		
				
		maxpage = ( count + 4 )/5;
		
		return  maxpage;
	}
	
	

	
	

}
