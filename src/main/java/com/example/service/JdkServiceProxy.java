package com.example.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkServiceProxy implements InvocationHandler{

	//目标对象  
    private Object target;  
    
    public JdkServiceProxy(Object target) {
    	 super();  
         this.target=target;  
	}
    
    /**
     * 执行目标对象的方法  
     */
    public Object invoke(Object proxy, Method method, Object[] args)  
            throws Throwable {  
          
         //在目标方法执行前简单打印一下  
         System.out.println("--------JDK动态代理--before----------");  
           
         //执行目标方法对象  
         Object result=method.invoke(target, args);  
           
         //在目标方法执行之后简单打印一下  
         System.out.println("------JDK动态代理----after----------");  
          
         return result;  
    }  
    /** 
     * 获取目标对象的代理对象 
     * @return 代理对象 
     */  
    public Object getProxy(){  
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),   
                this.target.getClass().getInterfaces(),this);  
    }  

}
