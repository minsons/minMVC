package com.minsons.minmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.pool.impl.GenericKeyedObjectPool.Config;

public abstract class Controller {

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private String urlPara;
	private String[] urlParaArray;
	
	void init(HttpServletRequest request, HttpServletResponse response, String urlPara) {
		this.request = request;
		this.response = response;
		this.urlPara = urlPara;
	}
	
	void init(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	/**
	 * 设置参数
	 * @param name
	 * @param value
	 * @return
	 */
	public Controller setAttr(String name, Object value) {
		request.setAttribute(name, value);
		return this;
	}
	/**
	 * 获取请求参数
	 * @param name
	 * @return
	 */
	public String getPara(String name) {
		return request.getParameter(name);
	}
	
	
}
