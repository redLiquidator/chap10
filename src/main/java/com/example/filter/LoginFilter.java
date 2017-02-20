package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebFilter("/admin/*")
public class LoginFilter implements Filter {
static Log log=LogFactory.getLog(LoginFilter.class);

@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	//모든요청에 대해 필터링. 요청한 사람
	
		log.info("#########");
		log.info("doFilter()");
		log.info("#########");
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp= (HttpServletResponse)response;
		
		Cookie[] cookies =req.getCookies();
	    boolean login=false;
	    
		for (Cookie c:cookies){
			String name=c.getName();
			if("login".equals(name))
				login=true;
		}
		
		
		
		if(login)
			chain.doFilter(request, response);
		else{
			resp.sendRedirect("/login");
		}
		
	}

@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
