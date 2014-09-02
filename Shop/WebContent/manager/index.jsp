<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String context = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台界面</title>
</head>
<body>

	<a href="<%=context %>/manager/addProduct.jsp">添加商品</a>&nbsp;&nbsp;
	
	<br/>
	<a href="<%=context %>/manager/listproduct">商品列表</a>&nbsp;&nbsp;
	<br/>
		
	<a href="<%=context %>/manager/manager">查看订单状态</a>&nbsp;&nbsp;
	
	<br/>
	<a href="<%=context %>/from/listaction!list?page=1"> 返回前台首页</a>
	

</body>
</html>