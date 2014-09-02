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
<SCRIPT language=javascript>
			function clearCart(){
				cartForm.action="cart_clear?method=clear";
				cartForm.submit();
			}
			function deleteCartItem(){
				cartForm.action="cart_delete?method=deleteItem";
				cartForm.submit();
			}
		
			function modifyNumber(){
				cartForm.action="cart_modify?method=modifyItemNumber";
				cartForm.submit();
			}
		</SCRIPT>
</head>
<body>
		<H1 align=center>
			购物车
		</H1>
		<FORM name=cartForm action="<%=context %>/from/listaction!list" method=post>
			<input type="hidden" name="method" value="index" />
			<TABLE cellSpacing=0 cellPadding=0 width="75%" align=center border=1>
				<TBODY>
					<TR align=middle>
						<TD width="7%">
							选择
						</TD>
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
								<INPUT type=checkbox value=${item.key } name=itemCheck>
							</TD>
							<TD height=30>
								${item.value.product.name}
							</TD>
							<TD height=30>
								${item.value.product.price}
							</TD>
							<TD height=30>
								<INPUT maxLength=10 size=10 value=${item.value.number
									} name="number${item.key}">
							</TD>
							<TD height=30>
								${item.value.cost}
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
			<BR>
			<BR>
			<TABLE cellSpacing=0 cellPadding=0 width=450 align=center border=0>
				<TBODY>
					<TR align=middle>
						<TD width="22%">
							<INPUT onclick=modifyNumber() type=button value=修改所选项的数量
								name=Button>
						</TD>
						<TD width="20%">
							<INPUT onclick=deleteCartItem() type=button value=删除所选项
								name=Submit2>
						</TD>
						<TD width="26%">
							<INPUT onclick="clearCart();" type=button value=清空购物车
								name=Submit3>
						</TD>
						<TD width="12%">
							<INPUT
								onclick="javascript:location.href='order_index?method=index'"
								type=button value=结账 name=Submit42>
						</TD>
						<TD width="20%">
							<INPUT
								onclick="javascript:location.href='listaction?method=list'"
								type=button value=继续购物 name=Submit42>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<P align=center>
				&nbsp;
			</P>
		</FORM>
	

</body>
</html>