package com.zone.user;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao{
	
		@Autowired
		SessionFactory sessionFactory;

		//======== User Save Function =========//
		@Override
		@Transactional
		public void saveOrUpdate(UserModel user) {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			
		}
		
		//======== Login Process =============//
		@Override
		@Transactional
		public String login(String username, String password) {
			String hql = "from UserModel where username='"+username+"' AND password ='"+password+"' AND obsolete='N' AND active = 'Y' ";
			Query query = sessionFactory.getCurrentSession()
					.createQuery(hql);	
			@SuppressWarnings("unchecked")
			List<UserModel> login = (List<UserModel>) query.list();
			
			if(login != null && !login.isEmpty()) {
				return login.toString();
			}
				return "null";
		}

		
		
		@Override
		@Transactional
		@SuppressWarnings("unchecked")
		public UserModel findbyuserName(String username) {
			
			List<UserModel> user = new ArrayList<UserModel>();
			user = sessionFactory.getCurrentSession().createQuery("from UserModel where username=? AND obsolete = 'N' and active = 'Y'").setParameter(0, username).list();
			if(user.size() > 0)
			{
				return user.get(0);
			} else {
				
				return null;
			}
			
		}
}
