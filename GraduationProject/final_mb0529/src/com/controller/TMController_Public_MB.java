package com.controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TMModel_Public_MB;
import com.vo.Public_eat;
import com.vo.Public_play;
import com.vo.Public_sleep;

public class TMController_Public_MB {
	TMModel_Public_MB model;

	public TMController_Public_MB() {
		model = new TMModel_Public_MB();
	}
	
	public void writePlay(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getSession().getAttribute("login").toString();
		
	}
	
	/*
	 * 글작성 관련 메소드 
	 * 
	 */
	
	public void Write(HttpServletRequest req, HttpServletResponse res) {
		String subject = req.getParameter("subject");
		String contents = req.getParameter("contents");
		String textarea = req.getParameter("textarea");
		
		System.out.println(subject  +" "+ contents + "" + textarea);
		//model.m_pwritePlay(subject , contents , textarea);
		RequestDispatcher dis = req.getRequestDispatcher("/form/write_form.jsp");//

		try {
			dis.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 글 추천 관련 메소드 
	 */
	public void Recommend(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dis = req.getRequestDispatcher("/form/recommend.jsp");//

		try {
			dis.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * <<공공 데이터와 관련된 메소드>>
	 * 
	 */
	public void publicContents(HttpServletRequest req, HttpServletResponse res) {
		// 공공 정보글에대한 데이터
		System.out.println("hi");
		ArrayList<Public_play> mem_PPlay = model.play_selectAll();
		ArrayList<Public_eat> mem_PEat = model.eat_selectAll();
		ArrayList<Public_sleep> mem_PSleep = model.sleep_selectAll();

		req.setAttribute("pp_list", mem_PPlay);
		req.setAttribute("pe_list", mem_PEat);
		req.setAttribute("ps_list", mem_PSleep);

		RequestDispatcher dis = req.getRequestDispatcher("/form/recommend.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
