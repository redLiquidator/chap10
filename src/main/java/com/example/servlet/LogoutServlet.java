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

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	static Log log= LogFactory.getLog(LogoutServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("#########");
		log.info("doPost()");
		log.info("##########");
		
		Cookie logout= new Cookie("login","hong");
		logout.setPath("/");
		logout.setMaxAge(0);
		
		response.addCookie(logout);
		
		response.sendRedirect("/index.jsp");
		
}
	}
