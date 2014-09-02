package com.cn.shop.service;

import java.util.List;
import java.util.Map;

import com.cn.shop.model.Product;

public interface ProductService {
	
	//通过商品id获得商品对象
	public Product getProduct( long productId );
	
	//获的所有的商品
	
	public List<Product> getALLProducts( );
	
	//2014.8.28 商品的增删改查
	
	public void addProduct( Product product );
	
	public void deleteProduct( long productId );
	
	public void UpdateProduct( Product product );
	
	//分页显示 2014.8.29
	
	public List<Product> getByPage( int pageNo, int pageSize  );
	
	public int maxSize( );
	
	//模糊查询
	
	public List<Product> find ( Map<String , String >keymap, int pageNo, int pageSize  );
	
	
	//查询数量
	
	public int findnum( Map<String , String >keymap );
	
	
	

}
