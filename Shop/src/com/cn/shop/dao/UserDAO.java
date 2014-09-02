package com.cn.shop.dao;

import com.cn.shop.model.User;

public interface UserDAO extends BaseDAO  {
	
	// 登录验证，如果失败返回null
		public User loginCheck(String name, String password);
		
		public void save( User user );
		

}
