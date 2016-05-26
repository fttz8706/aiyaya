<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.aiyaya.domain.Member" %>
<%
	String context = request.getContextPath();
	request.setCharacterEncoding("utf-8");
	Member member = (Member)request.getAttribute("member");
	boolean isFirstPage = true;
	boolean isLastPage = true;
	if(null != member){
		isFirstPage = member.isFirstPage();
		isLastPage = member.isLastPage();
		
	}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会员信息检索</title>
</head>
<script type="text/javascript">
function showName(){
	document.getElementById("name").style.display="";	
	document.getElementById("tel").style.display="none";
	document.getElementById("cardId").style.display="none";
	document.getElementById("telInput").value='';
	document.getElementById("cardIdInput").value='';
}

function showTel(){
	document.getElementById("tel").style.display="";	
	document.getElementById("name").style.display="none";
	document.getElementById("cardId").style.display="none";
	document.getElementById("nameInput").value='';
	document.getElementById("cardIdInput").value='';
}

function showCardId(){
	document.getElementById("cardId").style.display="";	
	document.getElementById("name").style.display="none";
	document.getElementById("tel").style.display="none";
	document.getElementById("nameInput").value='';
	document.getElementById("telInput").value='';
}

function hiddenAll(){
	document.getElementById("cardId").style.display="none";	
	document.getElementById("name").style.display="none";
	document.getElementById("tel").style.display="none";
	document.getElementById("nameInput").value='';
	document.getElementById("telInput").value='';
	document.getElementById("cardIdInput").value='';
}

function setPageSize(){
	var obj = document.getElementById("pageSize");
	var selectedValue = obj.options[obj.selectedIndex].value;
	document.getElementById("pageSizeHidden").value = selectedValue;
}

function isGoAhead1(){
	document.getElementById("isGoAheadHidden").value='true';
	return false;
}

function isGoBack(){
	document.getElementById("isGoBackHidden").value='true';
	return false;
}

</script>
<body>
<s:form id="form1" name="form1" method="get" action="queryMemberAction" accept-charset='utf-8'>
	<h1>会员信息检索</h1>
	<hr>
	<div style="margin:0px auto; margin-top:60px;height: 70px; width:550px; border:#33FF33 solid 1px;">
		<div>
			<input type="radio" name="queryMemberCondition" value="byName" onclick="showName();" style="margin-top: 10px;" />按姓名查询
			<input type="radio" name="queryMemberCondition" value="byTel" onclick="showTel();" />按手机号查询
			<input type="radio" name="queryMemberCondition" value="byCardId" onclick="showCardId();" />按会员卡号查询
			<input type="radio" name="queryMemberCondition" value="all" onclick="hiddenAll();" />查询所有
			<input type="submit" value="查询"></input>
		</div>
		<div id="name" style="display:none">
			<label style="margin-left: 20px;">姓名：</label>
			<input id="nameInput" type="text" name="member.name" value="${member.name}"  size="40" />
		</div>
		<div id="tel" style="display:none">
			<label style="margin-left: 20px;">手机号：</label>
			<input id="telInput" type="text" name="member.phone" value="${member.phone}"  size="40" />
		</div>	
		<div id="cardId" style="display:none">
			<label style="margin-left: 20px;">会员卡号：</label>
			<input id="cardIdInput" type="text" name="member.mrCardId" value="${member.mrCardId}"  size="40" />
		</div>
	</div>
	
	<table style="margin:0px auto; margin-top:60px; width:1000px;">
		<tr style="background:#3388FF; "><td>会员卡号</td> <td>姓名</td> <td>手机号</td> <td>性别</td> <td>皮肤类型</td> <td>出生日期</td> <td>删除</td><td>详情</td></tr>
		<s:iterator value="memberList">
			<tr>
				<td><label>${mrCardId}</label></td>
				<td><label>${name}</label></td>
				<td><label>${phone}</label></td>
				<td><label>${sex}</label></td>
				<td><label>${skinType}</label></td>
				<td><label>${birthday}</label></td>
				<td>
					<a href="<%=context %>/deleteMember.action?mrCardId=${mrCardId}" onclick="javascript:return confirm('确定要删除吗？');">删除</a>
				</td>
				<td>
					 <a href="<%=context %>/initShopPageAction.action?mrCardId=${mrCardId}">详情</a> 
				</td>
			</tr>
		</s:iterator>
		<%-- <tr><td style="text-align:left;"><label>${result}</label></td></tr> --%>
	</table>
	<br>

	<div style="text-align:right; margin-right:30px;">
		<label>共${member.objCount}条记录/</label>
		<label>共${member.pageCount}页/</label>
		<label>每页显示${member.pageSize}行</label>
		<%-- <select id="pageSize" onchange="setPageSize()">
			<option value="1" <%if(pageSize == 1) {%> selected="selected" <%} %>>1</option>
			<option value="2" <%if(pageSize == 2) {%> selected="selected" <%} %>>2</option>
			<option value="3" <%if(pageSize == 3) {%> selected="selected" <%} %>>3</option>
			<option value="100" <%if(pageSize == 100) {%> selected="selected" <%} %>>100</option>
		</select> --%> 
		<label>/当前第${member.pageIndex}页</label> &nbsp; &nbsp;
		
		<a <%if(!isFirstPage){%> href="<%=context %>/queryMemberActionForPagination.action?goBack=true" <%}%> >上一页</a>&nbsp;
		<a <%if(!isLastPage){%> href="<%=context %>/queryMemberActionForPagination.action?goAhead=true" <%}%> >下一页</a>
		<!-- <input type="id="mrCardId"id="mrCardId"id="mrCardId"id="mrCardId"" id="pageSizeHidden" name="member.pageSize" /> -->
		<input type="hidden" id="isGoAheadHidden" name="goAhead" />
		<input type="hidden" id="isGoBackHidden" name="goBack" />
	</div>
	
</s:form>
</body>
</html>