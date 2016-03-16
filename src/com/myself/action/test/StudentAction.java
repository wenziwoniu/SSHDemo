package com.myself.action.test;

import org.springframework.beans.factory.annotation.Autowired;

import com.myself.entity.Student;
import com.myself.pojo.CommonQuery;
import com.myself.pojo.PageObject;
import com.myself.service.StudentService;
import com.myself.util.StringUtils;

@SuppressWarnings("serial")
public class StudentAction extends BaseStruts2Action {
	
	@Autowired
	private StudentService studentService;
	
	
	public String redirect() {
		CommonQuery commonQuery = new CommonQuery();
		String pageNum = getRequest().getParameter("pageNum");
		if (StringUtils.isNotBlank(pageNum)) {
			commonQuery.setPageNum(Integer.parseInt(pageNum));
		}
		Student student = new Student();
		PageObject<Student> pageObject = new PageObject<Student>();
		if (commonQuery.getNumPerPage() < 1) {
			commonQuery.setNumPerPage(5);
		}
		pageObject = studentService.findAllStudent(commonQuery, student);
		getRequest().setAttribute("pages", pageObject);
		getRequest().setAttribute("query", student);
		return "success";
	}
	
	public String saveStudent() {
		return "success";
	}

}
