
package com.cookyplan.Cooky.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cookyplan.Cooky.entity.Category;

@Repository
public class CategoryDAO {
	@Autowired
	SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public List<Category> getAllCategory() {
		Session session = sessionFactory.getCurrentSession();
		List<Category> list = session.createQuery("FROM Category").list();
		return list;
	}
}
