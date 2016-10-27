package com.minsons.minmvc.FilterChain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 过滤链处理拦截
 * @author ouyang
 *
 */
public class FilterChainManager {
	
	public HttpServletRequest request=null;
	public HttpServletResponse response =null;
	
	public Map chainObje=null ;
	
	public FilterChainManager(){
		chainObje=new HashMap<String , Object>();
	}
    public Map getChainObje() {
		return chainObje;
	}
	public void setChainObje(Map chainObje) {
		this.chainObje = chainObje;
	}
	
	public Object getChainObjAttribute(String key){
		return chainObje.get(key);
	}
	
	public void setChainObjAttribute(String key,Object obj){
		 chainObje.put(key, obj);
	}
	
	public FilterChainManager(HttpServletRequest request,HttpServletResponse response ){
		this.request=request;
		this.response=response;
		chainObje=new HashMap<String , Object>();
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
