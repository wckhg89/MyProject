package com.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TMModel_Main;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.vo.Band;
import com.vo.BandMember;
import com.vo.BandReply;
import com.vo.BandReview;
import com.vo.Eat;
import com.vo.EatLike;
import com.vo.EatReply;
import com.vo.Friend;
import com.vo.Member;
import com.vo.Play;
import com.vo.PlayLike;
import com.vo.PlayReply;
import com.vo.Sleep;
import com.vo.SleepLike;
import com.vo.SleepReply;


public class TMController_Main {
	TMModel_Main model;

	public TMController_Main() {
		model = new TMModel_Main();
	}
	public void path(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dis = req.getRequestDispatcher("/form/tmap_path.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void mainAll(HttpServletRequest req, HttpServletResponse res) {

		// 모임 정보.
		
		
		Band play = model.band_category(1);
		Band ride = model.band_category(2);
		Band sleep = model.band_category(3);
		Band eat = model.band_category(4);

		req.setAttribute("play", play);
		req.setAttribute("ride", ride);
		req.setAttribute("sleep", sleep);
		req.setAttribute("eat", eat);
		
		// 회원정보에 대한 데이터

		// 로그인한 회원의 아이디를 가져온다.
		HttpSession session = req.getSession();
		String m_id = (String) session.getAttribute("login");

		Member member = model.member_selectAll(m_id);

		req.setAttribute("member", member);

		// 정보글에대한 데이터
		ArrayList<Play> p_list = model.play_selectAll();
		ArrayList<Eat> e_list = model.eat_selectAll();
		ArrayList<Sleep> s_list = model.sleep_selectAll();
		ArrayList<Friend> f_list = model.friendList(m_id);
		
		req.setAttribute("f_list", f_list);
		req.setAttribute("p_list", p_list);
		req.setAttribute("e_list", e_list);
		req.setAttribute("s_list", s_list);

		// forward 방식으로 jsp 화면으로 넘어간다.
		RequestDispatcher dis = req.getRequestDispatcher("/form/main_form.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void recommandLocation(HttpServletRequest req, HttpServletResponse res) {

		/*
		 * recommand_loc_ajax.jsp 에서 넘어온 파라미터에 따라 어떠한
		 * 데이터를 객체에 가져올지 구분한다.
		 */
		HttpSession session = req.getSession();
		String category = req.getParameter("category");
		System.out.println(category+"!@#$");
	
		/*
		 * 데이터를 담기위한 어레이리스트 객체(자바빈)를 준비한다.
		 * (해당하는 좌표를 모두 가져와야하기 때문!) 
		 */
		ArrayList<Play> pList_loc =null;
		ArrayList<Eat> eList_loc =null;
		ArrayList<Sleep> sList_loc =null;
		ArrayList<Band> bList_loc =null;
		
		
		if(category.equals("play")){
			pList_loc = model.play_selectAll();
			//req
			session.setAttribute("pList_loc", pList_loc);
		}else if(category.equals("eat")){
			eList_loc = model.eat_selectAll();
			session.setAttribute("eList_loc", eList_loc);
		}else if(category.equals("sleep")){
			sList_loc = model.sleep_selectAll();
			session.setAttribute("sList_loc", sList_loc);
		}else if(category.equals("band")){
			/*bList_loc = model.*/
		}
		
		
		RequestDispatcher dis = req.getRequestDispatcher("form/recommand_loc.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void make(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		if (session.getAttribute("login") != null) {
			RequestDispatcher dis = req.getRequestDispatcher("form/make.jsp");
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

	/**
	 * 관광지 상세보기
	 * 
	 * @param req
	 * @param res
	 */
	public void playDetail(HttpServletRequest req, HttpServletResponse res) {
		int p_num = Integer.parseInt(req.getParameter("p_num"));
		String p_m_id = req.getParameter("p_m_id");
		System.out.println("!!!!!");
		System.out.println(p_num + " " + p_m_id);

		// 가져와야할 항목들 : 개시글(tm_play), 댓글(p_reply), 좋아요(p_like)
		Play playList = model.play_selectOne(p_num);
		////
		ArrayList<PlayLike> like = model.play_selectLike(p_num);
		
		///
		ArrayList<PlayReply> reply = model.play_selectReply(p_num);
		
		System.out.println(playList.getP_location()+"####");
		req.setAttribute("playList", playList);
		req.setAttribute("playRList", reply);
		req.setAttribute("playLList",like);

		RequestDispatcher dis = req
				.getRequestDispatcher("/form/playDetail.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void eatDetail(HttpServletRequest req, HttpServletResponse res) {
		int e_num = Integer.parseInt(req.getParameter("e_num"));
		String e_m_id = req.getParameter("e_m_id");
		System.out.println("!!!!!");
		System.out.println(e_num + " " + e_m_id);

		// 가져와야할 항목들 : 개시글(tm_play), 댓글(p_reply), 좋아요(p_like)
		Eat eatList = model.eat_selectOne(e_num);
		ArrayList<EatReply> reply = model.eat_selectReply(e_num);
		// //
		ArrayList<EatLike> like = model.eat_selectLike(e_num);

		// /
		System.out.println(eatList.getE_location()+"####");
		req.setAttribute("eatList", eatList);
		req.setAttribute("eatRList", reply);
		req.setAttribute("eatLList",like);

		RequestDispatcher dis = req
				.getRequestDispatcher("/form/eatDetail.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void sleepDetail(HttpServletRequest req, HttpServletResponse res) {
		int s_num = Integer.parseInt(req.getParameter("s_num"));
		String s_m_id = req.getParameter("s_m_id");
		System.out.println("!!!!!");
		System.out.println(s_num + " " + s_m_id);

		// 가져와야할 항목들 : 개시글(tm_play), 댓글(p_reply), 좋아요(p_like)
		Sleep sleepList = model.sleep_selectOne(s_num);
		ArrayList<SleepReply> reply = model.sleep_selectReply(s_num);
		// //
		ArrayList<SleepLike> like = model.sleep_selectLike(s_num);

		// /
		System.out.println(sleepList.getS_location()+"####");
		req.setAttribute("sleepList", sleepList);
		req.setAttribute("sleepRList", reply);
		req.setAttribute("sleepLList",like);

		RequestDispatcher dis = req
				.getRequestDispatcher("/form/sleepDetail.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void enterReply(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.setCharacterEncoding("EUC-KR");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String id = req.getSession().getAttribute("login").toString();
		String p_m_id = req.getParameter("id");
		int p_num = Integer.parseInt(req.getParameter("p_num"));
		String content_Rply = req.getParameter("content_Rply");
		
		System.out.println(content_Rply + "#%^&");
		
		boolean isComplete = model.enterReply(id, p_num, content_Rply);
		
		if(isComplete == true){
			/*this.detailContent(req, res);*/
			try {
				res.sendRedirect("play_detail.do?p_num=" + p_num
						+ "&p_m_id=" + p_m_id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}else{
			System.out.println("Error!");
		}
		
	}
	public void enterLike(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getSession().getAttribute("login").toString();
		String p_m_id = req.getParameter("id");
		int p_num = Integer.parseInt(req.getParameter("p_num"));
		
		
		boolean isComplete = model.enterLike(id, p_num);
		
		if(isComplete == true){
			try {
				res.sendRedirect("play_detail.do?p_num=" + p_num
						+ "&p_m_id=" + p_m_id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else{
			System.out.println("Error!");
		}
		
	}
	
	public void enterEatReply(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.setCharacterEncoding("EUC-KR");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String id = req.getSession().getAttribute("login").toString();
		String e_m_id = req.getParameter("id");
		int e_num = Integer.parseInt(req.getParameter("e_num"));
		String e_content_Rply = req.getParameter("e_content_Rply");
		
		System.out.println(e_content_Rply + "#%^&");
		
		boolean isComplete = model.enterEatReply(id, e_num, e_content_Rply);
		
		if(isComplete == true){
			/*this.detailContent(req, res);*/
			try {
				res.sendRedirect("eat_detail.do?e_num=" + e_num
						+ "&e_m_id=" + e_m_id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}else{
			System.out.println("Error!");
		}
		
	}
	public void enterEatLike(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getSession().getAttribute("login").toString();
		String e_m_id = req.getParameter("id");
		int e_num = Integer.parseInt(req.getParameter("e_num"));
		
		
		boolean isComplete = model.enterEatLike(id, e_num);
		
		if(isComplete == true){
			try {
				res.sendRedirect("eat_detail.do?e_num=" + e_num
						+ "&e_m_id=" + e_m_id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else{
			System.out.println("Error!");
		}
		
	}

	public void enterSleepReply(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.setCharacterEncoding("EUC-KR");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String id = req.getSession().getAttribute("login").toString();
		String s_m_id = req.getParameter("id");
		int s_num = Integer.parseInt(req.getParameter("s_num"));
		String s_content_Rply = req.getParameter("s_content_Rply");
		
		System.out.println(s_content_Rply + "#%^&");
		
		boolean isComplete = model.enterSleepReply(id, s_num, s_content_Rply);
		
		if(isComplete == true){
			/*this.detailContent(req, res);*/
			try {
				res.sendRedirect("sleep_detail.do?s_num=" + s_num
						+ "&s_m_id=" + s_m_id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}else{
			System.out.println("Error!");
		}
		
	}
	public void enterSleepLike(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getSession().getAttribute("login").toString();
		String s_m_id = req.getParameter("id");
		int s_num = Integer.parseInt(req.getParameter("s_num"));
		
		
		boolean isComplete = model.enterSleepLike(id, s_num);
		
		if(isComplete == true){
			try {
				res.sendRedirect("sleep_detail.do?s_num=" + s_num
						+ "&s_m_id=" + s_m_id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else{
			System.out.println("Error!");
		}
		
	}
	
	public void socialDetail(HttpServletRequest req, HttpServletResponse res) {
		int b_num = Integer.parseInt(req.getParameter("b_num"));
		String b_m_id = req.getParameter("b_m_id");

		ArrayList b_list = model.b_selectOne(b_num);
		ArrayList<BandReply> br_list = model.br_selectOne(b_num);
		ArrayList<BandReview> brv_list = model.brv_selectOne(b_num);

		Band b = (Band) b_list.get(0);
		Member m = model.m_selectOne(b_m_id);

		req.setAttribute("b", b);
		req.setAttribute("m", m);

		ArrayList<Member> ml = new ArrayList<Member>();

		for (int i = 1; i < b_list.size(); i++) {
			ml.add((Member) b_list.get(i));
		}
		req.setAttribute("ml", ml);
		req.setAttribute("m_size", ml.size());

		req.setAttribute("br", br_list);

		req.setAttribute("brv", brv_list);
		for(int i=0 ; i<brv_list.size() ; i++){
			System.out.println(brv_list.get(i).getB_rv_img() + "##");
			
		}
		System.out.println("start");

		RequestDispatcher dis = req
				.getRequestDispatcher("/form/socialDetail.jsp");
		try {
			dis.forward(req, res);
			System.out.println("finish");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void snsMake(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		if (session.getAttribute("login") != null) {
			RequestDispatcher dis = req
					.getRequestDispatcher("form/sns_make.jsp");
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

	public void snsProcess(HttpServletRequest req, HttpServletResponse res) {
		String uploadPath = req.getRealPath("files"); // 실제 시스템 상의 경로를 얻어온다.
		int size = 1024 * 1024 * 1024; // 업로드 파일의 최대 크기 지정
		String filename1 = "";
		boolean isJoin = false;
		try {
			/*
			 * 실제 파일 업로드 담당. 인수 1) 폼에서 가져온 인자 값을 얻어오기 위해 request객체를 전달 인수 2)
			 * 업로드될 파일의 위치를 의미 인수 3) 최대 크기 인수 4) 파일 이름의 한글일 경우 문제가 되므로 처리할수 있도록
			 * 인코딩 타입지정. 인수 5) 인자는 똑같은 파일을 업로드할 경우 중복되지 않도록 자동으로 파일이름을 변환해주는 기능을
			 * 한다.(DefaultFileRenamePolicy)
			 */
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
			MultipartRequest multi = new MultipartRequest(req, uploadPath,
					size, "euc-kr", policy);

			System.out.println("#");
			// 업로드한 파일들을 Enumeration타입으로 반환한다.
			Enumeration files = multi.getFileNames();

			HttpSession session = req.getSession();
			String id = (String) session.getAttribute("login");
			String file1 = (String) files.nextElement();
			filename1 = multi.getFilesystemName(file1);
			String img = "/" + filename1;
			System.out.println("이미지경로 : " + uploadPath);
			String category = multi.getParameter("act");
			String price_tmp = multi.getParameter("price");
			int price = 0;
			if (price_tmp.equals("won1")) {
				price = 1;
			} else if (price_tmp.equals("won2")) {
				price = 2;
			} else if (price_tmp.equals("won5")) {
				price = 5;
			}
			String season = multi.getParameter("session");
			String inout = multi.getParameter("inout");
			String title = multi.getParameter("title");
			String content = multi.getParameter("maketext");
			String location = multi.getParameter("placetxt");
			System.out.println(location+"#####");
			String location2 = "seoul";

			System.out.println(id + " " + img + " " + category + " "
					+ price_tmp + inout + " " + content + season + title+ "!@!%!%");
			// date
			if (category.equals("play")) {
				Play p = new Play(id, img, price, season, inout, content,
						location, location2);
				p.setP_title(title);
				isJoin = model.sns_make(1, p);
			} else if (category.equals("eat")) {
				
				Eat e = new Eat();
				e.setE_m_id(id);
				e.setE_img(img);
				e.setE_price(price);
				e.setE_session(season);
				e.setE_inout(inout);
				e.setE_title(title);
				e.setE_content(content);
				e.setE_location(location);
				e.setE_location2(location2);
				
				isJoin = model.sns_make(2, e);
			} else if (category.equals("sleep")) {
				Sleep s = new Sleep(id, img, price, season, inout, content,
						location, location2);
				s.setS_title(title);
				isJoin = model.sns_make(3, s);
			}
			if (isJoin == true) {
				RequestDispatcher dis = req
						.getRequestDispatcher("/form/makeSuccess.jsp");
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

	public void meetingMake(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		if (session.getAttribute("login") != null) {
			RequestDispatcher dis = req
					.getRequestDispatcher("form/meeting_make.jsp");
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

	public void meetingProcess(HttpServletRequest req, HttpServletResponse res) {
		String uploadPath = req.getRealPath("files"); // 실제 시스템 상의 경로를 얻어온다.
		int size = 1024 * 1024 * 1024; // 업로드 파일의 최대 크기 지정
		String filename1 = "";

		try {
			/*
			 * 실제 파일 업로드 담당. 인수 1) 폼에서 가져온 인자 값을 얻어오기 위해 request객체를 전달 인수 2)
			 * 업로드될 파일의 위치를 의미 인수 3) 최대 크기 인수 4) 파일 이름의 한글일 경우 문제가 되므로 처리할수 있도록
			 * 인코딩 타입지정. 인수 5) 인자는 똑같은 파일을 업로드할 경우 중복되지 않도록 자동으로 파일이름을 변환해주는 기능을
			 * 한다.(DefaultFileRenamePolicy)
			 */
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
			MultipartRequest multi = new MultipartRequest(req, uploadPath,
					size, "euc-kr", policy);

			System.out.println(uploadPath+"@");
			// 업로드한 파일들을 Enumeration타입으로 반환한다.
			Enumeration files = multi.getFileNames();
			
			String file1 = (String) files.nextElement();
			filename1 = multi.getFilesystemName(file1);
			System.out.println(file1+"@!$%" +filename1);
			HttpSession session = req.getSession();
			String b_m_id = (String) session.getAttribute("login");
			String b_category = multi.getParameter("act");
			String b_title = multi.getParameter("title");
			// String s_subtitle = multi.getParameter("m_id");
			String b_img1 = filename1;

			String b_content = multi.getParameter("maketext");
			System.out.println(b_content+"@#$");
			// date
			int b_people = Integer.parseInt(multi.getParameter("people"));
			String b_when = multi.getParameter("currentDate");
			String b_where = multi.getParameter("place");
			
			
			
			
			Band b = new Band(b_m_id, b_category, b_title, b_img1, b_content,
					b_people, b_when, b_where);
			
	
			
			boolean isJoin = model.b_make(b);
			if (isJoin == true) {
				RequestDispatcher dis = req
						.getRequestDispatcher("/form/makeSuccess.jsp");
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
	public void socialJoinProcess(HttpServletRequest req,
			HttpServletResponse res) {
		HttpSession session = req.getSession();
		
		if (session.getAttribute("login") != null) {
			
			String j_m_id = (String) session.getAttribute("login");
			//로그인한 회원
			int j_num = Integer.parseInt(req.getParameter("b_num"));
			
			String b_m_id = req.getParameter("b_m_id");
			//모입 작성한 회원
			
			if (!j_m_id.equals(b_m_id)) {
				//모임작성자가 모임에 참여하려고 하면 막는다.
				/*System.out.println(mp_id+"@#"); // 누른사람 id
				System.out.println(mp_num+"@#"); // 모임번호 s_num
				System.out.println(s_id+"@#"); // 모임주최자 id
*/
				BandMember bm = new BandMember();/*(mp_num, mp_id);*/
				bm.setJ_num(j_num);
				bm.setJ_m_id(j_m_id);
				
				model.s_memberJoin(bm);

				try {
					res.sendRedirect("socialDetail.do?b_num=" + j_num
							+ "&b_m_id=" + b_m_id);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}else{
				try {
					res.sendRedirect("s_maker.do");
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				res.sendRedirect("login.do");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void b_rv_insert(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String uploadPath = req.getRealPath("/files");
		int size = 10 * 1024 * 1024;
		String filename1 = "";
		
		if (session.getAttribute("login") != null) {
			try {
				DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
				MultipartRequest multi = new MultipartRequest(req, uploadPath,
						size, "euc-kr", policy);

				String b_rv_m_id = (String) session.getAttribute("login"); // 리뷰
																			// 쓴사람
				// id
				int b_rv_num = Integer.parseInt(multi.getParameter("s_rv_num")); // 모임
				// 번호
				// if(s_rv_id
				boolean isJoin = model.findJoinMember(b_rv_m_id, b_rv_num);
				if (isJoin == true) {
					// if

					// 업로드한 파일들을 Enumeration타입으로 반환한다.
					Enumeration files = multi.getFileNames();
					
					String file1 = (String) files.nextElement();
					System.out.println("vvvv:" + file1);

					String b_m_id = multi.getParameter("b_m_id"); // 모임 주최자 id

					String b_rv_img = multi.getFilesystemName(file1); // 이미지
					System.out.println(b_rv_img+"&&&&");
					String b_rv_content = multi.getParameter("review"); // 내용

					/*System.out.println(s_rv_id + "--" + s_rv_num + "--"
							+ s_rv_img + "--" + s_rv_content
							+ " review Accept!!!!@");*/
					BandReview brv = new BandReview();
					
					brv.setB_rv_num(b_rv_num);
					brv.setB_rv_img(b_rv_img);
					brv.setB_rv_m_id(b_rv_m_id);
					brv.setB_rv_content(b_rv_content);
					

					model.b_rv_add(brv);

			
					try {
						res.sendRedirect("socialDetail.do?b_num=" + b_rv_num
								+ "&b_m_id=" + b_m_id);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					try {
						res.sendRedirect("s_maker.do");
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				res.sendRedirect("login.do");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public void b_r_insert(HttpServletRequest req, HttpServletResponse res) {

		HttpSession session = req.getSession();

		if (session.getAttribute("login") != null) {
			String b_m_id = req.getParameter("b_r_m_id");
			String b_r_id = (String) session.getAttribute("login");
			int b_r_num = Integer.parseInt(req.getParameter("b_r_num"));
			String b_r_content = req.getParameter("inputcom");

			BandReply br = new BandReply();
			br.setB_r_m_id(b_r_id);
			br.setB_r_num(b_r_num);
			br.setB_r_content(b_r_content);
			
			System.out.println(b_r_content + "!@#%");
			model.b_r_add(br);

			try {
				res.sendRedirect("socialDetail.do?b_num=" + b_r_num + "&b_m_id="
						+ b_m_id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				res.sendRedirect("login.do");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
