package com.cookyplan.Cooky.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cookyplan.Cooky.entity.Foods;

@Repository
public class FoodsDAO {
	@Autowired
	SessionFactory factory;
	@SuppressWarnings("unchecked")
	
	public List<Foods> findAll(){
		Session session = factory.getCurrentSession();
		List<Foods> list = session.createQuery("FROM Foods").list();
		return list;
	}
	
	public Foods findById(Integer id) {
		Session session = factory.getCurrentSession();
		Foods entity = session.find(Foods.class, id);
		return entity;		
	}
	
	public Foods create(Foods entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}
	
	public void update(Foods entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}
	
	public Foods delete(Integer id) {
		Session session = factory.getCurrentSession();
		Foods entity = session.find(Foods.class, id);
		session.delete(entity);
		return entity;
	}
	
}
