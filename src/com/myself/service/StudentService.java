package com.myself.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myself.dao.StudentDao;
import com.myself.entity.Student;
import com.myself.pojo.CommonQuery;
import com.myself.pojo.PageObject;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	@Transactional
	public PageObject<Student> findAllStudent(CommonQuery commonQuery, Student student) {
		PageObject<Student> pageObject = studentDao.findAllStudent(commonQuery, student);
		pageObject.setNumPerPage(commonQuery.getNumPerPage());
		pageObject.setPageNum(commonQuery.getPageNum());
		return pageObject;
	}

}
