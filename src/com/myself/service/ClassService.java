package com.myself.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myself.dao.ClassDao;

@Service
public class ClassService {
	
	@Autowired
	private ClassDao classDao;

}
