package com.minsons.minmvc.FilterChain;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minsons.minmvc.config.ConstantConfig;
import com.minsons.minmvc.config.Render;

public class ActionDealFilter implements BaseFilter {

	private BaseFilter baseFilter=null;
	@Override
	public void execute(Object obj) {
		

		FilterChainManager filters=(FilterChainManager)obj;
		Map map=(HashMap)filters.getChainObje().get("uriResovle");
		
		Class clazz=(Class)map.get("actionClass");
		  try {
			Method m1 = clazz.getDeclaredMethod((String)map.get("method"));
			Object controller=clazz.newInstance();
            Render msg = (Render) m1.invoke(controller);

            HttpServletRequest request=filters.request;
            HttpServletResponse response=filters.response;
            
            
            for (String key:msg.mapcontent.keySet()) {  
                request.setAttribute(key, msg.mapcontent.get(key));
            }  
          
            String viewjsp=ConstantConfig.getConstantAttribute(ConstantConfig.VIEWPATH)+msg.viewPath;
            System.out.println(viewjsp);
			request.getRequestDispatcher(viewjsp)
			.forward(request, response);
	
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public void setNextFilter(BaseFilter baseFilter) {
		this.baseFilter=baseFilter;

	}

}
