<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Servlet路径跳转</h1>
	<hr>
	<!-- 使用相对路径访问HelloServlet -->
	<!-- /servlet/HelloServlet 第一个/表示服务器的根目录 -->
	<a href = "servlet/HelloServlet">访问HelloServlet!</a><br>
	<hr>
	
	<!-- 使用绝对路径访问HelloServlet,可以使用path变量 path变量表示项目的根目录 -->
	<a href = "<%=path %>/servlet/HelloServlet">访问HelloServlet!</a><br>
	<hr>
</body>
</html>