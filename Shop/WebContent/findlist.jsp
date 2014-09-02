<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String context = request.getContextPath(); %>


<%@taglib uri="/struts-tags" prefix="s" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的购物车</title>
</head>
<body>
		<H1 align=center>
			本系统的所有商品列表如下：
			<BR>
			<BR>
			<TABLE width=800 border=1>
				<TBODY>
					<TR height=50>
						<TD>
							产品图片
						</TD>
						<TD>
							产品名称
						</TD>
						<TD>
							添加到购物车
						</TD>
					</TR>
					<%-- <c:forEach var="p" items="${requestScope.products}">
					<TR>
						<TD>
							${p.name}
						</TD>
						<TD>
							<A href="ListAction.do?method=addItem&productId=${p.id}">添加到购物车</A>
						</TD>
					</TR>
					</c:forEach> --%>
					
					<s:iterator value ="findlist" var="p">
					<TR>
						<TD>
						
						
							
					<!--  	<img  src="<c:url value='<%=context %>/from/showaction?imageUrl=${p.imageSrc }'/>"/> -->
					
					<%-- <img src="${p.imageSrc }" style="height:60px; width:80px" /> --%>
					
					
					<!-- 配置server。xml  客户端使用相对地址 -->
				
					<img src="<%=context %>/UploadImages/${p.imageSrc }" style="height:60px; width:80px" />
							
							
						</TD>
						
						<TD>

						<s:property value="#p.name"/> |
						</TD>
						<TD>
						
						
						<a href="<%=context %>/from/addaction!addItem?type=1&productId=<s:property value="#p.id"/>">添加到购物车</a>
						<%-- <a href="<%=context %>/admin/Category_updateinput?id=<s:property value="#c.id"/>">修改Category</a> --%>
						</TD>
					</TR>
						</s:iterator>
				</TBODY>
			</TABLE>
			
			<!-- 2014.8.29 分页功能 -->
				<BR>
				
				<s:set name="page" value="#request['fpage']" />
				
				<s:set name="maxpage" value="#request['fmaxpage']" />
					
				<s:if test="#page==1">首页</s:if>
	
				<s:if test="#page>1 "><a href="<%=context %>/from/find?page=1"> 首页</a></s:if>
					
				<s:if test="#page == 1 ">上一页</s:if>
					
				<s:if test="#page>1 "><a href="<%=context %>/from/find?page=${page-1}"> 上一页</a></s:if>
					
				<s:if test="#page ==#maxpage">下一页</s:if>
					
				<s:if test="#page< #maxpage "><a href="<%=context %>/from/find?page=${page + 1}"> 下一页</a></s:if>
					
				<s:if test="#page == #maxpage">末页</s:if>
					
				<s:if test="#page< #maxpage  "><a href="<%=context %>/from/find?page=${maxpage}">末页</a></s:if>
					
						
			
			
			
					
			<BR>
						
			<a href="<%=context %>/from/cart_inedx!CartIndex">查看购物车</a>&nbsp;&nbsp;
			<a href="<%=context %>/from/order_index!index">结帐</a>&nbsp;&nbsp;
			<a href="<%=context %>/from/listaction!list?page=1"> 返回首页</a>&nbsp;&nbsp;
			<a href="<%=context %>/from/loginaction">登录</a>&nbsp;&nbsp;
			<a href="<%=context %>/userregister.jsp">注册</a>&nbsp;&nbsp;
			<!-- <A href="CartAction.do?method=index">查看购物车</A>&nbsp;&nbsp;
			<A href="OrderAction.do?method=index">结账</A>&nbsp;&nbsp;
			<A href="login.jsp">登录</A> -->
		</H1>

</body>
</html>