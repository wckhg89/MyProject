<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%! private int accessCount = 0; %>
	<%
		Date previousDate = null;
		String previousHost = "<i>no prevoius host</i>";
	%>
	
	<%
		accessCount++;
		previousDate = new Date();
		previousHost = request.getRemoteHost();
	%>
</body>
</html>