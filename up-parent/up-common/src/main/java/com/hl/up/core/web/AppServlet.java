package com.hl.up.core.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 扩展Spring mvc的DispatcherServlet，在初始化和处理请求时添加应用的定制功能。
 * @author liaopeng2008@gmail.com
 * @since 2011-12-20
 */
@SuppressWarnings("serial")
public class AppServlet extends org.springframework.web.servlet.DispatcherServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("系统正在初始化...");
		//spring mvc的初始化
		super.init(config);
		//应用初始化
		AppContext.init(this.getWebApplicationContext());
		System.out.println("系统启动完成");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		long start = System.currentTimeMillis();
		AppContext.request.set(request);
		AppContext.response.set(response);
		super.service(request, response);
		long time = System.currentTimeMillis() - start;
		if (time > 1000){
			System.out.println("请求" + request.getRequestURI() + "耗时：" + time);
		}
	}
}
