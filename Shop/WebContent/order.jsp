<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String context = request.getContextPath(); %>

<%@taglib uri="/struts-tags" prefix="s" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的购物车</title>
</head>
<body>

	<H1 align=center>
			你所购买的商品如下：
		</H1>
		<TABLE cellSpacing=0 cellPadding=0 width="75%" align=center border=1>
			<TBODY>
				<TR align=middle>
					<TD width="21%" height=30>
						商品名称
					</TD>
					<TD width="14%" height=30>
						单价
					</TD>
					<TD width="25%" height=30>
						数量
					</TD>
					<TD width="33%" height=30>
						合计
					</TD>
				</TR>
				<c:forEach var="item" items="${sessionScope.cart.items}">
					<TR align=middle>
						<TD height=30>
							${item.value.product.name }
						</TD>
						<TD height=30>
							${item.value.product.price }
						</TD>
						<TD height=30>
							${item.value.number }
						</TD>
						<TD height=30>
							${item.value.cost }
						</TD>
					</TR>
				</c:forEach>
				<TR>
					<TD colSpan=5 height=30>
						您的购物车中所有商品总金额：${sessionScope.cart.price }
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<P>
		<H1 align=center>
			用户联系方式如下：
		</H1>
		<P></P>
		<form action="<%=context %>/from/cart_post!postOrder" method="post">
			<!-- <html:hidden property="method" value="postOrder" /> -->
			<TABLE cellSpacing=0 cellPadding=0 width=500 align=center border=0>
				<TBODY>
					<TR>
						<TD width=117 height=23>
							姓名：
						</TD>
						<TD width=383>
							<INPUT value="${sessionScope.user.name }" name="name">
						</TD>
					</TR>
					<TR>
						<TD height=24>
							地址：
						</TD>
						<TD>
							<INPUT value="${sessionScope.user.address }" name="address">
						</TD>
					</TR>
					<TR>
						<TD height=24>
							邮政编码：
						</TD>
						<TD>
							<INPUT value="${sessionScope.user.postCode }" name="postCode">
						</TD>
					</TR>
					<TR>
						<TD height=23>
							E-mail：
						</TD>
						<TD>
							<INPUT value="${sessionScope.user.email }" name="email">
						</TD>
					</TR>
					<TR>
						<TD height=23>
							联系电话：
						</TD>
						<TD>
							<INPUT value="${sessionScope.user.cellPhone }" name="phone">
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<BR>
			<TABLE cellSpacing=0 cellPadding=0 width=500 align=center border=0>
				<TBODY>
					<TR>
						<TD align=middle>
							<!-- <INPUT type=submit value=结帐 name=Submit> -->
							<input type="submit" value="结帐">
						</TD>
						<TD align=middle>
							<INPUT
								onclick="javascript:location.href='listaction?method=list'"
								type=button value="继续购物" name=Submit42>
						</TD>
						<TD align=middle>
							<INPUT
								onclick="javascript:location.href='cart_inedx?method=CartIndex'"
								type=button value="回到购物车" name=Submit42>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
		</form>

</body>
</html>