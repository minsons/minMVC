package com.minsons.minmvc.config;

import java.util.Map;

public class Render extends ModelAndView {

	
	public Render(){
		
	}
	
	public  Render  RenderJSP(){
		this.templateType="jsp";
		return this;
	}
	
	public Render  RenderFreeMarker(){
		this.templateType="freeMarker";
		return this;
	}
	
	public Render  RenderJSP(Map map){
		addAttrible("data", map);
		this.templateType="jsp";
		return this;
	}
	
	public Render  RenderJSP(String key,Object obj){
		addAttrible(key, obj);
		this.templateType="jsp";
		return this;
	}
	public Render  RenderJSP(String key,Object obj,String viewPath){
		addAttrible(key, obj);
		this.templateType="jsp";
		this.viewPath=viewPath;
		return this;
	}
	
	public Map getMapDate(){
		return this.mapcontent;
	}
}
