package com.controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TMModel_Main_MB;
import com.vo.Eat;
import com.vo.Play;
import com.vo.Sleep;

public class TMController_Main_MB {
	TMModel_Main_MB model;

	public TMController_Main_MB() {
		model = new TMModel_Main_MB();
	}

	public void mainAll(HttpServletRequest req, HttpServletResponse res) {

		/*// 정보글에대한 데이터
		ArrayList<Play> p_list = model.play_selectAll();
		ArrayList<Eat> e_list = model.eat_selectAll();
		ArrayList<Sleep> s_list = model.sleep_selectAll();

		req.setAttribute("p_list", p_list);
		req.setAttribute("e_list", e_list);
		req.setAttribute("s_list", s_list);
*/
		// forward 방식으로 jsp 화면으로 넘어간다.
		RequestDispatcher dis = req.getRequestDispatcher("/form/main_form.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mainContents(HttpServletRequest req, HttpServletResponse res) {
		// 정보글에대한 데이터
		ArrayList<Play> p_list = model.play_selectAll();
		ArrayList<Eat> e_list = model.eat_selectAll();
		ArrayList<Sleep> s_list = model.sleep_selectAll();

		req.setAttribute("p_list", p_list);
		req.setAttribute("e_list", e_list);
		req.setAttribute("s_list", s_list);

		RequestDispatcher dis = req.getRequestDispatcher("/form/main_contents.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
