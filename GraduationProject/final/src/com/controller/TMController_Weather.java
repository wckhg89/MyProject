package com.controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TMModel_Weather;
import com.vo.Weather;

@WebServlet("/WeatherController")
public class TMController_Weather {
	TMModel_Weather model;
	
	public TMController_Weather() {
		model = new TMModel_Weather();
	}
	
	public void weatherState(HttpServletRequest req, HttpServletResponse res) {
		
		ArrayList<Weather> w_d_list = model.parse_wearher();
		
		req.setAttribute("w_d_list", w_d_list);
		RequestDispatcher dis = req.getRequestDispatcher("form/weather.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void ajax(HttpServletRequest req, HttpServletResponse res){
		RequestDispatcher dis = req.getRequestDispatcher("form/weather_ajax.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
