<%@page import="pack.HeaderBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>10_4</title>
</head>
<body>
<jsp:useBean id="headerBean" class="pack.HeaderBean" scope="application"/>
<%
	Enumeration<String> headerNames = request.getHeaderNames();
	while(headerNames.hasMoreElements()){
		String name = (String)headerNames.nextElement();
		String cname = name.substring(0,1).toUpperCase()+name.substring(1);
%>
	<jsp:setProperty name="headerBean" property="headerName" value='<%=cname %>'/>	
	<jsp:setProperty name="headerBean" property="header" value='<%=request.getHeader(name) %>'/>
<%
	}
%>
<table border="1">
	<jsp:getProperty property="headerTable" name="headerBean"/>
</table>

</body>
</html>