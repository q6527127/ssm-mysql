package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.example.pojo.User3;
import com.example.service.ProductService;
import com.example.service.TestBeanService;
import com.example.service.TestService1;
import com.example.service.TestService2;
import com.example.util.RedisUtil;

/**
 * 数据库测试controller
 * @author xiaodi
 * @date 2017年11月16日
 */
@Controller //证明是controller层并且返回json
@EnableAutoConfiguration
//@RequestMapping("/mysql")
//@ComponentScan(basePackages={"com.example.service"})//添加的注解
public class MysqlController extends baseController{
    //依赖注入
	@Autowired(required = false)  
	ProductService productService;
    
    
    /**
     * 查询数据并返回在页面上
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "mySql",method = RequestMethod.GET)
    public  ModelAndView queryProduct(HttpServletRequest request,HttpServletResponse response) {
    	ModelAndView model = new ModelAndView();
    	String name  = request.getParameter("name");
        Map<Object, Object> p = productService.queryProductByName(name);
        model.addObject("p",p);
        model.addObject("time",new Date());  
        model.addObject("message","hi,hello ......"); 
        model.setViewName("mysqlIndex");
        return model;
    }
    
    
    /**
     * 查询所有
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "loadAll",method = RequestMethod.GET)
    @ResponseBody
    public  Object loadAll(HttpServletRequest request,HttpServletResponse response) throws Exception{
        return productService.loadAll();
    }
    
    
    /**
     * 测试事务
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "mySqlTestTransaction",method = RequestMethod.GET)
    @ResponseBody
    public  ModelAndView mySqlTestTransaction(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	productService.add();
        return null;
    }
    /**
     * 测试自动返回主键
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "add",method = RequestMethod.GET)
    @ResponseBody
    public  int add(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	User3 user= new User3(0, "111", 5);
    	int count  = productService.addOne(user);
    	System.out.println(user.getId());
        return count;
    }
    
    /**
     * 批量插入返回KEY map 自动插入ID
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "addList",method = RequestMethod.GET)
    @ResponseBody
    public  int addList(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	List<HashMap<String,Object>>list = new ArrayList<HashMap<String,Object>>();
    	HashMap<String,Object> map1 = new HashMap<String, Object>();
    	map1.put("name", "qqq");
    	map1.put("age", 222);
    	HashMap<String,Object> map2 = new HashMap<String, Object>();
    	map2.put("name", "www");
    	map2.put("age", 222);
    	HashMap<String,Object> map3 = new HashMap<String, Object>();
    	map3.put("name", "eee");
    	map3.put("age", 222);
    	list.add(map1);
    	list.add(map2);
    	list.add(map3);
    	int count  = productService.addList(list);
    	System.out.println(list.toString());
        return count;
    }
    
    
    /**
     * 批量插入返回KEY map 自动插入ID
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "addList2",method = RequestMethod.GET)
    @ResponseBody
    public  int addList2(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	List<HashMap<String,Object>>list = new ArrayList<HashMap<String,Object>>();
    	HashMap<String,Object> map1 = new HashMap<String, Object>();
    	map1.put("name", "qqq");
    	map1.put("age", 222);
    	HashMap<String,Object> map2 = new HashMap<String, Object>();
    	map2.put("name", "www");
    	map2.put("age", 222);
    	HashMap<String,Object> map3 = new HashMap<String, Object>();
    	map3.put("name", "eee");
    	map3.put("age", 222);
    	list.add(map1);
    	list.add(map2);
    	list.add(map3);
    	int count  = productService.addList2(list);
    	System.out.println(list.toString());
        return count;
    }

}
