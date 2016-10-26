package com.minsons.minmvc.FilterChain;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.minsons.minmvc.config.Route;

/**
 * 请求路径解析，处理操作
 * @author ouyang
 *
 */
public class PathResolveFilter implements BaseFilter {

	
	private BaseFilter baseFilter=null;
	@Override
	public boolean execute(Object content) {
	
		System.out.println("do path Resolve... ...");
		
		HttpServletRequest request=(HttpServletRequest)content;
		String  uri= request.getRequestURI();
		
		System.out.println(uri);
		
	     Map map= Route.getAdaptMapByKey(uri);
		
		
		if(!this.baseFilter.execute(map)){
			return false;
		}
		
		return true;
	}

	@Override
	public void setNextFilter(BaseFilter baseFilter) {
		this.baseFilter=baseFilter;

	}

}
