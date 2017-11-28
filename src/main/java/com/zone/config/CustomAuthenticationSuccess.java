package com.zone.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.zone.user.UserDao;
import com.zone.user.UserModel;

public class CustomAuthenticationSuccess implements AuthenticationSuccessHandler {
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Autowired
	UserDao userDao;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		System.out.println(authentication.getName()+"=====>authenticator Name");
		
		HttpSession session = request.getSession();
		String username = authentication.getName();
		session.setAttribute("appusername", username);
		System.out.println("===========> Username"+username);
		
		UserModel user = userDao.findbyuserName(username);
		int userclientid = user.getClient_id();
		session.setAttribute("client_id", userclientid);
		System.out.println("===========> client id"+userclientid);
		
		redirectStrategy.sendRedirect(request, response, "/dashboard");
	}

	public RedirectStrategy getRedirectStrategy() {
		return this.redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
	
	

}
