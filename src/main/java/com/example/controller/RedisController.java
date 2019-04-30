package com.example.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.example.service.ProductService;
import com.example.service.TestBeanService;
import com.example.service.TestService1;
import com.example.service.TestService2;
import com.example.util.RedisUtil;

/**
 * redis操作controller
 * @author xiaodi
 * @date 2017年11月16日
 */
@Controller //证明是controller层并且返回json
@EnableAutoConfiguration
//@ComponentScan(basePackages={"com.example.service"})//添加的注解
public class RedisController extends baseController{

    //获取KEY
    @RequestMapping(value = "redisGet",method = RequestMethod.GET)
    @ResponseBody
    public  Object redis(HttpServletRequest request,HttpServletResponse response) {
    	String key  = request.getParameter("key");
    	boolean hasKey = redistemplate0.hasKey(key);
    	if (hasKey) {
    		return redistemplate0.opsForValue().get(key);
		}
        return null;
    }
    //加或改
    @RequestMapping(value = "redisEdit",method = RequestMethod.GET)
    @ResponseBody
    public  Object redisAdd(HttpServletRequest request,HttpServletResponse response) {
    	String key  = request.getParameter("key");
    	String value  = request.getParameter("value");
		redistemplate0.opsForValue().set(key,value );
        return "edit-"+key+":"+value;
    }
    //删
    @RequestMapping(value = "redisDelete",method = RequestMethod.GET)
    @ResponseBody
    public  Object redisDelete(HttpServletRequest request,HttpServletResponse response) {
    	String key  = request.getParameter("key");
    	boolean hasKey = redistemplate0.hasKey(key);
    	if (hasKey) {
    		redistemplate0.delete(key);
		}
        return "delete"+key;
    }
    //操作LIST
    @RequestMapping(value = "redisList",method = RequestMethod.GET)
    @ResponseBody
    public  Object redisList(HttpServletRequest request,HttpServletResponse response) {
    	String key  = request.getParameter("key");
    	String value  = request.getParameter("value");
    	String [] values = value.split(",");
    	//插数据
    	for (int i = 0; i < values.length; i++) {
    		RedisUtil.lpush(key, values[i],redistemplate0);
    	}
    	//查LIST 0-2
        return RedisUtil.range(key, 0, 2, redistemplate0);
    }
    
    //操作MAP
    @RequestMapping(value = "redisMap",method = RequestMethod.GET)
    @ResponseBody
    public  Object redisMap(HttpServletRequest request,HttpServletResponse response) {
    	String key  = request.getParameter("key");
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("key1", "value1");
    	map.put("key2", "value2");
    	map.put("key3", "value3");
    	//插入MAP
    	RedisUtil.setHash(key, map, redistemplate2);
    	//查Map 拿KEY2
        return RedisUtil.getHash(key, "key2", redistemplate2);
    }
}
