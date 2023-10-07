
package com.cookyplan.Cooky.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cookyplan.Cooky.entity.Category;
import com.cookyplan.Cooky.entity.Foods;


@Repository
public class CategoryDAO {
	@Autowired
	SessionFactory factory;
	@SuppressWarnings("unchecked")
	
	public List<Category> findAll() {
		Session session = factory.getCurrentSession();
		List<Category> list = session.createQuery("FROM Category").list();
//		System.out.print("hello"+list);
		return list;
	}
	
	public Category findById(Integer id) {
		Session session = factory.getCurrentSession();
		Category entity = session.find(Category.class, id);
		return entity;
	}
	
	public Category create(Category entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}
	
	public void update(Category entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}
	
	public Category delete(Integer id) {
		Session session = factory.getCurrentSession();
		Category entity = session.find(Category.class, id);
		session.delete(entity);
		return entity;
	}
	
//	public List<Category> getRandoms() {
//		String hql = "FROM Category c WHERE size(c.products) >= 4";
//		Session session = sessionFactory.getCurrentSession();
//		TypedQuery<Category> query = session.createQuery(hql, Category.class);
//		List<Category> list = query.getResultList();
//		Collections.shuffle(list);
//		list = list.subList(0, 4);
//		list.forEach(c -> {
//			List<Foods> foods = (List<Foods>) c.getFoods();
//			Collections.shuffle(foods);
//			c.setFoods(foods.subList(0, 4));
//		});
//		return list;
//	}
	
}
