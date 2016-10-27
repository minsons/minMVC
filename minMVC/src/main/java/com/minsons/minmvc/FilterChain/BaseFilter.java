package com.minsons.minmvc.FilterChain;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BaseFilter {
	
	
	public void execute(Object obj );
	
	public void setNextFilter(BaseFilter baseFilter);

}
