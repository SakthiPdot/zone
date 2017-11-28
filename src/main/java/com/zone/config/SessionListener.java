package com.zone.config;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zone.common.UserInformation;
import com.zone.user.UserDao;
import com.zone.user.UserModel;

@Component
@Scope(value = "session")
public class SessionListener extends HttpSessionEventPublisher {
		
		public static final Logger logger = Logger.getLogger(SessionListener.class);
		
		UserInformation userInformation;
		
		@Autowired
		UserDao userDao;
		
		@Override
		public void sessionCreated( HttpSessionEvent event){
			
			
			
			System.out.println("Session Created =============================================>");			 
			
			super.sessionCreated(event);
		}
		
		@Override
		public void sessionDestroyed(HttpSessionEvent event){
			
			System.out.println("Session Destroyed ==============>");
			super.sessionDestroyed(event);
		}

}
