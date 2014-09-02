<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String context = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>

<!-- private Long id; //主键   主键和manager主键问题
	
	private String name; //用户名
	
	private  int password; //密码
	
	private String address; //地址
	
	private String postCode; //邮编
	
	private String email; //email地址
	
	private String homePhone;// 家庭电话号码
	
	private String cellPhone; //手机号码
	
	private String officePhone; //办公室电话号码 -->
	
	<h1>用户注册</h1>
	
	
	<form action="<%=context %>/from/user_register"  method="post">
	
	<table    border="1">
	
	<tr><td>用户名：<td> <input type="text" name="name"></td></tr>
	<tr><td>密码：<td> <input type="password" name="password1"></td></tr>
	<tr><td>确定密码：<td> <input type="password" name="password2"></td></tr>
	<tr><td>地址：<td> <input type="text" name="address"></td></tr>
	<tr><td>邮编：<td> <input type="text" name="postCode"></td></tr>
	<tr><td>E-Mail：<td> <input type="text" name="email"></td></tr>
	<tr><td>家庭电话号码：<td> <input type="text" name="homePhone"></td></tr>
	<tr><td>手机号码：<td> <input type="text" name="cellPhone"></td></tr>
	<tr><td>办公室号码：<td> <input type="text" name="officePhone"></td></tr>
	<tr>
	<td>验证码：<td> <input type="text" name="rand" size="4">
	
	&nbsp;
	
	<img  src="<c:url value="/from/user_code"/>"/>
	
	</td>
	
	</tr>
	<tr>
		
		<td colspan="2" align="center">
		
		<input type="submit" value="注册">
		
		<input type="reset" value="重置">
		
		</td>
	
	</table>
	
	
		
	
	</form>
		
</body>
</html>