<%@ tag language="java" pageEncoding="EUC-KR"%>
<%@ attribute name="limit" required="false" %>
<%@ tag import="java.lang.*"%>

<%
	int number;
	int limit2 =0;
	try {
		limit2 = Integer.parseInt(limit);
	} catch(NumberFormatException e) {}

	number = (int)(1+Math.random() * limit2);
%>
<%=number %>




