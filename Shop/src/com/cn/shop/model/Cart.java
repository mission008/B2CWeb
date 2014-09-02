package com.cn.shop.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

//购物车
public class Cart {
	
	//定义一个日志
	private Logger logger = Logger.getLogger(this.getClass());
	
	//产品id 项目记录
	private Map< Long, Item > items = new HashMap<Long, Item >( );
	
	//添加商品到购物车
	
	public  void addItem( Product product , int number )
	{
		if( items.containsKey(product.getId()))
		{
			return;
		}
		Item item = new Item( number, product );
		
		items.put(product.getId(),  item );
		
	}
	
	//修改商品数量
	public void modifyNumberBYProductId( long productId, int number )
	{
		Item item = items.get(productId);
		
		item.setNumber(number);
		
	}
	
	//删除商品项目
	
	public void deleteItemByProductId( long productId )
	{
		items.remove(productId);
		
	}

	//删除多个商品项目
	
	public void deleteItemByProductId( Long [] productIds )
	{
		for( Long id : productIds )
		{
			items.remove(id );
		}
	}
	
	
	//清空购物车
	
	public void clear( )
	{
		items.clear();
		
		logger.info("Cart cleared. size="+ items.size() );
		
	}
	
	//获得所有项目
	
	
	public  Map<Long , Item > getCartItems( )
	{
		return items;
		
	}
	
	//购得购物车项目的数目
	
	public int getItemNumber( )
	{
		return items.size();
	}
	
	//判断购物车是否为空
	public boolean isEmpty( )
	{
		return items.isEmpty();
		
	}
	
	//购物车所有商品的总价
	
	public Double getPrice( )
	{
		double sum = 0;
		
		for( Long id : items.keySet() )
		{
			Item item = items.get(id);
			
			sum+=item.getCost();
			
		}
		
		return sum;
	}

	public Map<Long, Item> getItems() {
		return items;
	}

	public void setItems(Map<Long, Item> items) {
		this.items = items;
	}
	
	
	
	
}

