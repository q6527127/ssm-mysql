package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.util.PropertiesUtil;

/**
 * 测试controller
 * @author xiaodi
 *
 */
@Controller //证明是controller层并且返回json
@EnableAutoConfiguration
public class PropertyController {
	 /**
     * 远程读取property
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "testGetProperty",method = RequestMethod.GET)
    @ResponseBody
    public  Object testGetProperty(HttpServletRequest request,HttpServletResponse response) {
    	//全路径  http://localhost:8080/test/index.do
    	String url = "http://" + request.getServerName() //服务器地址  
        + ":"   
        + request.getServerPort()           //端口号  
        + request.getContextPath()+"/application.properties";      //项目名称 
    	//      + request.getServletPath()      //请求页面或其他地址  
    	//  + "?" + (request.getQueryString()); //参数
        System.out.println("\n"+url+"\n");
    	 PropertiesUtil p = new PropertiesUtil(url);
         System.out.println("server.port:"+p.remoteReadProperty("server.port"));
        return null;
    }
    
}
