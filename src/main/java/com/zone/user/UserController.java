package com.zone.user;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("names");
		UserModel uname = userDao.findbyuserName(username);
		int userclientid = uname.getClient_id();
		int userid = uname.getUser_id();
		session.setAttribute("username", username);
		session.setAttribute("clientid", userclientid);
		session.setAttribute("userid", userid);		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		ModelAndView model = new ModelAndView();
		user.setClient_id(userclientid);
		user.setObsolete("N");
		user.setActive("Y");		
		user.setCreated_date(dateFormat.format(date).toString());
		user.setUpdated_date(dateFormat.format(date).toString());
		user.setCreated_user(userid);
		user.setUpdated_user(userid);
		userDao.saveOrUpdate(user);		
		model.setViewName("user/user");
		return model;
		
	}

}
