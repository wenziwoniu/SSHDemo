package com.myself.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.Array;
import org.springframework.stereotype.Repository;

import com.myself.entity.Student;
import com.myself.pojo.CommonQuery;
import com.myself.pojo.PageObject;
import com.myself.util.StringUtils;

@Repository
public class StudentDao {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public PageObject<Student> findAllStudent(CommonQuery commonQuery, Student student) {
		
		StringBuilder countString = new StringBuilder("SELECT COUNT(*) FROM STUDENT \n");
		if (StringUtils.isNotBlank(student.getStudentName())) {
			countString.append("WHERE STUDENT_NAME = :studentName");
		}
		Session session = sessionFactory.getCurrentSession();
		Query countQuery = session.createSQLQuery(countString.toString());
		if (StringUtils.isNotBlank(student.getStudentName())) {
			countQuery.setParameter("studentName", student.getStudentName());
		}
		Long totalCount = Long.parseLong(countQuery.uniqueResult().toString());
		
		StringBuilder sqlString = new StringBuilder("SELECT * FROM STUDENT \n");
		if (StringUtils.isNotBlank(student.getStudentName())) {
			sqlString.append("WHERE STUDENT_NAME = :studentName");
		}
		
		Query query = session.createSQLQuery(sqlString.toString());
		
		if (StringUtils.isNotBlank(student.getStudentName())) {
			query.setParameter("studentName", student.getStudentName());
		}
		query.setFirstResult(commonQuery.getStart());
		query.setMaxResults(commonQuery.getNumPerPage());
		List<Object[]> list = query.list();
		List<Student> students = new ArrayList<Student>();
		Student student2 = null;
		for (Object[] objects : list) {
			student2 = new Student();
			student2.setId(Long.parseLong(objects[0].toString()));
			student2.setStudentName(objects[1].toString());
			student2.setOptlock(Integer.parseInt(objects[2].toString()));
			students.add(student2);
		}
		PageObject<Student> pageObject = new PageObject<Student>();
		pageObject.setTotalCount(totalCount);
		pageObject.setList(students);
		return pageObject;
	}



}
