package com.exercise9_2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();

		String encodings = request.getHeader("User-agent");
		out.println(encodings);
		
		if(encodings.contains("11.0")){
			out.println("<body text='red' bgcolor='yellow'>");
			out.println("<h1>Hello!<h1>");
			out.println("</body>");
		}else{
			out.println("<body text='white' bgcolor='navy'>");
			out.println("<h1>Hello!<h1>");
			out.println("</body>");
		}
	}
}
