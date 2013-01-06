package com.hl.up.core.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;

/**
 * 系统上下文类，主要有以下用处：
 * ·系统启动后做一些初始化工作；
 * ·注入了spring的ApplicationContext，可以方便地获取spring容器中的对象
 * ·提供了保存和获取当前用户登陆信息的方法
 * ·提供了获取request和资源绝对路径的方法
 * @author liaopeng2008@gmail.com
 * @since 2011-12-20
 */
public class AppContext {
	
	/**
	 * 在session中保存用户登陆信息的属性名
	 */
	
	private static WebApplicationContext applicationContext;
	static ThreadLocal<HttpServletRequest> request = new ThreadLocal<HttpServletRequest>();
	static ThreadLocal<HttpServletResponse> response = new ThreadLocal<HttpServletResponse>();
	
	/**
	 * 系统的初始化工作，此方法在DispatcherServlet中调用
	 */
	static void init(WebApplicationContext applicationContext){
		AppContext.applicationContext = applicationContext;
		
	}

	/**
	 * 获取spring容器中的对象, 自动转型为所赋值对象的类型.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		return (T) applicationContext.getBean(name);
	}

	/**
	 * 获取spring容器中的对象, 自动转型为所赋值对象的类型.
	 */
	public static <T> T getBean(Class<T> requiredType) {
		return applicationContext.getBean(requiredType);
	}
	
	
	/**
	 * 获取Http request对象
	 */
	public static HttpServletRequest getRequest(){
		return request.get();
	}
	
	/**
	 * 获取Http response对象
	 */
	public static HttpServletResponse getResponse(){
		return response.get();
	}

	/**
	 * 将系统中的相对路径转换为绝对路径
	 */
	public static String getWebRealPath(String path){
		return applicationContext.getServletContext().getRealPath(path);
	}
}
