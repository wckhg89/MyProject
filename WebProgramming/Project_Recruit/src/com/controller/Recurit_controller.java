package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.vo.Data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
@WebServlet("/Recurit_controller")
public class Recurit_controller extends HttpServlet {
	public String parsing_info() {
		String data = null;
		Document doc;
		try {
			doc = Jsoup.connect(
					"http://kr.tmaxsoft.com/recruit/recruitNotice.do").get();

			Elements recurit = doc.select(".tbl-list");

			for (Element e : recurit) {
				data = e.text();
			}
			System.out.println("∆ƒΩÃµ•¿Ã≈Õ: " + data);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return data;
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String recruit_data;
		recruit_data = parsing_info();
		Data d = new Data(recruit_data);
		
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("form/test.jsp");
		req.setAttribute("web",d);
		
		try {
			dispatcher.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
