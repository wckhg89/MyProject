package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.TMController_Board;
import com.controller.TMController_Main;
import com.controller.TMController_Member;
import com.controller.TMController_SNS;
import com.controller.TMController_Search;
import com.controller.TMController_Weather;

public class TMFilter implements Filter {
	TMController_Member controller_member;
	TMController_Main controller_main;
	TMController_Board controller_board;
	TMController_Weather controller_weather;
	TMController_SNS controller_SNS;
	TMController_Search controller_Search;

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		controller_member = new TMController_Member();
		controller_main = new TMController_Main();
		controller_board = new TMController_Board();
		controller_weather = new TMController_Weather();
		controller_SNS = new TMController_SNS();
		controller_Search = new TMController_Search();

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		req.setCharacterEncoding("EUC-KR");

		String reqString = req.getServletPath();
		if (reqString.equals("/login.do")) {
			controller_member.login(req, res);
		} else if (reqString.equals("/loginProcess.do")) {
			controller_member.loginProcess(req, res);
		} else if (reqString.equals("/loginFail.do")) {
			controller_member.loginFail(req, res);
		} else if (reqString.equals("/join.do")) {
			controller_member.join(req, res);
		} else if (reqString.equals("/joinProcess.do")) {
			controller_member.joinProcess(req, res);
		} else if (reqString.equals("/mainAll.do")) {
			controller_main.mainAll(req, res);
		} else if (reqString.equals("/playSNS.do")) {
			controller_SNS.SNS_Play(req, res);
		} else if (reqString.equals("/notice.do")) {
			controller_board.noticeAll(req, res);
		} else if (reqString.equals("/notice.do")) {
			controller_board.noticeAll(req, res);
		} else if (reqString.equals("/noticeNew.do")) {
			controller_board.noticeInsert(req, res);
		} else if (reqString.equals("/n_insertProcess.do")) {
			controller_board.noticeInsertProcess(req, res);
		} else if (reqString.equals("/n_Detail.do")) {
			controller_board.noticeDetail(req, res);
		} else if (reqString.equals("/n_r_insert.do")) {
			controller_board.n_r_insertProcess(req, res);
		} else if (reqString.equals("/r_delete.do")) {
			controller_board.r_delete(req, res);
		} else if (reqString.equals("/noticeSearch.do")) {
			controller_board.noticeSearch(req, res);
		} else if (reqString.equals("/n_modify.do")) {
			controller_board.noticeModify(req, res);
		} else if (reqString.equals("/n_modifyProcess.do")) {
			controller_board.noticeModifyProcess(req, res);
		} else if (reqString.equals("/adminLoginFail.do")) {
			controller_board.adminLoginFail(req, res);
		} else if (reqString.equals("/n_delete.do")) {
			controller_board.n_delete(req, res);
		} else if (reqString.equals("/make.do")) {
			controller_main.make(req, res);
		} else if (reqString.equals("/sns_make.do")) {
			controller_main.snsMake(req, res);
		} else if (reqString.equals("/sns_make_process.do")) {
			controller_main.snsProcess(req, res);
		} else if (reqString.equals("/meeting_make.do")) {
			controller_main.meetingMake(req, res);
		} else if (reqString.equals("/play_detail.do")) {
			controller_main.playDetail(req, res);
		} else if (reqString.equals("/enterReply.do")) {
			controller_main.enterReply(req, res);
		} else if (reqString.equals("/enterLike.do")) {
			controller_main.enterLike(req, res);
		}

		else if (reqString.equals("/eat_detail.do")) {
			controller_main.eatDetail(req, res);
		} else if (reqString.equals("/enterEatReply.do")) {
			controller_main.enterEatReply(req, res);
		} else if (reqString.equals("/enterEatLike.do")) {
			controller_main.enterEatLike(req, res);
		}

		else if (reqString.equals("/sleep_detail.do")) {
			controller_main.sleepDetail(req, res);
		} else if (reqString.equals("/enterSleepReply.do")) {
			controller_main.enterSleepReply(req, res);
		} else if (reqString.equals("/enterSleepLike.do")) {
			controller_main.enterSleepLike(req, res);
		}

		else if (reqString.equals("/meet_make_process.do")) {
			controller_main.meetingProcess(req, res);
		} else if (reqString.equals("/socialDetail.do")) {
			controller_main.socialDetail(req, res);
		} else if (reqString.equals("/weather.do")) {
			controller_weather.weatherState(req, res);
		} else if (reqString.equals("/recommand_loc.do")) {
			controller_main.recommandLocation(req, res);
		} else if (reqString.equals("/search_page.do")) {
			controller_Search.selectContents(req, res);
		} else if (reqString.equals("/search_contents.do")) {
			controller_Search.searchContents(req, res);
		} else if (reqString.equals("/search_new_contents.do")) {
			controller_Search.searchNewContents(req, res);
		} else if (reqString.equals("/search_like_contents.do")) {
			controller_Search.searchLikeContents(req, res);
		} else if (reqString.equals("/dateSearch.do")) {
			controller_Search.searchDateContents(req, res);
		} else if (reqString.equals("/tmap_path.do")) {
			controller_main.path(req, res);
		} else if (reqString.equals("/b_r_insert.do")) {
			controller_main.b_r_insert(req, res);
		} else if (reqString.equals("/b_rv_insert.do")) {
			controller_main.b_rv_insert(req, res);
		} else if (reqString.equals("/s_joinProcess.do")) {
			controller_main.socialJoinProcess(req, res);
		}

		else if (reqString.equals("/meet_friend.do")) {
			controller_member.meetFriend(req, res);
		}else if(reqString.equals("/memberDetail.do")) {
			controller_member.memberDetail(req,res);
		}

		/*
		 * else if (reqString.equals("/ajax.do")) { controller_weather.ajax(req,
		 * res); }
		 */

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}
