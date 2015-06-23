package com.exercise9_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");

		PrintWriter out = response.getWriter();
		// 응답
		String fname;
		String lname;
		String mail;
		String phone;

		fname = request.getParameter("fname");
		lname = request.getParameter("lname");
		mail = request.getParameter("mail");
		phone = request.getParameter("phone");

		// /요청
		out.println("<h1>Registration</h1>");

		out.println("<form method='get'>");
		if (fname == null || fname.equals("")) {
			out.println("First name: <input type='text' name='fname'><font color='red'>Enter the first name</font><br>");
		} else{
			out.println("First name: <input type='text' name='fname' value='" + fname
				+ "'><br>");
		}

		if (lname == null || lname.equals("")) {
			out.println("Last name: <input type='text' name='lname'><font color='red'>Enter the last name</font><br>");
		} else{
			out.println("Last name: <input type='text' name='lname' value='" + lname
				+ "'><br>");
		}		
		
		if (mail == null || mail.equals("")) {
			out.println("E-mail : <input type='text' name='mail'><font color='red'>Enter the e-mail</font><br>");
		} else{
			out.println("E-mail : <input type='text' name='mail' value='" + mail
				+ "'><br>");
		}
		
		if (phone == null || phone.equals("")) {
			out.println("Phone number: <input type='text' name='phone'><font color='red'>Enter the phone number</font><br>");
		} else{
			out.println("Phone number: <input type='text' name='phone' value='" + phone
				+ "'><br>");
		}
		
		out.println("<input type='submit' value='Register'>");
		out.println("</form>");

	}

}
