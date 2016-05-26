<%@ page import="com.aiyaya.domain.Member" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String context = request.getContextPath();
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<META http-equiv="Content-Script-Type" content="text/javascript">
<title>添加会员</title>
<script charset="gb2312" type="text/javascript" src="<%=context %>/js/My97DatePicker/WdatePicker.js"></script>
<script charset="gb2312" type="text/javascript" src="<%=context %>/js/paramCheck.js"></script>
</head>
<script type="text/javascript">
	function checkEmpty(){
		var obj1 = document.getElementById("member_mrCardId");
		var obj2 = document.getElementById("member_name");

		var sexRadios = document.getElementsByName("member.sex");
		var i = 0;
		for(; i < sexRadios.length; i++){
			if(sexRadios[i].checked){
				break;
			}
		}
		if(i == sexRadios.length || ''==obj1.value || ''==obj2.value){
			alert("会员卡号、姓名和性别不能为空！");
			return false;
		}
		return true;
	}
</script>
<body>
<s:form id="form1" name="form1" method="post" action="addMemberAction" accept-charset='utf-8'>
	<h1>添加会员信息</h1>
	<hr>
	<table style="margin:0px auto; margin-top:60px; width:1000px;">
		<tr>
			<td style="text-align:right;"><label>会员卡号:</label></td>
			<td>
				<input id="member_mrCardId" name="member.mrCardId" value="${member.mrCardId}"></input>
				<label style="text-align:left; color:red;">*</label>
			</td>
		</tr>
		<tr>
			<td style="text-align:right;"><label>姓名:</label></td>
			<td>
				<input id="member_name" name="member.name" value="${member.name}"></input>
				<label style="text-align:left; color:red;">*</label>
			</td>
		</tr>
		<tr>
			<td style="text-align:right;"><label>性别:</label></td>
			<td>
				&nbsp;
				<label>男</label><input id="sex_male" type="radio" name="member.sex" value="男"></input>
				<label>女</label><input id="sex_female" type="radio" name="member.sex" value="女"></input>
				<label style="text-align:left; color:red;">*</label>
			</td>
		</tr>
		<tr>
			<td style="text-align:right;"><label>手机号:</label></td>
			<td><input id="phone" name="member.phone" value="${member.phone}" onblur="checkPhone('phone')"></input></td>
		</tr>
		<tr>
			<td style="text-align:right;"><label>级别:</label></td>
			<td><input name="member.grade" value="${member.grade}"></input></td>
		</tr>
		<tr>
			<td style="text-align:right;"><label>出生日期:</label></td>
			<td><input type="text" name="member.birthday" 
			onFocus="WdatePicker(this)" readonly="true"></input></td>
		</tr>
		<tr>
			<td style="text-align:right;"><label>皮肤类型:</label></td>
			<td><input name="member.skinType" value="${member.skinType}"></input></td>
		</tr>
		<tr>
			<td style="text-align:right;"><label>QQ号码:</label></td>
			<td><input name="member.qq" value="${member.qq}"></input></td>
		</tr>
		<tr>
			<td style="text-align:right;"><label>电子邮件:</label></td>
			<td><input name="member.email" value="${member.email}"></input></td>
		</tr>
		<tr>
			<td style="text-align:right;"><label>推荐人:</label></td>
			<td><input name="member.recommender" value="${member.recommender}"></input></td>
		</tr>
		<tr>
			<td style="text-align:right;"><label>推荐人手机号码:</label></td>
			<td><input id="recommenderPhone" name="member.recommenderPhone" value="${member.recommenderPhone}" onblur="checkPhone('recommenderPhone')" /></td>
		</tr>
		<tr>
			<td style="text-align:right;"><label>意见与建议:</label></td>
			<td><textarea rows="3" cols="50" name="member.suggest">${member.suggest}</textarea></td>
		</tr>
		<tr>
			<td style="text-align:right;"><label>备注:</label></td>
			<td><textarea rows="3" cols="50" name="member.remark">${member.remark}</textarea></td>
		</tr>
		<tr>
			<td />
			<td  style="text-align:left;">
				<label style="color:blue;">${addMemberResult}</label>
			</td>
		</tr>		
		<tr>
			<td></td>
			<td><input type="reset" value="重置"></input> &nbsp; <input type="submit" value="添加" onclick="return checkEmpty();" /></td>
		</tr>
	</table>

</s:form>

</body>
</html>