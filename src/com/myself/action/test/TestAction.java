package com.myself.action.test;

import java.util.List;

import javax.annotation.Resource;

import com.myself.entity.Student;
import com.myself.service.TestService;


public class TestAction {
	
	@Resource
	private TestService testService;
	
	public void test() {
		List<Student> list = testService.getStudent();
	}
}
