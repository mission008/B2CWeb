<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="s" uri="/struts-tags" %>  
  
<%  
  
String context = request.getContextPath();  
   
%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修噶商品</title>
</head>
<body>
	<form action="<%=context %>/manager/save" method="post" enctype="multipart/form-data">
    　　
    	<table border="1">
    	
    		<tr><td>商品名称:<td><input type="text" name="name" value="${updateproduct.name }"></td></tr>
    		
    		<tr><td>商品价格:<td><input type="text" name="price" value="${updateproduct.price }"></td></tr>
    		
    		<tr><td>商品描述:<td><input type="text" name="description" value="${updateproduct.description }"></td></tr>
    		<tr><td>商品图片:<td><input type="file" name="file"></td></tr>    	
    	
    	</table>
  		      
        <input type="submit" value="提交">
        
        <input type="reset" value="重置">
        
    </form>

</body>
</html>