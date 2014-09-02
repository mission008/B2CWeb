<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% String context = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索商品</title>
</head>
<body>

	<form action="<%=context %>/from/find" method="post">

	搜索框：<input type="text" name="keyword"><br>
		
	<input type="submit" value="提交">
	
	<input type="reset" value="重置">
	
	

	</form>

</body>
</html>