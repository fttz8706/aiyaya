<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>商品信息管理</title>
</head>
<body>
<s:form name='form1' id='form1' method='post' action='wareAction' accept-charset='utf-8'>
	
		<table style="margin:0px auto; margin-top:60px;height: 230px; width:500px; border:#00FF00 solid 1px;">
			<tr>
				<td style="text-align:right;"><label>商品编号:</label></td>
				<td style="text-align:left;">
					<input name="ware.skuId" value="${ware.skuId}"></input>
				</td>
			</tr>
			<tr>
				<td style="text-align:right;"><label>商品名称:</label></td>
				<td style="text-align:left;">
					<input name="ware.wareName" value="${ware.wareName}"></input>
				</td>
			</tr>
			<tr>
				<td style="text-align:right;"><label>单价:</label></td>
				<td>
					<input name="addPrice" value="${ware.price}"></input>
				</td>
			</tr>
			<tr>
				<td style="text-align:right;"><label>备注:</label></td>
				<td><textarea rows="3" cols="50" name="ware.remark">${ware.remark}</textarea></td>
			</tr>
			<tr>
				<td></td>
				<td style="text-align:left;"><label style="color:blue; ">${result}</label></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="reset" value="重置" />&nbsp;<s:submit value="添加"></s:submit></td>
			</tr>
		</table>
		<br/>
</s:form>
</body>
</html>