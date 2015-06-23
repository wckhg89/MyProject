package com.controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TMModel_Content_MB;
import com.vo.Eat;
import com.vo.Play;
import com.vo.Play_Rply;
import com.vo.Sleep;

public class TMController_Content_MB {
	TMModel_Content_MB model;

	public TMController_Content_MB() {
		model = new TMModel_Content_MB();
	}
	
	
	public void writePlay(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getSession().getAttribute("login").toString();
		
	}
	
	public void enterLike(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getSession().getAttribute("login").toString();
		int p_num = Integer.parseInt(req.getParameter("p_num"));
		
		boolean isComplete = model.enterLike(id, p_num);
		
		if(isComplete == true){
			this.detailContent(req, res);
		}else{
			System.out.println("Error!");
		}
	}
	
	public void enterReply(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getSession().getAttribute("login").toString();
		int p_num = Integer.parseInt(req.getParameter("p_num"));
		String content_Rply = req.getParameter("content_Rply");
		
		boolean isComplete = model.enterReply(id, p_num, content_Rply);
		
		if(isComplete == true){
			this.detailContent(req, res);
		}else{
			System.out.println("Error!");
		}
		
	}
	public void detailContent(HttpServletRequest req, HttpServletResponse res) {
		// 상세글 보기
		Play play_Bean = null;
		
		ArrayList<Play_Rply> play_R_List;
		
		Eat eat_Bean = null;
		Sleep sleep_Bean = null;

		String p_num = req.getParameter("p_num");
		String e_num = req.getParameter("e_num");
		String s_num = req.getParameter("s_num");

		if (p_num != null) {
			/*
			 * 만일 관광지 데이터이면,
			 * 관광지 상세페이지로 포워딩한다.
			 */
			play_Bean = model.detailPlay(Integer.parseInt(p_num));
			play_R_List = model.replyPlay(Integer.parseInt(p_num));
			req.setAttribute("play_Bean", play_Bean);
			req.setAttribute("play_R_List", play_R_List);
			
			RequestDispatcher dis = req
					.getRequestDispatcher("/form/detail_content.jsp?category=p");
			try {
				dis.forward(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (e_num != null) {
			/*
			 * 만일 먹거리 데이터이면,
			 * 먹거리 상세페이지로 포워딩한다.
			 */
			eat_Bean = model.detailEat(Integer.parseInt(e_num));

			req.setAttribute("eat_Bean", eat_Bean);
			
			RequestDispatcher dis = req
					.getRequestDispatcher("/form/detail_content.jsp?category=e");
			try {
				dis.forward(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (s_num != null) {
			/*
			 * 만일 잠자리 데이터이면,
			 * 잠자리 상세페이지로 포워딩한다.
			 */
			sleep_Bean = model.detailSleep(Integer.parseInt(s_num));

			req.setAttribute("sleep_Bean", sleep_Bean);
			
			RequestDispatcher dis = req
					.getRequestDispatcher("/form/detail_content.jsp?category=s");
			try {
				dis.forward(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}// Band
			
	}
}
