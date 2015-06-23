package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StateLookup;
import com.vo.StatePair;

@WebServlet("/ShowState")
public class ShowState extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated constructor stub

		String stateName = req.getParameter("state_name");
		StateLookup service = new StateLookup();
		StatePair state = service.findState(stateName);
		req.setAttribute("state", state);
		if (state != null) {
			RequestDispatcher dispatcher = req
					.getRequestDispatcher("STATE_WEB/state_info.jsp");
			try {
				dispatcher.forward(req, res);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(stateName == null){
			RequestDispatcher dispatcher = req
					.getRequestDispatcher("STATE_WEB/no_enter.jsp");
			try {
				dispatcher.forward(req, res);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			RequestDispatcher dispatcher = req
					.getRequestDispatcher("STATE_WEB/not_found.jsp");
			try {
				dispatcher.forward(req, res);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
