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

import com.controller.TMController_Content_MB;
import com.controller.TMController_Main_MB;
import com.controller.TMController_Member_MB;
import com.controller.TMController_Public_MB;


public class TMFilter_MB implements Filter {

	TMController_Main_MB controller_main;
	TMController_Member_MB controller_member;
	TMController_Content_MB controller_content;
	TMController_Public_MB controller_public;
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		controller_main = new TMController_Main_MB();
		controller_member = new TMController_Member_MB();
		controller_content = new TMController_Content_MB();
		controller_public  = new TMController_Public_MB();
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		req.setCharacterEncoding("EUC-KR");

		String reqString = req.getServletPath();
		if (reqString.equals("/main_mb.do")) {
			controller_main.mainAll(req, res);
		}else if(reqString.equals("/main_contents.do")) {
			controller_main.mainContents(req,res);
		}else if(reqString.equals("/login.do")){
			controller_member.Login(req,res);
		}else if(reqString.equals("/loginProcess.do")){
			controller_member.loginProcess(req,res);
		}else if(reqString.equals("/loginFail.do")){
			controller_member.loginFail(req, res);
		}else if(reqString.equals("/memberInfo.do")){
			controller_member.memberInfo(req,res);
		}else if(reqString.equals("/detailContent.do")){
			controller_content.detailContent(req, res);
		}else if(reqString.equals("/enterReply.do")){
			controller_content.enterReply(req, res);
		}else if(reqString.equals("/enterLike.do")){
			controller_content.enterLike(req, res);
		}else if(reqString.equals("/writePlay.do")){
			
		}else if(reqString.equals("/join.do")){
			controller_member.Join(req, res);
		}
		else if(reqString.equals("/write.do")){
			controller_public.Write(req, res);
		}
		else if(reqString.equals("/recommend.do")){
			controller_public.publicContents(req,res);
		}
		
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
