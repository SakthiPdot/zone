package com.zone.signup;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SignupDaoImpl implements SignupDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	//==== Save Signup Function =====//
	@Override
	@Transactional
	public void saveOrUpdate(SignupModel signup) {		
		sessionFactory.getCurrentSession().saveOrUpdate(signup);
	}

	@Override
	@Transactional
	public String getlogin(String username, String password) {	
		
		String hql = "from SignupModel where username='"+username+"' AND password = '"+password+"' AND obsolete = 'N' AND active = 'Y'";
		Query query = sessionFactory.getCurrentSession()
				.createQuery(hql);		
		if(query.uniqueResult() != null) {			
			return "vvv";
		}
			return null;
		
	
	}

	@Override
	@Transactional
	public List<SignupModel> getRegister() {
		@SuppressWarnings("unchecked")
		List <SignupModel> getreg = (List<SignupModel>) sessionFactory.getCurrentSession()
				.createQuery("from SignupModel where obsolete = 'N' and active = 'Y' ").list();
		
		return getreg;
	}

	@Override
	@Transactional
	public String checkUsername(String username) {
		@SuppressWarnings("unchecked")
		List<SignupModel> getUsername = sessionFactory.getCurrentSession()
				.createQuery("from SignupModel where obsolete = 'N' and active = 'Y' AND username IN('" + username.toUpperCase()+"','"+username.toLowerCase()+"')").list();
		if(!getUsername.isEmpty() && getUsername != null) {
			return "AVAILABLE";
		}
		    return "NOTAVAILABLE";
	}

	@Override
	@Transactional
	public SignupModel getSignupId(int id) {
		String hql = "FROM SignupModel WHERE obsolete = 'N' and client_id = " +id+ "";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<SignupModel> signupList = (List<SignupModel>) query.list();
		if (signupList != null && !signupList.isEmpty()){
			return signupList.get(0);
		}
		return null;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public SignupModel findByUsername(String username) {
		List<SignupModel> findUser = new ArrayList<SignupModel>();
		findUser = sessionFactory.getCurrentSession().createQuery("from SignupModel where username=? AND obsolete = 'N'").setParameter(0, username).list();
		System.out.println("mmmmmmmmmmmmmmmmmm"+findUser);
		
		if(findUser.size() > 0) 
		{
			return findUser.get(0);
		} else 
		{
			return null;
		}		
	}

	@Override
	@Transactional
	public int maxid() {
		
		String hql ="select max(client_id) from SignupModel";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return ((Number) query.uniqueResult()).intValue();
	}

	


}
