package com.zone.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserInformation {
	
	private final Logger logger = LoggerFactory.getLogger(UserInformation.class);
		

	public String userName;
	public String userId;
	public String userClientId;
	
	public UserInformation(HttpServletRequest request){
		HttpSession session = request.getSession(false);
	/*
		try 
		    {*/
			System.out.println("ffffffffffffff");
				this.userName = (String) request.getSession().getAttribute("appusername");
				System.out.println("======"+session+"hhhhhhhhh"+this.userName);
				this.userId = (String) request.getSession().getAttribute("user_id");
				this.userClientId = (String) request.getSession().getAttribute("client_id");
				
				System.out.println("======LLLL"+userId);
			 /*} 
		
		catch(Exception exception) 
			{
				session.invalidate();
				System.out.println("ffffffffffffff1");
			}*/
				System.out.println("======"+session+"hhhhhhhhh"+this.userName);
	}
	
	
	public UserInformation() {
		
	}

	
	
	public String getUsername() {
		return this.userName;		
	}
	
	public String getUserId(){
		return this.userId;
	}
	
	public String getUserClientId() {
		return this.userClientId;
	}
}
