package com.minsons.minmvc.config;

public class ReflactRoute {

	private Class classObj ;
	private String ClassName;
	private String methodName;
	
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Class getClassObj() {
		return classObj;
	}
	public void setClassObj(Class classObj) {
		this.classObj = classObj;
	}
	
	
	
	
	
}
