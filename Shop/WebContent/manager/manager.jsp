<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <% String context = request.getContextPath(); %>

<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
</head>
<body>

	<H1 align=center>
			订单列表
		</H1>
		<BR>
		<TABLE width=600 border=1 align="center">
			<TBODY>
				<TR height=25>
					<TD>
						订单状态
					</TD>
					<TD>
						订单用户名
					</TD>
					<TD>
						订单号
					</TD>
					<TD>
						订单总价
					</TD>
					<TD>
						操作
					</TD>
				</TR>
				<%-- <c:forEach var="o" items="${requestScope.orders}">
					<TR>
						<TD>
							${o.statusText}
						</TD>
						<TD>
							${o.user.name}
						</TD>
						<TD>
							${o.orderNum}
						</TD>
						<TD>
							${o.cost}
						</TD>
						<TD>
							<c:if test="${o.status != 4}">
								<A href="ManageAction.do?method=next&orderId=${o.id}">下一步</A>
							</c:if>
						</TD>
					</TR>
				</c:forEach> --%>
					<s:iterator value ="orders" var="o">
					<TR>
						<TD>

						<s:property value="#o.status"/> 
						
						</TD>
						
						<TD>

						<s:property value="#o.user.name"/> 
						
						</TD>
						<TD>

						<s:property value="#o.orderNum"/> 
						
						</TD>
						<TD>

						<s:property value="#o.cost"/> 
						
						</TD>
						<TD>
							<c:if test="${o.status != 4}">
					
								<a href="<%=context %>/manager/nextaction!next?orderId=<s:property value="#o.id"/>">下一步</a>
								
							</c:if>
						
						
						<%-- <a href="<%=context %>/admin/Category_updateinput?id=<s:property value="#c.id"/>">修改Category</a> --%>
						</TD>
					</TR>
						</s:iterator>
			</TBODY>
		</TABLE>
		<BR>
		<center>
	
			<a href="<%=context %>/from/loginoutaction">退出<a>
			
			<a href="<%=context %>/manager/index.jsp">返回主页</a>
			
		</center>
	</BODY>

</body>
</html>