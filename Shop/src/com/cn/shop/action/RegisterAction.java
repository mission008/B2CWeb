package com.cn.shop.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.cn.shop.common.Constants;
import com.cn.shop.dto.UserDTO;
import com.cn.shop.model.User;
import com.cn.shop.service.UserService;
import com.cn.shop.util.EmailAttachmentSender;
import com.cn.shop.util.ProductCode;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements ModelDriven  {
	
	private UserDTO userDTO = new UserDTO( );
	
	private User user = new User( );
	
	private UserService userService;
	
	//获的session
	private Map<String, Object> session;
	

	
	//邮件注册
	
	private EmailAttachmentSender emailSender = new EmailAttachmentSender( );
	
	private String username;
	
	//动态验证码
	
	private HttpServletRequest request;
	
	private HttpServletResponse response;
	
	
	
	
	//用户注册
	
	
	public String userRegister( )
	{
		
		session = (Map)ActionContext.getContext().getSession();
		
		//修改bug 修改session获得不稳定性 
		
		/*String rand = ""; 
				
		rand = (String) request.getSession().getAttribute("rand");
		
		if( rand == null )
		{
			rand =" ";
		}
		
		System.out.println("验证码"+ rand);
		
		
		
		
		String ret = "";
		
		int p1 = 0+ userDTO.getPassword1();
		
		int p2 = 0+  userDTO.getPassword2();
		
		if(( p1 != p2 ) || ( p1 == 0 )  )
		{
			ret = "reset"; //重新进入注册页面
		}
		//else if( (!userDTO.getRand().equals(rand ) ) || userDTO.getRand() == null  )
		
		
		//bug 
		
		else if( ( !rand.equals(userDTO.getRand() )  ) ||  userDTO.getRand() == null  )
		{
			ret = "reset"; //重新进入注册页面
		}*/
		
		
				//session 一直有bug 注意 2014.8.30
		
				String rand = (String) request.getSession().getAttribute("rand");
				
				System.out.println("验证码"+ rand);
				
					
				String ret = "";
				
				if(( userDTO.getPassword1() != userDTO.getPassword2() )  )
				{
					ret = "reset"; //重新进入注册页面
				}
				//else if( (!userDTO.getRand().equals(rand ) ) || userDTO.getRand() == null  )
				
				//修改bug 2014.8.29
				else if( (!rand.equals(userDTO.getRand())) || userDTO.getRand() == null )
				{
					ret = "reset"; //重新进入注册页面
				}
				else if( ( !rand.equals(userDTO.getRand() )  ) ||  userDTO.getRand() == null  )
				{
					ret = "reset"; //重新进入注册页面
				}
			
		
		else if( ( userDTO.getEmail() != null ) && ( userDTO.getName() !=null )  ) 
		{
			
			user.set(userDTO);
			
			session.put(user.getName(),  user );
			
		
			
			//发送邮件
			
			emailSender.send(user.getEmail(), user.getName() );
			
			ret ="verify"; //登录邮箱验证
						
			
		}
		else
		{
			ret = "reset"; //重新进入注册页面
		}
		
						
		return ret;
		
		
		
		
	}
	
	public String usersave( )
	{
		
		session = (Map)ActionContext.getContext().getSession();
		
		
		User u = (User) session.get( username );
		
	
		
		
		System.out.println( username + u.getEmail() );
		
		
		
		userService.add(u);
		
		return "save";
		
		
		
	}
	
	public void  code( )
	{
		request = ServletActionContext.getRequest();
		
		response = ServletActionContext.getResponse();
		
		ProductCode.productCode(request, response);
		
		
	}
	

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return userDTO;
	}

	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
	
	

}
