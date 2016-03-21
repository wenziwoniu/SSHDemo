package com.myself.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.myself.entity.Classes;

@Repository
public class ClassDao {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void saveClasses(Classes classEntity) {
		Session session = sessionFactory.getCurrentSession();
		session.save(classEntity);
	}

}
