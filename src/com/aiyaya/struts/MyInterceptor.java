package com.aiyaya.struts;

import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.ActionInvocation;

public class MyInterceptor implements Interceptor{
	
	private static final long serialVersionUID = 123456789L;

	public void init(){
		System.out.println("自定义拦截器MyInterceptor初始化...");
	}
	
	public void destroy(){
		System.out.println("自定义拦截器MyInterceptor销毁...");
	}
	
	public String intercept(ActionInvocation invocation) throws Exception{
		return invocation.invoke();
	}

}
