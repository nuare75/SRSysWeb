package com.sdm.srsys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
//		HttpSession session= request.getSession();
//		System.out.println("AuthInterceptor");
//		if (session.getAttribute("userContainer")== null){
//			//response.sendRedirect(request.getContextPath()+"/index.jsp");
//			//let the user know what happening rather than just show login form
//			response.sendRedirect(request.getContextPath()+"/login?err=s1");
//			return false;
//		}
		return true;
	}


	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3) throws Exception {
	}

}