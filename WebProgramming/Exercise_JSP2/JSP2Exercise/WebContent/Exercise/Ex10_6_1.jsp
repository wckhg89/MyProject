<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String fname = "";
		String lname = "";
		String mail = "";
		String phone = "";

		fname = request.getParameter("fname");
		lname = request.getParameter("lname");
		mail = request.getParameter("mail");
		phone = request.getParameter("phone");
	%>

	<%if(fname == null || fname.equals("") 
		&& lname == null || lname.equals("")
		&& mail == null || mail.equals("")
		&& phone == null || phone.equals("")){
	%>
	<form method="get" action="Ex10_6_1.jsp">
		<% if (fname == null || fname.equals("")) {%>
			First name: <input type='text' name='fname'><font color='red'>Enter the first name</font><br>
		<% } else{%>
			First name: <input type='text' name='fname' value='<%=fname %>'><br>
		<% }%>
		
		<% if (lname == null || lname.equals("")) {%>
			Last name: <input type='text' name='lname'><font color='red'>Enter the last name</font><br>
		<% } else{%>
			Last name: <input type='text' name='lname' value='<%=lname %>'><br>
		<% }%>
		
		<% if (mail == null || mail.equals("")) {%>
			E-mail: <input type='text' name='mail'><font color='red'>Enter the E-mail</font><br>
		<% } else{%>
			E-mail: <input type='text' name='mail' value='<%=mail %>'><br>
		<% }%>
		
		<% if (phone == null || phone.equals("")) {%>
			Phone number: <input type='text' name='phone'><font color='red'>Enter the phone number</font><br>
		<% } else{%>
			Phone number: <input type='text' name='phone' value='<%=phone %>'><br>
		<% }%>

		<input type="submit" value="Register">

	</form>
	<% }else{%>
	 
		${param.fname }<br>
		${param.lname }<br>
		${param.mail }<br>
		${param.phone }<br>
		
	<%} %>
</body>
</html>