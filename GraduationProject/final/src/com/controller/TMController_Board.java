package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TMModel_Board;
import com.vo.Notice;
import com.vo.NoticeReply;

public class TMController_Board {
	ArrayList<Notice> n_list;
	TMModel_Board model;

	public TMController_Board() {
		model = new TMModel_Board();
	}

	public void noticeAll(HttpServletRequest req, HttpServletResponse res) {
		ArrayList<Notice> n_list = model.n_selectAll();
		req.setAttribute("n_list", n_list);// data 저장

		// forward 방식으로 jsp 화면으로 넘어간다.
		RequestDispatcher dis = req.getRequestDispatcher("/form/board.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void noticeInsert(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dis = req.getRequestDispatcher("form/boardNew.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void noticeInsertProcess(HttpServletRequest req,
			HttpServletResponse res) {
		System.out.println("!!");
		HttpSession session = req.getSession();
		if (session.getAttribute("login") != null) {
			String n_id = (String) session.getAttribute("login");
			if (n_id.equals("TravelMaker")) {
				String n_title = req.getParameter("title");
				String n_content = req.getParameter("content");
				String count = "0";

				Notice n = new Notice(n_title, n_content);
				model.n_insert(n);

				RequestDispatcher dis = req
						.getRequestDispatcher("/form/boardSuccess.jsp");
				try {
					dis.forward(req, res);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					res.sendRedirect("adminLoginFail.do");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				res.sendRedirect("loginFail.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void noticeDetail(HttpServletRequest req, HttpServletResponse res) {
		int n_num = Integer.parseInt(req.getParameter("n_num"));
		ArrayList n_list = model.n_selectOne(n_num);// //
		Notice tn = (Notice) n_list.get(0);

		req.setAttribute("tn", tn);

		// 댓글만!!
		ArrayList<NoticeReply> n_re = new ArrayList<NoticeReply>();

		for (int i = 0; i < n_list.size() - 1; i++) {
			n_re.add((NoticeReply) n_list.get(i + 1));
		}

		req.setAttribute("n_re", n_re);
		RequestDispatcher dis = req
				.getRequestDispatcher("/form/boardDetail.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void noticeModify(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("controller n_modify");
		HttpSession session = req.getSession();

		if (session.getAttribute("login") != null) {
			String id = (String) session.getAttribute("login");

			if (id.equals("TravelMaker")) {
				int n_num = Integer.parseInt(req.getParameter("n_num"));
				ArrayList n_list = model.n_selectOne(n_num);
				Notice tn = (Notice) n_list.get(0);
				req.setAttribute("tn", tn);

				RequestDispatcher dis = req
						.getRequestDispatcher("/form/boardModify.jsp");

				try {
					dis.forward(req, res);
					System.out.println("controller finish");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					res.sendRedirect("adminLoginFail.do");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				res.sendRedirect("loginFail.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void noticeModifyProcess(HttpServletRequest req,
			HttpServletResponse res) {
		System.out.println("Controller n_modifyProcess");

		int n_num = Integer.parseInt(req.getParameter("n_num"));
		String n_title = req.getParameter("title");
		String n_content = req.getParameter("content");

		ArrayList n_list = model.n_selectOne(n_num);

		Notice tn = (Notice) n_list.get(0);
		tn.setN_title(n_title);
		tn.setN_content(n_content);

		req.setAttribute("tn", tn);
		model.n_update(((Notice) n_list.get(0)));

		System.out.println("success");

		RequestDispatcher dis = req
				.getRequestDispatcher("/form/boardDetail.jsp");

		try {
			dis.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void n_delete(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String sessionId = (String) session.getAttribute("login");

		if (session.getAttribute("login") != null) {
			int n_num = Integer.parseInt(req.getParameter("n_num"));

			if (sessionId.equals("TravelMaker")) {
				model.b_delete(n_num);

				RequestDispatcher dis = req
						.getRequestDispatcher("/form/n_deleteSuccess.jsp");
				try {
					dis.forward(req, res);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				RequestDispatcher dis = req
						.getRequestDispatcher("/form/n_deleteFailed.jsp");
				try {
					dis.forward(req, res);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				res.sendRedirect("loginFail.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void n_r_insertProcess(HttpServletRequest req,
			HttpServletResponse res) {
		HttpSession session = req.getSession();

		if (session.getAttribute("login") != null) {
			String r_id = (String) session.getAttribute("login"); // loginProcess.jsp에서
			// session에
			// login으로
			// set한
			// 값을 받아온다.
			int r_num = Integer.parseInt(req.getParameter("r_num")); // boardDetail에서
			// r_num이라는
			// 이름으로
			// set한
			// seeeion값을
			// 받아온다.
			String r_contents = req.getParameter("inputcom");

			System.out.println(r_id + r_num + r_contents + "reply Accept!!!!@");

			NoticeReply nr = new NoticeReply(r_num, r_id, r_contents);
			model.r_add(nr);

			ArrayList rlist = model.n_selectOne(r_num);
			Notice tn = (Notice) rlist.get(0);
			req.setAttribute("tn", tn);

			ArrayList<NoticeReply> n_re = new ArrayList<NoticeReply>();
			for (int i = 0; i < rlist.size() - 1; i++) {
				n_re.add((NoticeReply) rlist.get(i + 1));
				System.out.println(n_re.get(i).getTn_content());
			}
			req.setAttribute("n_re", n_re);
			RequestDispatcher dis = req
					.getRequestDispatcher("/form/boardDetail.jsp");
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

	public void r_delete(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String r_idx = req.getParameter("r_idx");// 인테스(pk) 가져오기
		int r_num = Integer.parseInt(req.getParameter("r_num"));
		String id = req.getParameter("r_id");

		if (session.getAttribute("login") != null) {
			String sessionId = (String) session.getAttribute("login");
			if (id.equals(sessionId)) {
				System.out.println(r_idx + " 딜리트수행중  " + r_num);
				model.r_delete(r_idx, r_num);

				ArrayList n_list = model.n_selectOne(r_num);
				Notice tn = (Notice) n_list.get(0);
				req.setAttribute("tn", tn);

				ArrayList<NoticeReply> n_re = new ArrayList<NoticeReply>();

				for (int i = 0; i < n_list.size() - 1; i++) {
					n_re.add((NoticeReply) n_list.get(i + 1));
				}

				req.setAttribute("n_re", n_re);
				RequestDispatcher dis = req
						.getRequestDispatcher("/form/boardDetail.jsp");
				try {
					dis.forward(req, res);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					res.sendRedirect("nr_deleteFail.do");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				res.sendRedirect("loginFail.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void noticeSearch(HttpServletRequest req, HttpServletResponse res) {
		String condition = req.getParameter("n_condition1");
		String input = req.getParameter("n_condition2");

		System.out.println(condition);
		System.out.println(input);

		ArrayList<Notice> n_search = model.n_search(condition, input);
		req.setAttribute("n_search", n_search);

		RequestDispatcher dis = req
				.getRequestDispatcher("/form/boardSearch.jsp");

		try {
			dis.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void adminLoginFail(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dis = req
				.getRequestDispatcher("form/adminLoginFail.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
