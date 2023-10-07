package com.cookyplan.Cooky.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cookyplan.Cooky.entity.CategoryDetails;

@Repository
public class CategoryDetailsDAO {
	@Autowired
	SessionFactory factory;
	@SuppressWarnings("unchecked")
	
	public List<CategoryDetails> findAll(){
		Session session = factory.getCurrentSession();
		List<CategoryDetails> list = session.createQuery("FROM CategoryDetails").list();
		return list;
	}
	
	public CategoryDetails findById(Integer id) {
		Session session = factory.getCurrentSession();
		CategoryDetails entity = session.find(CategoryDetails.class, id);
		return entity;		
	}
	
	public CategoryDetails create(CategoryDetails entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}
	
	public void update(CategoryDetails entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}
	
	public CategoryDetails delete(Integer id) {
		Session session = factory.getCurrentSession();
		CategoryDetails entity = session.find(CategoryDetails.class, id);
		session.delete(entity);
		return entity;
	}
}
