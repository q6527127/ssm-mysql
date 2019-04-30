package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.util.ThreadUtil;
@Controller //证明是controller层并且返回json
@EnableAutoConfiguration
public class ThreadController {
	Map<String, ThreadUtil> map = new HashMap<String, ThreadUtil>();
	
    @RequestMapping(value = "threadStart",method = RequestMethod.GET)
    @ResponseBody
    public  Object redisMap(HttpServletRequest request,HttpServletResponse response) {
    	String num  = request.getParameter("num");
    	ThreadUtil util = new ThreadUtil(Integer.parseInt(num));
    	util.start();
    	map.put(num, util);
        return num;
    }
    
    @RequestMapping(value = "threadStop",method = RequestMethod.GET)
    @ResponseBody
    public  Object threadStop(HttpServletRequest request,HttpServletResponse response) {
    	String num  = request.getParameter("num");
    	ThreadUtil util =map.get(num);
    	util.stop();
        return "stop:"+num;
    }
}
