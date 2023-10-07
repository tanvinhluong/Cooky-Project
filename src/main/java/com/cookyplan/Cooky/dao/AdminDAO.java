package com.cookyplan.Cooky.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cookyplan.Cooky.entity.Admin;

@Repository
public class AdminDAO {
	@Autowired
	SessionFactory factory;
	@SuppressWarnings("unchecked")
	
	public List<Admin> findAll(){
		Session session = factory.getCurrentSession();
		List<Admin> list = session.createQuery("FROM Admin").list();
		return list;
	}
	
	public Admin findById(Integer id) {
		Session session = factory.getCurrentSession();
		Admin entity = session.find(Admin.class, id);
		return entity;		
	}
	
	public Admin create(Admin entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}
	
	public void update(Admin entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}
	
	public Admin delete(Integer id) {
		Session session = factory.getCurrentSession();
		Admin entity = session.find(Admin.class, id);
		session.delete(entity);
		return entity;
	}
}
