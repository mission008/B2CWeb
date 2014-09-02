package com.cn.shop.dao;

import java.io.Serializable;
import java.util.List;

import com.cn.shop.model.User;

public class UserDAOImpl  extends BaseDAOImpl implements UserDAO {

	@Override
	public User loginCheck(String name, String password) {
		// TODO Auto-generated method stub
		
		/*String hql = "from com.cn.shop.model.User u where u.name = ? and u.password = ? ";
		
		List<User> list = this.getHibernateTemplate().find( hql, new String []{"throne212", "123" });*/
		
		String hql = "from com.cn.shop.model.User u where u.name = "+"'"+name +"'" + " " + "and u.password =" + " " + "'"+password +"'";
		
		List<User> list = this.getHibernateTemplate().find( hql);
		
		if( list != null && list.size() >0 )
		{
			super.logger.info("login check succ, user.name=" + list.get(0).getName());
			
			return list.get(0);
		}
		else
		{
		
			return null;
		}
		
		
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
		super.saveEntity(user);
		
	}

	

}
