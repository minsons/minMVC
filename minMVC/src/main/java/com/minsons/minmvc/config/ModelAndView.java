package com.minsons.minmvc.config;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {

	
	public HashMap<String,Object> mapcontent=new HashMap<String,Object>();
	
	public String viewPath=null;
	public String templateType=null;
	
	
	
	public Map getMapContent(){
		return mapcontent;
	}
	
	public void addAttrible(String attribute , Object ojb){
		mapcontent.put(attribute, ojb);
	}

	public String getViewPath() {
		return viewPath;
	}

	public void setViewPath(String viewPath) {
		this.viewPath = viewPath;
	}

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}
	
	
	
	
	
}
