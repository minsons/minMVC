package com.minsons.minmvc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.minsons.minmvc.config.Route;
import com.minsons.minmvc.demo.DemoConfig;

public class MinContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("系统已经注销了！");

	}

	@Override
	public void contextInitialized(ServletContextEvent context) {

		Route route=Route.getInstance();
		
	}

}
