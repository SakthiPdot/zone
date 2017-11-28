package com.zone.enter;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PageDaoImpl implements PageDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void saveOrUpdate(PageModel page) {
		sessionFactory.getCurrentSession().saveOrUpdate(page);		
	}

}
