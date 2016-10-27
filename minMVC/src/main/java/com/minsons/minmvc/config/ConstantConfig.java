package com.minsons.minmvc.config;

import java.util.HashMap;
import java.util.Map;

public class ConstantConfig {

	public final static String VIEWPATH="viewPath";
	
	private static Map<String , Object> constantMap=new HashMap<String,Object>();
	
	private static  ConstantConfig instance=new ConstantConfig();
	
	public static void addViewPath(String path){
		constantMap.put(VIEWPATH, path);
	}
	
	
	public static Object getConstantAttribute(String key){
		return constantMap.get(key);
	}
	
	public static ConstantConfig getInstance(){
		
		if(instance!=null ){
			return instance;
		}else{
			return new ConstantConfig();
		}
	}
}
