package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TMModel_Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.vo.Band;
import com.vo.Eat;
import com.vo.Friend;
import com.vo.Member;
import com.vo.Play;
import com.vo.Sleep;

public class TMController_Member {

	TMModel_Member model;

	public TMController_Member() {
		model = new TMModel_Member();
	}

	public void login(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dis = req.getRequestDispatcher("form/login.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void join(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dis = req.getRequestDispatcher("form/join.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void joinProcess(HttpServletRequest req, HttpServletResponse res) {
		String uploadPath = req.getRealPath("files"); // 실제 시스템 상의 경로를 얻어온다.
		int size = 1024 * 1024 * 1024; // 업로드 파일의 최대 크기 지정
		String filename1 = "";
		
		try {
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
			MultipartRequest multi = new MultipartRequest(req, uploadPath,
					size, "euc-kr", policy);
			Enumeration files = multi.getFileNames();
			
			String file1 = (String) files.nextElement();
			filename1 = multi.getFilesystemName(file1);
			
			String m_id = multi.getParameter("m_id");
			String m_pass = multi.getParameter("m_pass1");
			String m_name = multi.getParameter("m_name");
			int m_age = Integer.parseInt(multi.getParameter("m_age"));
			int m_phone = Integer.parseInt(multi.getParameter("m_phone"));
			String m_email = multi.getParameter("m_email");
			String m_img = filename1;
			
			System.out.println(m_img);
			// String m_pass = controller.getEncSHA256(m_pass1);
			Member m = new Member(m_id, m_pass, m_name, m_age, m_phone, m_email, m_img);
			boolean isJoin = model.m_join(m);

			if (isJoin == true) {
				RequestDispatcher dis = req
						.getRequestDispatcher("form/joinSuccess.jsp");
				try {
					dis.forward(req, res);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("실패");
			}

		} catch (Exception e) {
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
	public void memberDetail(HttpServletRequest req, HttpServletResponse res) {
		String m_id = req.getParameter("m_id").toString();
		
		Member m = model.memberDetail(m_id);
		ArrayList<Friend> fl = model.friendList(m_id);
		
		ArrayList<Play> pl = model.PlayList(m_id);
		ArrayList<Eat> el = model.EatList(m_id);
		ArrayList<Sleep> sl = model.SleepList(m_id);
		
		ArrayList<Band> bl = model.BandList(m_id);
		
		
		System.out.println(m.getM_img()+"@@$");
		
		req.setAttribute("memberData", m);
		req.setAttribute("friendList", fl);
		
		req.setAttribute("playList", pl);
		req.setAttribute("eatList", el);
		req.setAttribute("sleepList", sl);
		req.setAttribute("bandList", bl);
		
		RequestDispatcher dis = req
				.getRequestDispatcher("/form/memberDetail.jsp");//

		try {
			dis.forward(req, res);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
	
	
	public void meetFriend(HttpServletRequest req, HttpServletResponse res) {
		
		String m_id = req.getSession().getAttribute("login").toString();
		String f_id = req.getParameter("f_id").toString();
		
		System.out.println(m_id + "MMMM" + f_id);
		boolean isLogin = model.meetFriend(m_id,f_id);

		if (isLogin == true) {

			RequestDispatcher dis = req
					.getRequestDispatcher("/form/loginProcess.jsp");//

			try {
				dis.forward(req, res);
			} catch (Exception e) {
				
				e.printStackTrace();
			} 

		} else {
			try {
				res.sendRedirect("loginFail.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
