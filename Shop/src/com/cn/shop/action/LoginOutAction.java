package com.cn.shop.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.cn.shop.common.Constants;
import com.cn.shop.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginOutAction extends ActionSupport {
	
	private HttpServletRequest request;

	private HttpSession session;
	
	 private ServletContext application;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		this.request = ServletActionContext.getRequest();

		this.session = this.request.getSession();
		
		User user = (User) this.session.getAttribute(Constants.SESSION_USER);
		
		System.out.println( user.getName() );
		 
		this.session.removeAttribute(Constants.SESSION_USER );
		
		return "out";
		
		
		
		
	}
	 
	 

}
