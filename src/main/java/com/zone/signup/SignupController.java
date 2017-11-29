package com.zone.signup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zone.user.UserDao;
import com.zone.user.UserModel;


@RestController
public class SignupController {
	
		@Autowired
		SignupDao signupDao;
		
		@Autowired
		UserDao userDao;
		
		@RequestMapping(value = "/", method=RequestMethod.GET)
		public ModelAndView login(HttpServletRequest request) {
			ModelAndView model = new ModelAndView();
			model.setViewName("login");
			return model;
			
		}
		
		@RequestMapping(value = "/sign_up", method=RequestMethod.GET)
		public ModelAndView signup(HttpServletRequest request){
			ModelAndView model = new ModelAndView();
			model.setViewName("signup/signup");
			return model;
		}
		
		
		
		@RequestMapping(value = "/signup_creation", method=RequestMethod.POST)
		public ModelAndView createlogin(@RequestBody SignupModel signup, HttpServletRequest request) {
			
			
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date = new Date();
			ModelAndView model = new ModelAndView();			
			
			signup.setCreated_date(dateFormat.format(date).toString());
			signup.setObsolete("N");
			signup.setActive("Y");
			signupDao.saveOrUpdate(signup);
			
			int clientid = signupDao.maxid();
			
			UserModel users = new UserModel();
			
			users.setClient_id(clientid);
			users.setName(signup.getName());
			users.setUsername(signup.getUsername());
			users.setPassword(signup.getPassword());
			users.setEmail(signup.getEmail());
			users.setMobileno(signup.getMobileno());
			users.setCreated_date(signup.getCreated_date());
			users.setUpdated_date(signup.getCreated_date());
			users.setCreated_user(users.getUser_id());
			users.setUpdated_user(users.getUser_id());
			users.setObsolete(signup.getObsolete());
			users.setActive(signup.getActive());
			
			userDao.saveOrUpdate(users);	
			
			model.setViewName("zone_dashboard");
			return model;			
		}
		
		
		@RequestMapping(value = "/signupreg/", method = RequestMethod.GET)
		public List<SignupModel>  fetchReg(HttpServletRequest request){				
			List<SignupModel> getReg = signupDao.getRegister();		
			return getReg;			
		}
		
		/*@RequestMapping(value = "/logins", method = RequestMethod.POST)
		public ResponseEntity<Boolean> getUser(HttpServletRequest request, @RequestBody String login) throws JSONException {
			JSONObject json = new JSONObject(login);
			boolean userlogin = userDao.login(json.getString("username").toString(),json.getString("password").toString());
			boolean logins = signupDao.getlogin(json.getString("username").toString(),json.getString("password").toString());			
			return new ResponseEntity<Boolean>(userlogin,HttpStatus.OK);
			
		}*/
		
		
		/*@RequestMapping(value = "/logins", method = RequestMethod.POST)
		public ResponseEntity<String> getUser(HttpServletRequest request, @RequestBody String login) throws JSONException {
			JSONObject json = new JSONObject(login);
			
			System.err.println(" logins"+ login);
			String userlogin = signupDao.getlogin(json.getString("username").toString(),json.getString("password").toString());
			String logins = signupDao.getlogin(json.getString("username").toString(),json.getString("password").toString());
			String user = signupDao.getlogin(username, password);
			String username = json.getString("username").toString();
			String password = json.getString("password").toString();
			
			System.out.println(username+" Username");
			return new ResponseEntity<String>(logins,HttpStatus.OK);
			
		}*/
		
		@RequestMapping(value = "/login", method = RequestMethod.POST)
		public ResponseEntity<String> getLogin(HttpServletRequest request, @RequestBody String login) throws JSONException{	
			JSONObject json = new JSONObject(login);
			String username = json.getString("username").toString();
			String password = json.getString("password").toString();
			String logins = userDao.login(username, password);
			json.put("result", logins);
			System.err.println("Error " + logins + password + username +  json.toString());
			return new ResponseEntity<String> (json.toString(),HttpStatus.OK);
			
		}
		
		@RequestMapping( value = "checkUsername", method = RequestMethod.POST)
		public ResponseEntity<Void> checkUsername(@RequestBody String username, HttpServletRequest request) {
			String name = signupDao.checkUsername(username.trim());
			
			if(name == "AVAILABLE") {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
		
			
		}
		
		/*@RequestMapping(value = "/update_signup/{id}", method = RequestMethod.PUT)
		public ResponseEntity<SignupModel> updateSignup(@PathVariable("id") int id , @RequestBody SignupModel signupModel , HttpServletRequest request){
			SignupModel signupUpdate = signupDao.getSignupId(id);
			
			System.out.println("if ");
			if(signupUpdate == null){
				System.out.println("if update");
				return new ResponseEntity<SignupModel> (HttpStatus.NOT_FOUND);
			} else {
				System.out.println("if else");
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				
				signupModel.setCreated_date(dateFormat.format(date));
				signupDao.saveOrUpdate(signupModel);
				return new ResponseEntity<SignupModel> (signupModel,HttpStatus.OK);
			}		
			
		}*/
		
		@RequestMapping(value="/update_signup", method = RequestMethod.POST)
		public ResponseEntity<SignupModel> updateSingup(@RequestBody SignupModel signup, HttpServletRequest request){
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date = new Date();
			signup.setCreated_date(dateFormat.format(date).toString());
			signupDao.saveOrUpdate(signup);
			return new ResponseEntity<SignupModel> (signup,HttpStatus.OK);
			
		}
		
		@RequestMapping(value = "/delete_signup/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<SignupModel> deleteSignup(@PathVariable("id") int id,  HttpServletRequest request){
			
			SignupModel signup = signupDao.getSignupId(id);
			
			if(signup == null) {
				System.out.println("id is null =================>");
				return new ResponseEntity<SignupModel> (HttpStatus.NOT_FOUND);
			} else {
				Date date = new Date();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");				
				signup.setCreated_date(dateFormat.format(date).toString());
				signup.setActive("N");
				signup.setObsolete("Y");
				signupDao.saveOrUpdate(signup);	
				return new ResponseEntity<SignupModel> (signup, HttpStatus.OK);
			}
	
		}
			
}
