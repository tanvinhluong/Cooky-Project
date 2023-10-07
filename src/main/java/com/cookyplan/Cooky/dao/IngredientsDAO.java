package com.cookyplan.Cooky.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cookyplan.Cooky.entity.Ingredients;

@Repository
public class IngredientsDAO {
	@Autowired
	SessionFactory factory;
	@SuppressWarnings("unchecked")
	
	public List<Ingredients> findAll(){
		Session session = factory.getCurrentSession();
		List<Ingredients> list = session.createQuery("FROM Ingredients").list();
		return list;
	}
	
	public Ingredients findById(Integer id) {
		Session session = factory.getCurrentSession();
		Ingredients entity = session.find(Ingredients.class, id);
		return entity;		
	}
	
	public Ingredients create(Ingredients entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}
	
	public void update(Ingredients entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}
	
	public Ingredients delete(Integer id) {
		Session session = factory.getCurrentSession();
		Ingredients entity = session.find(Ingredients.class, id);
		session.delete(entity);
		return entity;
	}
	
}
