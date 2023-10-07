package com.cookyplan.Cooky.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cookyplan.Cooky.entity.Role;

@Repository
public class RoleDAO {
	@Autowired
	SessionFactory factory;
	@SuppressWarnings("unchecked")
	
	public List<Role> findAll(){
		Session session = factory.getCurrentSession();
		List<Role> list = session.createQuery("FROM Role").list();
		return list;
	}
	
	public Role findById(Integer id) {
		Session session = factory.getCurrentSession();
		Role entity = session.find(Role.class, id);
		return entity;		
	}
	
	public Role create(Role entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}
	
	public void update(Role entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}
	
	public Role delete(Integer id) {
		Session session = factory.getCurrentSession();
		Role entity = session.find(Role.class, id);
		session.delete(entity);
		return entity;
	}
	
}
