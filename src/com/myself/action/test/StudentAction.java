package com.myself.action.test;

import org.springframework.beans.factory.annotation.Autowired;

import com.myself.entity.Classes;
import com.myself.entity.Student;
import com.myself.pojo.CommonQuery;
import com.myself.pojo.PageObject;
import com.myself.pojo.ResponseData;
import com.myself.service.StudentService;
import com.myself.util.StringUtils;

@SuppressWarnings("serial")
public class StudentAction extends BaseStruts2Action {
	
	@Autowired
	private StudentService studentService;
	
	private Student student;
	
	private ResponseData closeDialog = ResponseData.CLOSE_DIALOG;
	
	private ResponseData closeNavTab = ResponseData.CLOSE_NAVTAB;
	
	private ResponseData noCloseNavTab = ResponseData.NO_CLOSE_NAVTAB;
	
	private ResponseData success = ResponseData.SUCCESS;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	public String redirect() {
		CommonQuery commonQuery = new CommonQuery();
		String studentName = getRequest().getParameter("studentName");
		String pageNum = getRequest().getParameter("pageNum");
		if (StringUtils.isNotBlank(pageNum)) {
			commonQuery.setPageNum(Integer.parseInt(pageNum));
		}
		Student student = new Student();
		student.setStudentName(studentName);
		PageObject<Student> pageObject = new PageObject<Student>();
		if (commonQuery.getNumPerPage() < 1) {
			commonQuery.setNumPerPage(5);
		}
		pageObject = studentService.findAllStudent(commonQuery, student);
		getRequest().setAttribute("pages", pageObject);
		getRequest().setAttribute("query", student);
		return "success";
	}
	
	/**
	 * 功能：保存学生数据
	 * 开发：v_wbzwwang 2016年3月21日 下午4:07:54
	 * @return
	 */
	public String saveStudent() {
//		Student student = new Student();
//		String studentName = getRequest().getParameter("studentName");
//		String optlock = getRequest().getParameter("optlock");
//		student.setStudentName(studentName);
//		student.setOptlock(Integer.parseInt(optlock));
		
		Classes classes = new Classes();
		classes.setClassName("cekong");
		studentService.saveStudent(student, classes);
		getRequest().setAttribute("reponseData", closeDialog);
		return "success";
	}
	
	public String editStudent() {
		String id = getRequest().getParameter("id");
		Student student = studentService.findStudentById(Long.parseLong(id));
		getRequest().setAttribute("student", student);
		return "success";
	}
	
	public String updateStudent() {
		studentService.updateStudent(student);
		closeDialog.setRel("box");
		getRequest().setAttribute("reponseData", closeDialog);
		return "success";
	}
	
	public String deleteStudent() {
		String id = getRequest().getParameter("ids");
		studentService.deleteStudent(id);
		getRequest().setAttribute("reponseData", success);
		return "success";
	}

}
