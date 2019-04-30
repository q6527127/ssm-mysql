package com.example.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class Aop {
	    @Pointcut("execution(* com.example.service.*Service2.*(..))")
	    public void aopInterface(){}
	    
	    @Before("aopInterface()")
	    public void before() throws Exception{
	        System.out.println("Spring before 注解AOP");
            String [] a = {"1","2","3"};
            System.out.println("==================="+a[3]);
	    }
	    
	    @After("aopInterface()")
	    public void after(){
	        System.out.println("Spring after 注解AOP");
	    }
}