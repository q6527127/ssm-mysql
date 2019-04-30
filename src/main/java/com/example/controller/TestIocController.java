package com.example.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.CglibServiceProxy;
import com.example.service.JdkServiceProxy;
import com.example.service.TestBeanService;
import com.example.service.TestProxyService;
import com.example.service.TestProxyServiceImpl;
import com.example.service.TestService1;
import com.example.service.TestService2;

/**
 * 测试controller
 * @author xiaodi
 *
 */
@Controller //证明是controller层并且返回json
@EnableAutoConfiguration
public class TestIocController {
	
	//spring配置文件注入
    @Autowired(required = false)  
    TestService1 testService1;
    @Autowired(required = false)  
    TestService2 testService2;
    //测试动态代理
    @Autowired(required = false)  
    TestProxyService testProxyService;
    //springBoot 配置类 注入
    @Resource(name="functionService")
    TestBeanService testBeanService;
    
    Logger log = Logger.getLogger(MysqlController.class);
	
    @RequestMapping(value = "testIoc1",method = RequestMethod.GET)
    @ResponseBody
    public  Object test1(HttpServletRequest request,HttpServletResponse response) {
        //testService1.TestService2Fun();
        testService2.TestService2Fun();
        //testBeanService.TestBeanService3();
        return null;
    }
    
    /**
     * 动态代理测试类
     * （面向接口只能代理实现了接口的类，而不能实现接口的类就不能实现JDK的动态代理）
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "testIoc2",method = RequestMethod.GET)
    @ResponseBody
    public  Object test2(HttpServletRequest request,HttpServletResponse response) {
        //实例化Invocation  
        JdkServiceProxy invocationHandler=new JdkServiceProxy(testProxyService);  
        //根据目标生成代理对象  
        TestProxyService proxy=(TestProxyService)invocationHandler.getProxy();  
        //调用代理对象方法  
        proxy.test();
        return null;
    }
    
    /**
     * CgLib动态代理
     * （cglib是针对类来实现代理的，他的原理是对指定的目标类生成一个子类，并覆盖其中方法实现增强，但因为采用的是继承，所以不能对final修饰的类进行）
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "testIoc3",method = RequestMethod.GET)
    @ResponseBody
    public  Object test3(HttpServletRequest request,HttpServletResponse response) {
    	 CglibServiceProxy cglib=new CglibServiceProxy();    
    	 TestService1 bookCglib=(TestService1)cglib.getInstance(testService1);    
         bookCglib.TestService2Fun(); 
        return null;
    }
    
    @RequestMapping(value = "testIoc4",method = RequestMethod.GET)
    @ResponseBody
    public  Object test4(HttpServletRequest request,HttpServletResponse response) {
    	
        return System.getenv();
    }
    
    @RequestMapping(value = "testIoc5",method = RequestMethod.GET)
    @ResponseBody
    public  Object test5(HttpServletRequest request,HttpServletResponse response) {
    	
        return System.getProperties();
    }
   
  
}
