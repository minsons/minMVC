package com.minsons.minmvc.demo;

import com.minsons.minmvc.config.Render;
import com.minsons.minmvc.controller.Controller;

public class UserController extends Controller{

	
	//首页的处理
	public Render index(){
		
		Render render=new Render();
		render.RenderJSP("ok","real is success? yes of course成功了","success.jsp");
		System.out.println("index deal success 成功了！ ");
		return render;
	}
	
	
	//业务表单请求
	public Render dealAdd(){
			
			Render render=new Render();
			render.RenderJSP("ok","this is biaodan test!成功了","dealAdd.jsp");
			System.out.println("index deal success 成功了！ ");
			return render;
		}
	
}
