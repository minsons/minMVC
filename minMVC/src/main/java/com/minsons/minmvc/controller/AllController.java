package com.minsons.minmvc.controller;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minsons.minmvc.FilterChain.ActionDealFilter;
import com.minsons.minmvc.FilterChain.FilterChainManager;
import com.minsons.minmvc.FilterChain.PathResolveFilter;
import com.minsons.minmvc.config.ConstantConfig;
import com.minsons.minmvc.config.MinCofigure;
import com.minsons.minmvc.config.ReflactRoute;
import com.minsons.minmvc.config.Route;
import com.minsons.minmvc.config.annotation.RequestUrl;
import com.minsons.minmvc.config.util.FileUtils;

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
				
				configure.configConstant(ConstantConfig.getInstance());
				
				//this.getServletContext().setAttribute("viewPath", ConstantConfig.getConstantAttribute(ConstantConfig.VIEWPATH));

				String bathPath=this.getClass().getResource("/").getPath();
				
				List<String> allClasses=FileUtils.ApadatePatg(bathPath);
			
				for(String sou:allClasses){
					
					String strbat="";
					try {  
			            //实例化Class类对象 一般推荐此方式  
			            Class  demo = Class.forName(sou);
			            
			            //获取class类上的注解
			            if(demo.isAnnotationPresent(RequestUrl.class)){
			            	RequestUrl annotation = (RequestUrl) demo.getAnnotation( RequestUrl.class );
			            	strbat=annotation.value();
			            	System.out.println("the base root:"+strbat);
			            }
			            //获取method上的注解
			            Method[] methods = demo.getDeclaredMethods();  
			            for (Method method : methods) {  
			                if (method.isAnnotationPresent(RequestUrl.class)) {  
			                    Annotation p = method.getAnnotation(RequestUrl.class);  
			                    Method m = p.getClass()  
			                            .getDeclaredMethod("value", null);
			                    
			                    String value = (String) m.invoke(p, null);  
			                   // for (String key : values) {    这里是单个注解值不能用数组
			                        System.out.println(m.getName()+":注解值 === " + value);  
			                        
			                        ReflactRoute routefa=new ReflactRoute();
			                        routefa.setClassName(demo.getName());
			                        routefa.setMethodName(method.getName());
			                        routefa.setClassObj(demo);
			                        System.out.println(strbat+value+":"+demo.getName()+":"+method.getName());
			                       Route.addRouteReflact("/minMVC"+strbat+value, routefa);
			                   // }  
			                }  
			            }  
			            
			            
			        } catch (Exception e) {  
			            e.printStackTrace();  
			        }  
					
				}
				
				
				
				
				
		 
		} 
	
	     // 处理 GET 方法请求的方法
		  public void doGet(HttpServletRequest request,
		                    HttpServletResponse response)
		            throws ServletException, IOException
		  {
		    
			  request.setCharacterEncoding("UTF-8");
			  response.setContentType("text/html;charset=UTF-8");
			  FilterChainManager filterchains=new FilterChainManager(request,response);
			  
			  System.out.println(request.getRequestURI());
			  
			  filterchains.add(new PathResolveFilter());
			  filterchains.add(new ActionDealFilter());
			  filterchains.doChain();
			  
			 // request.getRequestDispatcher("url").forward(request, response);
			  
			  
			  
		  }
		  
		  
		  
		  
		  

		  // 处理 POST 方法请求的方法
		  public void doPost(HttpServletRequest request,
		                     HttpServletResponse response)
		      throws ServletException, IOException {
		     doGet(request, response);
		  }
	
	
	
	
	
	
	
	
}
