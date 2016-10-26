package com.minsons.minmvc.config;

import javax.servlet.ServletContext;

public abstract class MinCofigure {

	/**
	 * 配置常量
	 */
	public void configConstant() {
		
	}
	
	/**
	 * 加载单例类到servletContext中
	 * @param context
	 * @param path
	 */
	public abstract void  AddBeanPath(ServletContext context, String path);
	
	
	/**
	 * 路由请求配置
	 */
	public abstract void RouteConfig();

	public void RouteConfig(Route me) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
