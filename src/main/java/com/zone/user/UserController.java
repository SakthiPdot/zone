package com.zone.user;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zone.config.UserInformation;
import com.zone.role.RoleDao;
import com.zone.role.RoleModel;

@RestController
public class UserController {
	
	@Autowired
	UserDao userDao;
	@Autowired
	RoleDao roleDao;
	
	UserInformation userInformation;
	
	@RequestMapping(value = "/user",method = RequestMethod.GET)
	public ModelAndView user(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.setViewName("user/user");
		return model;
		
	}
	
	@RequestMapping(value = "/role/", method = RequestMethod.GET)
	public ResponseEntity<List<RoleModel>> fetchRoles(HttpServletRequest request){
		List<RoleModel> roleList = roleDao.list();		
		return new ResponseEntity<List<RoleModel>>(roleList, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/create_user",method = RequestMethod.POST)
	public ModelAndView createuser(HttpServletRequest request,@RequestBody UserModel user) {
				
		userInformation = new UserInformation(request);
		String username = userInformation.getUserName();	
		String clientid = userInformation.getClientId();		
		String userid = userInformation.getUserId();		
		
		System.out.println(userid + clientid + username);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		ModelAndView model = new ModelAndView();
		user.setClient_id(Integer.parseInt(clientid));
		user.setRole_id(1);
		user.setObsolete("N");
		user.setActive("Y");		
		user.setCreated_date(dateFormat.format(date).toString());
		user.setUpdated_date(dateFormat.format(date).toString());
		user.setCreated_user(Integer.parseInt(userid));
		user.setUpdated_user(Integer.parseInt(userid));
		userDao.saveOrUpdate(user);		
		model.setViewName("user/user");
		return model;
		
	}
	
	@RequestMapping(value = "/userreg/", method = RequestMethod.GET)
	public List<UserModel> fetchUserReg(HttpServletRequest request){
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("names");
		UserModel uname = userDao.findbyuserName(username);
		int userclientid = uname.getClient_id();
		int userid = uname.getUser_id();
		session.setAttribute("username", username);
		session.setAttribute("clientid", userclientid);
		session.setAttribute("userid", userid);		
		System.out.println(userclientid);
		List<UserModel> getUser = userDao.getUserRegister(userclientid);
		return getUser;
		
	}
	
	
	@RequestMapping(value = "UsernameCheck", method = RequestMethod.POST)
	public ResponseEntity<Void> CheckUsername(HttpServletRequest request, @RequestBody String username) {
		
		userInformation = new UserInformation(request);
		String clientid = userInformation.getClientId();
		
		String userckecks = userDao.CheckUser(Integer.parseInt(clientid), username);
		if(userckecks == "AVAILABLE") {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Void> (HttpStatus.OK);
		}
		
			
	}
	
	
	

}
