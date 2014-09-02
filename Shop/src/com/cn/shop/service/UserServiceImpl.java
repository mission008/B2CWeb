package com.cn.shop.service;

import com.cn.shop.dao.UserDAO;
import com.cn.shop.model.User;

public class UserServiceImpl  implements UserService  {
	
	private UserDAO userDAO;
	
	

	public UserDAO getUserDAO() {
		return userDAO;
	}



	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}



	@Override
	public User login(String name, String password) {
		// TODO Auto-generated method stub
		return userDAO.loginCheck(name, password);
	}



	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		
		this.userDAO.save(user);
		
	}
	

}
