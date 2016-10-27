package com.minsons.minmvc.demo;

import java.util.Map;

import javax.servlet.ServletContext;

import com.minsons.minmvc.config.ConstantConfig;
import com.minsons.minmvc.config.MinCofigure;
import com.minsons.minmvc.config.Route;

public class DemoConfig extends MinCofigure{


	/**
	 * 配置常量
	 */
	public void configConstant(ConstantConfig constant){
		constant.addViewPath("/WEB-INF/jsp/");
	}
		
	
	@Override
	public void AddBeanPath(ServletContext context, String path) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 前端控制器，路由规则
	 */
	public void RouteConfig(Route me) {
		me.add("/minMVC/minmvc", UserController.class);
		
	}

	@Override
	public void RouteConfig() {
		// TODO Auto-generated method stub
		
	}


	
	
	
}
