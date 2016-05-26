<%@page import="com.aiyaya.domain.Ware"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%
	String context = request.getContextPath();
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品信息查询</title>
</head>
<body>
<script type="text/javascript">
	function showSkuId(){
		document.getElementById("skuId").style.display="";	
		document.getElementById("wareName").style.display="none";
		document.getElementById("wareNameInput").value='';
	}
	
	function showWareName(){
		document.getElementById("wareName").style.display="";	
		document.getElementById("skuId").style.display="none";
		document.getElementById("skuIdInput").value='';
	}
	
	function hiddenAll(){
		document.getElementById("skuId").style.display="none";
		document.getElementById("wareName").style.display="none";
		document.getElementById("wareNameInput").value='';
		document.getElementById("skuIdInput").value='';
	}
</script>
<s:form name='form1' id="form1" method="post" action="queryWareAction" accept-charset='utf-8'>
	<div style="margin:0px auto; margin-top:60px;height: 70px; width:450px; border:#33FF33 solid 1px;">
		<div>
			<input type="radio" name="queryWareCondition" value="bySkuId" onclick="showSkuId();" style="margin-top: 10px;" />按商品编号查询
			<input type="radio" name="queryWareCondition" value="byWareName" onclick="showWareName();" />按商品名称查询
			<input type="radio" name="queryWareCondition" value="all" onclick="hiddenAll();" />查询所有
			<input type="submit" value="查询"></input>
		</div>
		<div id="skuId" style="display:none">
			<label style="margin-left: 20px;">商品编号：</label>
			<input id="skuIdInput" type="text" name="ware.skuId" value="${ware.skuId}" size="30"/>
		</div>
		<div id="wareName" style="display:none">
			<label style="margin-left: 20px;">商品名称：</label>
			<input id="wareNameInput" type="text" name="ware.wareName" value="${ware.wareName}" size="30"/>
		</div>	
	</div>
	
	<table style="margin:0px auto; margin-top:60px; width:1000px;">
		<tr style="background:#3388FF; "><td>商品编号</td><td>商品名称</td><td>单价</td><td>备注</td><td></td><td></td></tr>
		<s:iterator value="wareList">
			<tr>
				<td><label>${skuId}</label></td>
				<td><label>${wareName}</label></td>
				<td><label>${price}</label></td>
				<td><label>${remark}</label></td>
				<td><a href="<%=context %>/ware/deleteWareAction.action?deleteSkuId=${skuId}" onclick="javascript:return confirm('确定要删除吗？');">删除</a></td>
				<td><a href="<%=context %>/ware/initEditWareAction.action?editSkuId=${skuId}
					&editWareName=${wareName}&editPrice=${price}&editRemark=${remark}">编辑</a></td>
			</tr>
		</s:iterator>
		<%-- <tr><td style="text-align:left;"><label>${result}</label></td></tr> --%>
	</table>
	

</s:form>


</body>
</html>