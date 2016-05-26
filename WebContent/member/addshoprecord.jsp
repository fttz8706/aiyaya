<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%	
	String context = request.getContextPath();
	request.setCharacterEncoding("utf-8"); 
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加购物记录</title>
<script charset="gb2312" type="text/javascript" src="<%=context %>/js/My97DatePicker/WdatePicker.js"></script>
<script charset="gb2312" type="text/javascript" src="<%=context %>/js/paramCheck.js"></script>
<style type="text/css">
	.member_text{
		color: #2F2FFF;
		font-family: 微软雅黑;
	}
	.text_right{
		text-align:right;
	}
	.text_left{
		text-align:left;
	}
</style>
<script type="text/javascript">
	function checkEmpty(){
		var skuId = document.getElementById("skuId").value;
		var num = document.getElementById("num").value;
		var shopdate = document.getElementById("shopdate").value;
		if(skuId == ''){
			alert("商品编号不能为空！");
			document.getElementById("skuId").focus();
			return false;
		}
		if(num == ''){
			alert("商品数量不能为空！");
			document.getElementById("num").focus();
			return false;
		}
		if(shopdate == ''){
			alert("购物日期不能为空！");
			document.getElementById("shopdate").focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<s:form id="form1" name="form1" method="post" action="addShopRecord" accept-charset='utf-8' target="mainFrame">
<h1>新增购物记录</h1>
<hr>
<!-- begin 添加购物记录 -->
	<table id="addShopRecord" style="margin-left:10px; margin-top:20px; width:600px;">
		<tr>
			<td class="text_right"><label>商品编号：</label></td>
			<td><input id="skuId" type="text" name="sellRecord.skuId"></input></td>
		</tr>
		<tr>
			<td class="text_right"><label >商品数量：</label></td>
			<td><input id="num" type="text" name="sellRecord.num"></input></td>
		</tr>
		<tr>
			<td class="text_right"><label>购物日期：</label></td>
			<td><input id="shopdate" type="text" onFocus="WdatePicker(this)" name="sellRecord.date"></input></td>
		</tr>
		<tr>
			<td class="text_right"><label>备注说明：</label></td>
			<td><textarea rows="5" cols="30" name="sellRecord.remark"></textarea></td>
		</tr>
		<tr><td></td><td><label>${result}</label></td></tr>
		<tr>
			<td></td>
			<td>
				<input type="reset" value="重置" />
				<input type="submit" value="提交" onclick="return checkEmpty();" />
				
			</td>
		</tr>
	</table>
	<!-- end 添加购物记录 -->
</s:form>
</body>
</html>