package com.zone.student;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void saveOrUpdate(StudentModel page) {
		sessionFactory.getCurrentSession().saveOrUpdate(page);		
	}

}
