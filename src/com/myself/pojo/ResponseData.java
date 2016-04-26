package com.myself.pojo;

public class ResponseData {
	
	public static final ResponseData CLOSE_DIALOG = new ResponseData("200", "", "", "closeCurrent", "", "保存成功!");
	
	public static final ResponseData CLOSE_NAVTAB = new ResponseData("200", "", "", "closeCurrent", "", "保存成功!");
	
	public static final ResponseData NO_CLOSE_NAVTAB = new ResponseData("200", "", "", "", "", "保存成功!");
	
	public static final ResponseData SUCCESS = new ResponseData("200", "", "", "", "", "");
	
	private String statusCode;
	private String navTabId;
	private String rel;
	private String callbackType;
	private String forwardUrl;
	private String message;
	
	
	
	
	public ResponseData(String statusCode, String navTabId, String rel, String callbackType,
			String forwardUrl, String message) {
		super();
		this.statusCode = statusCode;
		this.navTabId = navTabId;
		this.rel = rel;
		this.callbackType = callbackType;
		this.forwardUrl = forwardUrl;
		this.message = message;
	}
	
	/**
	 * @return the navTabId
	 */
	public String getNavTabId() {
		return navTabId;
	}
	/**
	 * @param navTabId the navTabId to set
	 */
	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}
	/**
	 * @return the rel
	 */
	public String getRel() {
		return rel;
	}
	/**
	 * @param rel the rel to set
	 */
	public void setRel(String rel) {
		this.rel = rel;
	}
	/**
	 * @return the callbackType
	 */
	public String getCallbackType() {
		return callbackType;
	}
	/**
	 * @param callbackType the callbackType to set
	 */
	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}
	/**
	 * @return the forwardUrl
	 */
	public String getForwardUrl() {
		return forwardUrl;
	}
	/**
	 * @param forwardUrl the forwardUrl to set
	 */
	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	

}
