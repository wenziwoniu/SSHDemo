package com.myself.action.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.myself.entity.Student;
import com.myself.service.TestService;


public class TestAction {
	
	@Autowired
	private TestService testService;
	
	@SuppressWarnings("unused")
	public void test() {
		List<Student> list = testService.getStudent();
	}
	
	public String redirect() {
		return "success";
	}
}
