package com.myself.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.myself.entity.Student;
import com.myself.pojo.CommonQuery;
import com.myself.pojo.PageObject;
import com.myself.util.StringUtils;

@Repository
public class StudentDao extends HibernateDaoSupport {
	
	
	@SuppressWarnings("unchecked")
	public PageObject<Student> findAllStudent(CommonQuery commonQuery, Student student) {
		
		StringBuilder countString = new StringBuilder("SELECT COUNT(*) FROM STUDENT \n");
		if (StringUtils.isNotBlank(student.getStudentName())) {
			countString.append("WHERE STUDENT_NAME = :studentName");
		}
		Session session = this.getSessionFactory().getCurrentSession();
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
	
	/**
	 * 功能：保存学生数据
	 * 开发：v_wbzwwang 2016年3月21日 下午4:06:23
	 * @param student
	 */
	public void saveStudent(Student student) {
		Session session = this.getSessionFactory().getCurrentSession();
		session.save(student);
	}
	
	public void updateStudent(Student student) {
		Session session = this.getSessionFactory().getCurrentSession();
		Student student2 = (Student) session.merge(student);
	}
	
	public void deleteStudent(String id) {
		Session session = this.getSessionFactory().getCurrentSession();
		String sqlString = "DELETE FROM STUDENT WHERE ID = :id";
		Query query = session.createSQLQuery(sqlString);
		query.setParameter("id", id);
		query.executeUpdate();
	}
	
	public Student findStudentById(Long id) {
		Session session = this.getSessionFactory().getCurrentSession();
		String sqlString = "SELECT * FROM STUDENT WHERE ID = :id";
		Query query = session.createSQLQuery(sqlString);
		query.setParameter("id", id);
		Object object = query.uniqueResult();
		Object[] objects = (Object[]) object;
		Student students = new Student();
		students.setId(Long.parseLong(objects[0].toString()));
		students.setStudentName(objects[1].toString());
		students.setOptlock(Integer.parseInt(objects[2].toString()));
		return students;
	}



}
