package com.cn.shop.service;

import com.cn.shop.model.User;

public interface UserService {
	
	public User login( String name, String password );
	
	public void add( User user );
	
	

}
