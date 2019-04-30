package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.namespace.QName;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.queue.QueueBean;
import com.example.queue.QueueListener;
import com.example.util.PropertiesUtil;
import com.example.util.TestUtil;
import com.example.util.ThreadUtil;

/**
 * 测试controller
 * @author xiaodi
 *
 */
@Controller //证明是controller层并且返回json
@EnableAutoConfiguration
public class TestController {
	Map<String, ThreadUtil> map = new HashMap<String, ThreadUtil>();
	private static List<String> list = null;
	//**
    @RequestMapping(value = "test",method = RequestMethod.GET)
    @ResponseBody
    public  Object redisMap(HttpServletRequest request,HttpServletResponse response) {
    	HttpSession sessopn =  request.getSession();
//    	String num  = request.getParameter("num");
//    	list = new ArrayList<String>();
//    	list.add("1");
//    	list.add("2");
//    	list.add("3");
//    	list=null;
    	;
    	TestUtil.add();
    	System.out.println("====================");
    	System.out.println(TestUtil.list);
        return null;
    }
    
    @RequestMapping(value = "test1",method = RequestMethod.GET)
    @ResponseBody
    public  Object test1(HttpServletRequest request,HttpServletResponse response) {
    	HttpSession sessopn =  request.getSession();
//    	String num  = request.getParameter("num");
//    	list = new ArrayList<String>();
//    	list.add("1");
//    	list.add("2");
//    	list.add("3");
//    	list=null;
    	System.out.println("====================");
    	System.out.println(TestUtil.list);
        return null;
    }
    
    
    @RequestMapping(value = "test2",method = RequestMethod.GET)
    @ResponseBody
    public  Object test2(HttpServletRequest request,HttpServletResponse response) {
    	HttpSession sessopn =  request.getSession();
//    	String num  = request.getParameter("num");
    	List list = new ArrayList<String>();
    	list.removeAll(list);
//    	list.add("1");
//    	list.add("2");
//    	list.add("3");
//    	list=null;
    	TestUtil.remove(null);;
    	System.out.println("====================");
    	System.out.println(TestUtil.list);
        return null;
    }
    
   
   
  
}
