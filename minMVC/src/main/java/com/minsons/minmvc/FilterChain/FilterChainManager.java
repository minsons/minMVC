package com.minsons.minmvc.FilterChain;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

/**
 * 过滤链处理拦截
 * @author ouyang
 *
 */
public class FilterChainManager {
	
	HttpServletRequest request=null;
	public FilterChainManager(){
		
	}
    public FilterChainManager(HttpServletRequest request){
		this.request=request;
	}

	public ArrayList<BaseFilter> filters=new ArrayList<BaseFilter>();
	
	
	public void doChain(){
		
		for(int i=0;i<filters.size()-1;i++){
			filters.get(i).setNextFilter(filters.get(i+1));
		}
		
		filters.get(0).execute(this);
	}
	
	public void doNextChain(){
		
	}
	
	
	public ArrayList<BaseFilter> add(BaseFilter baseFilter){
		 filters.add(baseFilter);
		 return filters;
	}
	
	
	
}
