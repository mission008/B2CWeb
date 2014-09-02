package com.cn.shop.dao;

import java.io.Serializable;
import java.util.List;


//基础DAO，包含基本的实体类增删改查操作

public interface BaseDAO {
	
	//保存一个实体对象
	public <T> void saveEntity( T entity );
	
	//删除一个实体对象
	
	public <T> void deleteEntity( T entity );
	
	//根据实体类型和ID删除一个实体对象
	public <T> void deleteEntityById( Class <T> entityClass , Serializable id );
	
	//修改一个实体对象
	
	public <T> void updateEntity( T entity );
	
	//查询某个实体的全部实例
	
	public <T> List<T> getAllEntity( String entityName );
	
	//通过主键获的一个实体对象
	
	public <T> T getEntityById( Class<T> entityClass , Serializable id );
	
	//2014.8.29添加商品分页功能
	
	//分页
	
	public <T> List<T> getbyPage(String hql, int pageNo, int pageSize  ,int real  );
	
	//最页码
	
	public <T> int realPage( String hql );
	
	
	

}
