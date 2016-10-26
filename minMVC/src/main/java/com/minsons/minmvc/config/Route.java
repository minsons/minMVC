package com.minsons.minmvc.config;

import java.util.HashMap;
import java.util.Map;

import com.minsons.minmvc.controller.Controller;
/**
 * controller 的路由规则
 * @author ouyang
 *
 */
public class Route {
	
	
	private static Map<String, Class<? extends Controller>> map = new HashMap<String, Class<? extends Controller>>();
	
	private static Route single=null;
	private  Route(){
		
	}
	
	/**
	 * 添加路由规则
	 * @param controllerKey
	 * @param controllerClass
	 * @return
	 */
	public Route add(String controllerKey,Class<? extends Controller> controllerClass) {
		if (controllerKey == null)
			throw new IllegalArgumentException("The controllerKey can not be null");
		// if (controllerKey.indexOf(".") != -1)
			// throw new IllegalArgumentException("The controllerKey can not contain dot character: \".\"");
		controllerKey = controllerKey.trim();
		if ("".equals(controllerKey))
			throw new IllegalArgumentException("The controllerKey can not be blank");
		if (controllerClass == null)
			throw new IllegalArgumentException("The controllerClass can not be null");
		if (!controllerKey.startsWith("/"))
			controllerKey = "/" + controllerKey;
		if (map.containsKey(controllerKey))
			throw new IllegalArgumentException("The controllerKey already exists: " + controllerKey);
		
		map.put(controllerKey, controllerClass);
		
		
		return this;
	}
	
	/**
	 * 获取控制类
	 * @param key
	 * @return
	 */
	public  Class getRouteByKey(String key){
		return map.get(key);
	}
	
	
	//获取实例变量
	public  static  Route  getInstance(){
		if(single==null){
			single=new Route();
		}
		return single;
	}
	
	//通过字符串匹配
	public static  Class getAdaptByKey(String uri){
		
		for(String key : map.keySet()){
			if(uri.startsWith(key)){
				return map.get(key);
			}
		}
		return null; 
	}
	
	//通过字符串匹配
	  public static  Map getAdaptMapByKey(String uri){
			
		   HashMap<String ,Object> mapContent=new HashMap<String ,Object>();
		  
			for(String key : map.keySet()){
				if(uri.startsWith(key)){
					mapContent.put("actionClass",map.get(key));
					mapContent.put("method",uri.substring(key.length()+1, uri.length()));
				}
			}
			return null; 
		}
	
	

}
