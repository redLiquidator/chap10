package com.example.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	static Log log= LogFactory.getLog(LoginServlet.class);
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("##########");
		log.info("doGet()");
		log.info("##########");
		
		String error=request.getParameter("error");
		log.info("error=["+error+"]");
		if(error!=null)
			request.setAttribute("errorMessage", "id,pw를 확인하세요");
		
			
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/loginform.jsp");
		dispatcher.forward(request, response);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("#########");
		log.info("doPost()");
		log.info("##########");
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		log.info("id="+id);
		log.info("pw"+pw);
		
		/*
		 * 인증처리
		 */
		
		if("hong".equals(id)&& "1234".equals(pw)){
			//인증성공
			Cookie login = new Cookie("login","hong");
			login.setPath("/");
			response.addCookie(login);
			response.sendRedirect("/index.jsp");
			
		}else{
			response.sendRedirect("/login?error");
		}
		
	}
}
