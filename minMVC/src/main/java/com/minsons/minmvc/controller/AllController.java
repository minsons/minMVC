package com.minsons.minmvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minsons.minmvc.FilterChain.FilterChainManager;
import com.minsons.minmvc.config.MinCofigure;
import com.minsons.minmvc.config.Route;

@SuppressWarnings("serial")
public class AllController extends HttpServlet {
	   private MinCofigure configure;
	
	   //初始化servlet配置信息
	   public void init() throws ServletException{ 
		        String classname = this.getInitParameter("configClass");
		        Class classType;
				try {
					classType = Class.forName(classname);
					Object obj = classType.newInstance();
					configure =(MinCofigure)obj;
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Route route=Route.getInstance();
				//预加载控制器路由
				configure.RouteConfig(route);
		 
		} 
	
	     // 处理 GET 方法请求的方法
		  public void doGet(HttpServletRequest request,
		                    HttpServletResponse response)
		            throws ServletException, IOException
		  {
		    
			  FilterChainManager filterchains=new FilterChainManager(request);
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
		  }
		  
		  
		  
		  
		  

		  // 处理 POST 方法请求的方法
		  public void doPost(HttpServletRequest request,
		                     HttpServletResponse response)
		      throws ServletException, IOException {
		     doGet(request, response);
		  }
	
	
	
	
	
	
	
	
}
