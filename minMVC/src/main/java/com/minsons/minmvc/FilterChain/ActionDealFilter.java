package com.minsons.minmvc.FilterChain;

import java.util.HashMap;
import java.util.Map;

public class ActionDealFilter implements BaseFilter {

	private BaseFilter baseFilter=null;
	@Override
	public boolean execute(Object obj) {
		
		
		Map map=(HashMap)obj;
		
		
		if(!this.baseFilter.execute(obj)){
			return false;
		}
		
		return true;
	}

	@Override
	public void setNextFilter(BaseFilter baseFilter) {
		this.baseFilter=baseFilter;

	}

}
