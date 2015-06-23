<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib tagdir="/WEB-INF/tags" prefix="myjsp" %>
	
	<h1>Random number (between 0 to 1)</h1>
	<myjsp:Ex10_7_2/>
	
	<h1>Random number (between 0 to LIMIT)</h1>
	<myjsp:Ex10_7_2_limit limit="5"/>
	<br>
	
</body>
</html>