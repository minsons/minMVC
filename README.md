# minMVC
一个简易的mvc框架，适合轻量级的应用，快速，灵活

****
#使用简介

## 配置
 
 * 创建配置的Java文件，继承于 com.minsons.minmvc.config.MinCofigure
 
 ```
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
 
  ```
  前端控制器 ： me.add("路径"，映射的处理类)
  如果设置是：me.add("/minMVC/minmvc", UserController.class);
  请求路径是 "/minMVC/minmvc/addInfo"
  那么请求的处理就提交到 UserController的addInfo方法里进行处理。
  
  * 配置web.xml 文件
  
  ```
		<servlet>  
		 <!-- 类名 -->  
		<servlet-name>DealAction</servlet-name>  
		<!-- 所在的包 -->  
		<servlet-class>com.minsons.minmvc.controller.AllController</servlet-class> 
		<load-on-startup>0</load-on-startup> 
			<init-param> 
			<param-name>configClass</param-name> 
			<param-value>com.minsons.minmvc.demo.DemoConfig</param-value> 
		</init-param> 
		</servlet>  

		<servlet-mapping>  
		<servlet-name>DealAction</servlet-name>  
		<!-- 访问的网址 -->  
		<url-pattern>/</url-pattern>  
		</servlet-mapping>  
  ```
  com.minsons.minmvc.controller.AllController 是默认的前端控制器，
  com.minsons.minmvc.demo.DemoConfig 是自定义的配置文件
  
 ## 新建控制类及服务
 
 * 创建controller类，需要继承com.minsons.minmvc.controller.Controller
 * 提交模板，默认是jsp，需要在方法中新建 Render进行提交数据到指定的页面
 * 模板的路径可以在 配置文件的常量里配置：constant.addViewPath("/WEB-INF/jsp/");


 ##　注解的支持
 在controller的类或者方法名上加@RequestUrl("/test/index")
 所有uri为“/test/index”的请求就会跳转到该controller进行业务的跳转处理
 
 例如如下：
 ···
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
		
``` 

那么请求路径就为  /test/index2
 
 
 
 
 
 
 
 
 
