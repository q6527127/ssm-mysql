package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.example.base.baseController;
import com.example.pojo.Product;
import com.example.pojo.User3;
import com.example.service.ProductService;
import com.example.service.TestBeanService;
import com.example.service.TestService1;
import com.example.service.TestService2;
import com.example.util.CookieUtil;
import com.example.util.DateUtil;
import com.example.util.RedisUtil;

/**
 * 数据库测试controller
 * @author xiaodi
 * @date 2017年11月16日
 */
@Controller //证明是controller层并且返回json
@EnableAutoConfiguration
//@ComponentScan(basePackages={"com.example.service"})//添加的注解
public class IndexController extends baseController{
	
	@RequestMapping(value = "index.do",method = RequestMethod.GET)
    public  ModelAndView index(HttpServletRequest request,HttpServletResponse response) {
		//全路径  http://localhost:8080/test
        String url="http://" + request.getServerName() //服务器地址    
        + ":"     
        + request.getServerPort()           //端口号    
        + request.getContextPath(); 
        //base塞到session里
        HttpSession session =   request.getSession();
        String base = (String) session.getAttribute("base");
        if (base == null||base.equals("")) {
        	session.setAttribute("base", url);
		}
		CookieUtil.setCookie(response,"loginDate" ,DateUtil.getSysDate(new Date(), DateUtil.DATE_FORMAT_YYYYMMDDHHmm), 99);
		//页面返回
    	ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }

}
