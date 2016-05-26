<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%String username = (String)session.getAttribute("username"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>哎呀呀后台管理系统</title>
</head>
<frameset rows="800px,*">
  <frameset cols="200px,*">
    <frame src="leftFrame.jsp" name="leftFrame" noresize="noresize" id="leftFrame" title="leftFrame" border="1px"/>
    <frame name="mainFrame" id="mainFrame" title="mainFrame" />
  </frameset>
</frameset>
<body>
<!-- <h1>login success!</h1><br><s:label>welcome come back, <%=username %> !</s:label> -->


</body>
</html>