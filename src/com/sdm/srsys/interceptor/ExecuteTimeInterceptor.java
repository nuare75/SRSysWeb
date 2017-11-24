package com.sdm.srsys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		long startTime = System.currentTimeMillis();

		HttpSession session= request.getSession();
		Object a = session.getAttribute("userContainer");
		System.out.println( a + "::" + request.getRequestURL().toString() + ":: Start Time=" + startTime);
		request.setAttribute("startTime", startTime);

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//		HttpSession session= request.getSession();
//		Object a = session.getAttribute("userContainer");
//		System.out.println(a + "::" + request.getRequestURL().toString() + " Sent to Handler :: Current Time=" + System.currentTimeMillis());
		// we can add attributes in the modelAndView and use that in the view page
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		long startTime = (Long) request.getAttribute("startTime");
		HttpSession session= request.getSession();
		Object a = session.getAttribute("userContainer");
//		System.out.println(a + "::" + request.getRequestURL().toString() + ":: End Time=" + System.currentTimeMillis());
		System.out.println(a + "::" + request.getRequestURL().toString() + ":: Time Taken=" + (System.currentTimeMillis() - startTime));
	}

}
