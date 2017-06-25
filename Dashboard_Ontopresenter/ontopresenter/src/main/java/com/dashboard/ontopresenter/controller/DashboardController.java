package com.dashboard.ontopresenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dashboard.ontopresenter.model.*;
import com.dashboard.ontopresenter.repository.Users;

@Controller
public class DashboardController {
	
	@Autowired
	private Users users;
	
	@RequestMapping("/index")
	public String RequestDashboard() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String RequestLogin() {
		return "login";
	}
	
	@RequestMapping("/user")
	public String RequestUser() {
		return "user";
	}
	
	@RequestMapping("/sign_up")
	public String RequestSignUP() {
		return "sign_up";
	}
	
	@RequestMapping(value="/create_user", method = RequestMethod.POST)
	public ModelAndView SignUp(User user){
		System.out.println(">>> " + user.getName());
		ModelAndView mv = new ModelAndView("user");
		users.save(user);
		mv.addObject("name", "Allan");
		return mv;
	}
}
