<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%	
	String context = request.getContextPath();
	request.setCharacterEncoding("utf-8"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<META http-equiv="Content-Script-Type" content="text/javascript">
<title>会员购物记录</title>
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
	function addShopRecord(){
		var mrCardId = document.getElementById("mrCardId").value;
		window.open ("<%=context%>/initAddShopRecord.action?mrCardId="+mrCardId, "newwindow", "height=450, width=600,top=150, left=350, toolbar= no, menubar=no, scrollbars=no, resizable=no, location=no, status=no"); 
	}
</script>
</head>
<body>
<s:form id="form1" name="form1" method="post" action="" accept-charset='utf-8' target="mainFrame">
	<h1>会员详情页</h1>
	<hr>
	
	<!-- begin 显示会员详细信息 -->
	<table id="showMemberInfo" style="margin-left:10px; margin-top:60px; width:90%; border:1px solid #00FF00; ">
		<tr style="margin-left: 20px;">
			<td><label>会员卡号：</label><label class="member_text">${member.mrCardId}</label>
				<input id="mrCardId" type="hidden" name="member.mrCardId" value="${member.mrCardId}" />
			</td>
			<td><label>手机：</label><label class="member_text">${member.phone}</label></td>
			<td><label>姓名：</label><label class="member_text">${member.name}</label></td>
			<td><label>级别：</label><label class="member_text">${member.grade}</label></td>
		</tr>
		<tr>
			<td><label>性别：</label><label class="member_text">${member.sex}</label></td>
			<td><label>生日：</label><label class="member_text">${member.birthday}</label></td>
			<td><label>皮肤类型：</label><label class="member_text">${member.skinType}</label></td>
			<td><label>QQ号码：</label><label class="member_text">${member.qq}</label></td>
		</tr>
		<tr>
			<td><label>Email：</label><label class="member_text">${member.email}</label></td>
			<td><label>推荐人：</label><label class="member_text">${member.recommender}</label></td>
			<td><label>推荐人手机号：</label><label class="member_text">${member.recommenderPhone}</label></td>
			<td><label>总积分：</label><label style="color: #FF0000; font-family: 微软雅黑;">${member.point}</label></td>
		</tr>
		<tr>
			<td><label>皮肤状况及沟通意见：</label><label class="member_text">${member.suggest}</label></td>
			<td><label>备注：</label><label class="member_text">${member.remark}</label></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	<br>
	<input type="button" value="添加购物记录" style="margin-left:10px;" onclick="addShopRecord()"/>
	<!-- end 显示会员详细信息 -->
	<br>
	
	<!-- begin 加载会员购物记录 -->
	<table id="showShopRecord" style="margin-left:10px; margin-top:60px; width:1000px;">
		<tr style="background-color:#0077FF;">
			<td><label>购物时间</label></td>
			<td><label>商品名称</label></td>
			<td><label>商品编号</label></td>
			<td><label>数量</label></td>
			<td><label>单价(元)</label></td>
			<td><label>小计(元)</label></td>
			<td><label>备注</label></td>
			<td><label>删除</label></td>
		</tr>
		<s:iterator value="sellRecords">
			<tr>
				<td><label>${date}</label></td>
				<td><label>${wareName}</label></td>
				<td><label>${skuId}</label></td>
				<td><label>${num}</label></td>
				<td><label>${price}</label></td>
				<td><label>${totalMoney}</label></td>
				<td><label>${remark}</label></td>
				<td><a href="<%=context %>/deleteSellRecordAciton.action?sId=${sId}" onclick="javascript:return confirm('确定要删除吗？');">删除</a></td>
			</tr>
		</s:iterator>
	</table>
	<!-- end 加载会员购物记录 -->
	
</s:form>
</body>
</html>