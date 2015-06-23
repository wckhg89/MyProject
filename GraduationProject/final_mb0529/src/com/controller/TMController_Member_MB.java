package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TMModel_Member_MB;
import com.dao.TMModel_Public_MB;
import com.vo.Eat;
import com.vo.Member;
import com.vo.Play;
import com.vo.Sleep;

public class TMController_Member_MB {
	TMModel_Member_MB model;

	public TMController_Member_MB() {
		model = new TMModel_Member_MB();
	}
	
	/*
	 * <<로그인에 관련된 메소드>>
	 * Login , loginProcess, loginFail 
	 */

	public void Login(HttpServletRequest req, HttpServletResponse res) {

		// forward 방식으로 jsp 화면으로 넘어간다.
		RequestDispatcher dis = req
				.getRequestDispatcher("/form/login_form.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loginProcess(HttpServletRequest req, HttpServletResponse res) {
		try {
			String id = req.getParameter("id");
			String pass = req.getParameter("pass");
			// String pass = controller.getEncSHA256(hash_pass);

			boolean isLogin = model.m_login(id, pass);

			if (isLogin == true) {

				RequestDispatcher dis = req
						.getRequestDispatcher("/form/loginProcess.jsp");//

				dis.forward(req, res);

			} else {
				try {
					res.sendRedirect("loginFail.do");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void loginFail(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dis = req.getRequestDispatcher("/form/loginFail.jsp");//

		try {
			dis.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 회원가입 관련 메소드 
	 * 
	 */
	public void Join(HttpServletRequest req, HttpServletResponse res) {
		String id       = req.getParameter("userid");
		String password = req.getParameter("pw");
		String name     = req.getParameter("name");
		String age      = req.getParameter("age");
		
		System.out.println(id);
		model.m_join(id, password, name , age);
		RequestDispatcher dis = req
				.getRequestDispatcher("/form/join_form.jsp");
		
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/*
	 * <<회원 정보와 관련된 메소드>>
	 */
	public void memberInfo(HttpServletRequest req, HttpServletResponse res) {
		//회원 기본정도 데이터

		String id = req.getSession().getAttribute("login").toString();

		Member mem_Data= model.memberData(id);

		//회원이 작성한 글 데이터
		ArrayList<Play> mem_Play = model.memberPlay(id);
		ArrayList<Eat> mem_Eat = model.memberEat(id);
		ArrayList<Sleep> mem_Sleep = model.memberSleep(id);

		/*ArrayList<Band> mem_Band;*/
		// forward 방식으로 jsp 화면으로 넘어간다.
		req.setAttribute("mem_Data", mem_Data);

		req.setAttribute("mem_Play", mem_Play);
		req.setAttribute("mem_Eat", mem_Eat);
		req.setAttribute("mem_Sleep", mem_Sleep);
		req.setAttribute("mem_Band", mem_Sleep);

		RequestDispatcher dis = req
				.getRequestDispatcher("/form/member_info.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
