package com.minsons.minmvc.demo;

import com.minsons.minmvc.config.Render;
import com.minsons.minmvc.config.annotation.RequestUrl;
import com.minsons.minmvc.controller.Controller;

@RequestUrl("/test")
public class TestController extends Controller {

	
	  //首页的处理
	  @RequestUrl("/index2")
		public Render index(){
			
			Render render=new Render();
			render.RenderJSP("ok","real is success? yes of course成功了","success.jsp");
			System.out.println("index deal success 成功了！ ");
			return render;
		}
		
		
		//业务表单请求
	  @RequestUrl("/add")
		public Render dealAdd(){
				Render render=new Render();
				render.RenderJSP("ok","this is biaodan test!成功了","dealAdd.jsp");
				System.out.println("index deal success 成功了！ ");
				return render;
			}
	
	
	
}
