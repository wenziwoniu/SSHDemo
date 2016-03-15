package com.myself.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.myself.entity.Student;

@Repository
public class TestDao {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@SuppressWarnings({ "unchecked"})
	public List<Student> getStudents() {
//		List<Student> list = getHibernateTemplate().execute(
//			new HibernateCallback() {
//				@Override
//				public Object doInHibernate(Session session) throws HibernateException,
//						SQLException {
//					String sqlString = "SELECT * FROM STUDENT";
//					Query query = session.createSQLQuery(sqlString);
//					List<Student> list = query.list();
//					return list;
//				}
//				
//			});
		Session session = sessionFactory.getCurrentSession();
		String sqlString = "SELECT * FROM STUDENT";
		Query query = session.createSQLQuery(sqlString);
		List<Object[]> list = query.list();
		for (Object[] object : list) {
			System.out.println(object[0].toString());
		}
		return null;
	}

}
