<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.zip.GZIPOutputStream" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%! PrintWriter out2; %>
<%

	out2=null;
	Enumeration<String> headerNames= request.getHeaderNames();
	while(headerNames.hasMoreElements()) { 
		String name=(String)headerNames.nextElement(); 
		String cname= name.substring(0,1).toUpperCase() + name.substring(1);
		String encodings= request.getHeader(name);
		
		boolean gzipSupported= (encodings!= null) && (encodings.contains("gzip"));
		String flag= request.getParameter("disableGzip");
		boolean gzipDisabled= (flag!= null) && (!flag.equalsIgnoreCase("false"));
		if(gzipSupported && !gzipDisabled) {
			out2 = new PrintWriter(new GZIPOutputStream(response.getOutputStream()), false);
			response.setHeader("Content-Encoding", "gzip");
		}
		else{
			out2 = response.getWriter();
		}	
	} 
%>
</body>
</html>