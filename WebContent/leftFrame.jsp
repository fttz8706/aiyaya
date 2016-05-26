<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String contex = request.getContextPath();
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form id="form1" style="background-color: #93BEFF">
		<div >
			<ul>
				<br>
				<li>
					<a target="mainFrame">会员管理</a>
					<br>
					<br>
					<ul>
						<li>
							<a href="member/addmember.jsp" target="mainFrame">添加会员</a>
						</li>
							<br>
						<li>
							<a href="<%=contex %>/initMemberQueryPage.action" target="mainFrame">会员查询</a>
						</li>
					</ul>
				</li>
				<br>
				<br>
				<li>
					<a target="mainFrame">购买记录</a>
				</li>
				<br>
				<br>
				<li>
					<a target="mainFrame" >商品管理</a>
					<br>
					<br>
					<ul>
						<li>
							<a href="ware/addware.jsp" target="mainFrame" >添加商品</a>
						</li>
						<br>	
						<li>
							<a href="ware/queryware.jsp" target="mainFrame">商品查询</a>
						</li>
					</ul>
				</li>
				<br>
				<br>
				<li>
					<a target="mainFrame">积分管理</a>
				</li>
				<br>
				<br>
				<li>
					<a target="mainFrame">密码管理</a>
				</li>
			</ul>
		</div>
	</form>
</body>
</html>