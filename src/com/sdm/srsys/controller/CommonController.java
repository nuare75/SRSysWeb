package com.sdm.srsys.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/")
@SessionAttributes(value = { "userContainer" })
public class CommonController {
	
	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String index(ModelMap model) {
//		if ()
		return "redirect:/login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login() {
		return "/common/login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String submitLogin(ModelMap model) {
		return "redirect:/student/";
	}

//	@RequestMapping(value = { "/landing" }, method = RequestMethod.GET)
//	public String main(ModelMap model) {
//		if () {
//			return "redirect:/emp/empManage";
//		} else if () {
//			return "";
//		}
//	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout(HttpSession session, ModelMap model) {
		session.invalidate();
		return "redirect:/";
	}

}
