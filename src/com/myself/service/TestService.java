package com.myself.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myself.dao.TestDao;
import com.myself.entity.Student;

@Service
public class TestService {
	
	@Resource
	private TestDao testDao;
	
	@Transactional
	public List<Student> getStudent() {
		return testDao.getStudents();
	}

}
