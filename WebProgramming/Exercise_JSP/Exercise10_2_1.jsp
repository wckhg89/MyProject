<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	Enumeration<String> headerNames= request.getHeaderNames();
	while(headerNames.hasMoreElements()) { 
		String name=(String)headerNames.nextElement(); 
		String cname= name.substring(0,1).toUpperCase() + name.substring(1);
	%>
	<font color="red"> 
	<%= cname %>
	</font>
	<%=request.getHeader(name) %><br>
<%} %>
</body>
</html>