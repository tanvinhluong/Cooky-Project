package com.cookyplan.Cooky.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cookyplan.Cooky.entity.User;

@Repository
public class UserDAO {
	@Autowired
	SessionFactory factory;
	@SuppressWarnings("unchecked")
	
	public List<User> findAll(){
		Session session = factory.getCurrentSession();
		List<User> list = session.createQuery("FROM User").list();
		return list;
	}
	
	public User findById(Integer id) {
		Session session = factory.getCurrentSession();
		User entity = session.find(User.class, id);
		return entity;		
	}
	
	public User create(User entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}
	
	public void update(User entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}
	
	public User delete(Integer id) {
		Session session = factory.getCurrentSession();
		User entity = session.find(User.class, id);
		session.delete(entity);
		return entity;
	}
}
