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
	public void execute(Object content) {
	
		System.out.println("do path Resolve... ...");
		
		FilterChainManager filters=(FilterChainManager)content;
		
		HttpServletRequest request=filters.request;
		String  uri= request.getRequestURI();
		
		System.out.println(uri);
		
	     Map map= Route.getAdaptMapByKey(uri);
	     filters.getChainObje().put("uriResovle", map);
	     
		this.baseFilter.execute(content);
		
		
	}

	@Override
	public void setNextFilter(BaseFilter baseFilter) {
		this.baseFilter=baseFilter;

	}

}
