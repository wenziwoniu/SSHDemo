package com.myself.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myself.dao.ClassDao;
import com.myself.dao.StudentDao;
import com.myself.entity.Classes;
import com.myself.entity.Student;
import com.myself.pojo.CommonQuery;
import com.myself.pojo.PageObject;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private ClassDao classDao;
	
	@Transactional
	public PageObject<Student> findAllStudent(CommonQuery commonQuery, Student student) {
		PageObject<Student> pageObject = studentDao.findAllStudent(commonQuery, student);
		pageObject.setNumPerPage(commonQuery.getNumPerPage());
		pageObject.setPageNum(commonQuery.getPageNum());
		return pageObject;
	}
	
	/**
	 * 功能：保存学生数据
	 * 开发：v_wbzwwang 2016年3月21日 下午4:07:14
	 * @param student
	 */
	@Transactional
	public void saveStudent(Student student, Classes classEntity) {
		studentDao.saveStudent(student);
		classDao.saveClasses(classEntity);
	}
	
	@Transactional
	public Student findStudentById(Long id) {
		return studentDao.findStudentById(id);
	}

}
