package com.exercise9_3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchEngine")
public class SearchEngine extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();

		out.println("<h1 >Search Fornt-end</h1>");
		out.println("<p >Choose a search engine and enter query keyword</p>");

		out.println("<form method='GET'>");
		out.println("<select name='select'>");
		out.println("<option value='naver'>Naver</option>");
		out.println("<option value='daum'>Daum</option>");
		out.println("<option value='google'>Google</option>");
		out.println("<option value='yahoo'>Yahoo</option>");
		out.println("<option value='bing'>Bing</option>");
		out.println("</select>");
		out.println("<input type='text' name='query'>");
		out.println("<input type='submit' value='Search'>");
		out.println("</form>");

		String engine = request.getParameter("select");
		String query = request.getParameter("query");

		if (engine != null) {
			if (engine.equals("naver")) {
				response.sendRedirect("http://search.naver.com/search.naver?query="
						+ query);
			} else if (engine.equals("daum")) {
				response.sendRedirect("http://search.daum.net/" + query);
			} else if (engine.equals("google")) {
				response.sendRedirect("http://www.google.com/search?q=" + query);
			} else if (engine.equals("yahoo")) {
				response.sendRedirect("http://search.yahoo.com/bin/search?p="
						+ query);
			} else if (engine.equals("bing")) {
				response.sendRedirect("http://www.bing.com/search?q=" + query);
			}
		}
	}
}
