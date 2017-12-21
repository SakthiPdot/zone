package com.zone.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserInformation {
	
	public String UserName;
	public String ClientId;
	public String UserId;
	
	public UserInformation(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		this.UserName = (String) request.getSession().getAttribute("username");
		this.ClientId = (String) request.getSession().getAttribute("clientid").toString();
		this.UserId = (String) request.getSession().getAttribute("userid").toString();
	}
	
	public UserInformation(){
		
	}
	
	public String getUserName(){
		return this.UserName;		
	}
	
	public String getClientId() {
		return this.ClientId;		
	}
	
	public String getUserId() {
		return this.UserId;		
	}

}
