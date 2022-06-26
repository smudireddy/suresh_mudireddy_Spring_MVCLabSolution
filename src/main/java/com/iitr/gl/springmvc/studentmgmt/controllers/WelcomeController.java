package com.iitr.gl.springmvc.studentmgmt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	public WelcomeController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage() {
		return "welcome";
	}
}
