package com.controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TMModel_Search;
import com.vo.Eat;
import com.vo.Play;
import com.vo.Sleep;

public class TMController_Search {
	TMModel_Search model;

	public TMController_Search() {
		model = new TMModel_Search();
	}

	public void selectContents(HttpServletRequest req, HttpServletResponse res) {
		// 정보글에대한 데이터
		ArrayList<Play> p_list = model.play_selectAll();
		ArrayList<Eat> e_list = model.eat_selectAll();
		ArrayList<Sleep> s_list = model.sleep_selectAll();

		req.setAttribute("p_list", p_list);
		req.setAttribute("e_list", e_list);
		req.setAttribute("s_list", s_list);

		RequestDispatcher dis = req
				.getRequestDispatcher("/form/search_page_ajax.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchContents(HttpServletRequest req, HttpServletResponse res) {
		// 정보글에대한 데이터
		ArrayList<Play> p_list = model.play_selectAll();
		ArrayList<Eat> e_list = model.eat_selectAll();
		ArrayList<Sleep> s_list = model.sleep_selectAll();

		req.setAttribute("p_list", p_list);
		req.setAttribute("e_list", e_list);
		req.setAttribute("s_list", s_list);

		RequestDispatcher dis = req
				.getRequestDispatcher("/form/search_contents.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchNewContents(HttpServletRequest req,
			HttpServletResponse res) {
		// 정보글에대한 데이터
		ArrayList<Play> p_list = model.play_New_selectAll();
		ArrayList<Eat> e_list = model.eat_New_selectAll();
		ArrayList<Sleep> s_list = model.sleep_New_selectAll();

		req.setAttribute("p_list", p_list);
		req.setAttribute("e_list", e_list);
		req.setAttribute("s_list", s_list);

		RequestDispatcher dis = req
				.getRequestDispatcher("/form/search_contents.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void searchLikeContents(HttpServletRequest req,
			HttpServletResponse res) {
		// 정보글에대한 데이터
		ArrayList<Play> p_list = model.play_Like_selectAll();
		ArrayList<Eat> e_list = model.eat_Like_selectAll();
		ArrayList<Sleep> s_list = model.sleep_Like_selectAll();

		req.setAttribute("p_list", p_list);
		req.setAttribute("e_list", e_list);
		req.setAttribute("s_list", s_list);

		RequestDispatcher dis = req
				.getRequestDispatcher("/form/search_contents.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void searchDateContents(HttpServletRequest req,
			HttpServletResponse res) {
		// 정보글에대한 데이터
		ArrayList<Play> p_list = model.play_Date_selectAll(req.getParameter("s_when"));
		ArrayList<Eat> e_list = model.eat_Date_selectAll(req.getParameter("s_when"));
		ArrayList<Sleep> s_list = model.sleep_Date_selectAll(req.getParameter("s_when"));
		
		System.out.println(req.getParameter("s_when")+"!!!!!");
		System.out.println(req.getParameter("ctg"));
		req.setAttribute("p_list", p_list);
		req.setAttribute("e_list", e_list);
		req.setAttribute("s_list", s_list);

		RequestDispatcher dis = req
				.getRequestDispatcher("/form/search_contents.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
