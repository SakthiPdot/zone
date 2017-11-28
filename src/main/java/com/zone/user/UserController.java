package com.zone.user;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value = "/user",method = RequestMethod.GET)
	public ModelAndView user(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.setViewName("user/user");
		return model;
		
	}
	
	@RequestMapping(value="/create_user",method = RequestMethod.POST)
	public ModelAndView createuser(HttpServletRequest request,@RequestBody UserModel user) {
		System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		ModelAndView model = new ModelAndView();
		System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		user.setObsolete("N");
		user.setActive("Y");		
		user.setCreated_date(dateFormat.format(date).toString());
		user.setUpdated_date(dateFormat.format(date).toString());
		user.setClient_id(user.getClient_id());
		userDao.saveOrUpdate(user);		
		model.setViewName("user/user");
		return model;
		
	}

}
