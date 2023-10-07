package com.cookyplan.Cooky.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cookyplan.Cooky.entity.Favorite;

@Repository
public class FavoriteDAO {
	@Autowired
	SessionFactory factory;
	@SuppressWarnings("unchecked")
	
	public List<Favorite> findAll(){
		Session session = factory.getCurrentSession();
		List<Favorite> list = session.createQuery("FROM Favorite").list();
		return list;
	}
	
	public Favorite findById(Integer id) {
		Session session = factory.getCurrentSession();
		Favorite entity = session.find(Favorite.class, id);
		return entity;		
	}
	
	public Favorite create(Favorite entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}
	
	public void update(Favorite entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}
	
	public Favorite delete(Integer id) {
		Session session = factory.getCurrentSession();
		Favorite entity = session.find(Favorite.class, id);
		session.delete(entity);
		return entity;
	}
}
