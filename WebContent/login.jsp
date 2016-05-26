<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登录页面</title>
</head>
<body>
<s:form name='form1' id='form1' method='post' action='loginAction'>
	<s:textfield name="userInfo.username" label="用户名"></s:textfield>
	<s:password name="userInfo.password" label="密    码"></s:password>
	<s:submit value="提交"></s:submit>
</s:form>
</body>
</html>