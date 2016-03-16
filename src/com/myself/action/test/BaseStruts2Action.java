package com.myself.action.test;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public abstract class BaseStruts2Action extends ActionSupport implements RequestAware {
	
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
	}

}
