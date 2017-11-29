package com.zone.dashboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.zone.signup.SignupDao;
import com.zone.signup.SignupModel;
import com.zone.user.UserDao;
import com.zone.user.UserModel;



@RestController
public class DashboardController {
	
	@Autowired
	SignupDao signupDao;
	@Autowired
	UserDao userDao;
	
	
	
	@RequestMapping(value = "/dashboard", method=RequestMethod.GET)
	public ModelAndView dashboard(HttpServletRequest request){
		
		ModelAndView model = new ModelAndView();
		model.setViewName("zone_dashboard");
		return model;		
	}
	
}
