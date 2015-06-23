package pack;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EX10")
public class EX10 extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HeaderBean hb = new HeaderBean();
		
		ServletContext application = getServletContext();
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String name = (String) headerNames.nextElement();
			String cname = name.substring(0, 1).toUpperCase()
					+ name.substring(1);
			
			hb.setHeaderName(cname);
			hb.setHeader(request.getHeader(name));
		}
		
		application.setAttribute("HB", hb);
		
	
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("Exercise/Ex10_6_2.jsp");
		dispatcher.forward(request, response);
	}

}
