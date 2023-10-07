package com.cookyplan.Cooky.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cookyplan.Cooky.entity.Account;


@Repository
public class AccountDAO {
	
	@Autowired
	SessionFactory factory;
//	@SuppressWarnings("unchecked")
	
	public List<Account> findAll(){
		String hql="FROM Order";
		Session session = factory.getCurrentSession();
		TypedQuery<Account> query = session.createQuery(hql,Account.class);
		List<Account> list = query.getResultList();
		return list;
	}
	
	public Account findById(Integer id) {
		Session session = factory.getCurrentSession();
		Account entity = session.find(Account.class, id);
		return entity;		
	}
	
	public Account create(Account entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}
	
	public void update(Account entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}
	
	public Account delete(Integer id) {
		Session session = factory.getCurrentSession();
		Account entity = session.find(Account.class, id);
		session.delete(entity);
		return entity;
	}
	
}
