package com.cookyplan.Cooky.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cookyplan.Cooky.entity.FoodDetails;

@Repository
public class FoodDetailsDAO {
	@Autowired
	SessionFactory factory;
	@SuppressWarnings("unchecked")
	
	public List<FoodDetails> findAll(){
		Session session = factory.getCurrentSession();
		List<FoodDetails> list = session.createQuery("FROM FoodDetails").list();
		return list;
	}
	
	public FoodDetails findById(Integer id) {
		Session session = factory.getCurrentSession();
		FoodDetails entity = session.find(FoodDetails.class, id);
		return entity;		
	}
	
	public FoodDetails create(FoodDetails entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}
	
	public void update(FoodDetails entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}
	
	public FoodDetails delete(Integer id) {
		Session session = factory.getCurrentSession();
		FoodDetails entity = session.find(FoodDetails.class, id);
		session.delete(entity);
		return entity;
	}
}
