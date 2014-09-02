<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% String context = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的购物车</title>
</head>
<body>
	
	<form action="<%=context %>/from/loginaction" method="post">

	用户名：<input type="text" name="username"><br>
	
	密码：<input	type="password" name="password"><br>
	
	
	
	<input type="submit" value="提交">
	
	

</form>

</body>
</html>