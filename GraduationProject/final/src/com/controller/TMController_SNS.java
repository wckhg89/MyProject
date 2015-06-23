package com.controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TMModel_Main;
import com.vo.Play;

public class TMController_SNS {
	
	TMModel_Main model;
	
	public TMController_SNS() {
		model = new TMModel_Main();
	}
	
	public void SNS_Play(HttpServletRequest req, HttpServletResponse res){
		ArrayList<Play> p_list = model.play_selectAll();
		
		req.setAttribute("p_list", p_list);
		
		RequestDispatcher dis = req.getRequestDispatcher("/form/play_sns_content.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
