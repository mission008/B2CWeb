<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String context = request.getContextPath(); %>

<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
</head>
<body>

	<body>
		<H1 align=left>
			本系统的所有商品列表如下：
			<BR>
			<BR>
			<TABLE width=900 border=1>
				<TBODY>
					<TR height=40>
						<TD>
							产品图片
						</TD>
						<TD>
							产品名称
						</TD>
						<TD>
							产品价格
						</TD>
						<TD>
							产品描述
						</TD>
						<TD>
							修改商品
						</TD>
						<TD>
							删除商品
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
					
					<s:iterator value ="productlist" var="p">
					<TR>
						<TD>
						
						
							
					<!--  	<img  src="<c:url value='<%=context %>/from/showaction?imageUrl=${p.imageSrc }'/>"/> -->
					
					<!--  <img src="${p.imageSrc }" style="height:50px; width:80px" /> -->
					
						<!-- 2014.9.2 配置server。xml  客户端使用相对地址 -->
				
						<img src="<%=context %>/UploadImages/${p.imageSrc }" style="height:60px; width:80px" />		
							
						</TD>
						
						<TD>

						<s:property value="#p.name"/> |
						</TD>
						
						<TD>

						<s:property value="#p.price"/> |
						</TD>
						
						<TD>

						<s:property value="#p.description"/> |
						</TD>
						
						
						<TD>
						
						
						<a href="<%=context %>/manager/update?productId=<s:property value="#p.id"/>">修改商品</a>
						<%-- <a href="<%=context %>/admin/Category_updateinput?id=<s:property value="#c.id"/>">修改Category</a> --%>
						</TD>
						
						<TD>
						
						
						<a href="<%=context %>/manager/delete?productId=<s:property value="#p.id"/>">删除商品</a>
						<%-- <a href="<%=context %>/admin/Category_updateinput?id=<s:property value="#c.id"/>">修改Category</a> --%>
						</TD>
						
					</TR>
						</s:iterator>
				</TBODY>
			</TABLE>
			
			<!-- 2014.8.29 分页功能 -->
				<BR>
				
				<s:set name="page" value="#request['page']" />
				
				<s:set name="maxpage" value="#request['maxpage']" />
					
				<s:if test="#page==1">首页</s:if>
	
				<s:if test="#page>1 "><a href="<%=context %>/manager/listproduct?page=1"> 首页</a></s:if>
					
				<s:if test="#page == 1 ">上一页</s:if>
					
				<s:if test="#page>1 "><a href="<%=context %>/manager/listproduct?page=${page-1}"> 上一页</a></s:if>
					
				<s:if test="#page ==#maxpage">下一页</s:if>
					
				<s:if test="#page< #maxpage "><a href="<%=context %>/manager/listproduct?page=${page + 1}"> 下一页</a></s:if>
					
				<s:if test="#page == #maxpage">末页</s:if>
					
				<s:if test="#page< #maxpage  "><a href="<%=context %>/manager/listproduct?page=${maxpage}">末页</a></s:if>
				
				<BR>
				
				<a href="<%=context %>/manager/index.jsp">返回主页</a>
				
				
					
						
	</H1>
</body>
</html>