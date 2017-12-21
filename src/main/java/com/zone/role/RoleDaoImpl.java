package com.zone.role;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoleDaoImpl implements RoleDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	@Transactional
	public List<RoleModel> list() {
		@SuppressWarnings("unchecked")
		List<RoleModel> listRole = (List<RoleModel>) sessionFactory.getCurrentSession()
				.createQuery("from RoleModel where obsolete = 'N' and active = 'Y'").list();
		return listRole;
	}

}
