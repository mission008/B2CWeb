package com.cn.shop.action;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cn.shop.common.Constants;
import com.cn.shop.model.Administrator;
import com.cn.shop.model.User;
import com.cn.shop.service.UserService;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction  extends ActionSupport {
	
	private String username;
	
	private String password;
	
	private UserService userService;
	
	private HttpServletRequest request;

	private HttpSession session;
	
	 private ServletContext application;

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	

	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		this.request = ServletActionContext.getRequest();

		 this.session = this.request.getSession();

		 

		
		String ret="";
		
		User user = this.userService.login(username, password);
		
		if( user == null )
		{
			this.request.setAttribute("msg", "登录失败");
			
			ret="restart";
			
		}
		else
		{
			this.session.setAttribute(Constants.SESSION_USER, user );
			
			//判断是否为管理员，若是跳到后台
			
			if( user instanceof Administrator )
			{
				ret = "manager";
			}
			else
			{
			
				ret="user";
			}
		}
		
		return ret;
		
	}
	
	
	
	

}
