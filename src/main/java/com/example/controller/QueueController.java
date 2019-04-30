package com.example.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.queue.QueueBean;
import com.example.queue.QueueListener;
/**
 * 队列操作controller
 * @author xiaodi
 *
 */
@Controller //证明是controller层并且返回json
@EnableAutoConfiguration
public class QueueController {
	
		/**
		 * 开启内存队列监听
		 * @param request
		 * @param response
		 * @return
		 */
		 @RequestMapping(value = "test3",method = RequestMethod.GET)
		@ResponseBody
	    public  Object test3(HttpServletRequest request,HttpServletResponse response) {
		 	//初始化内存队列
	    	QueueBean.getInstance().init();
	    	//开启四个内存队列监听
	    	QueueListener thread1 =new QueueListener(QueueBean.getInstance().getQueue1(),1);
	    	QueueListener thread2 =new QueueListener(QueueBean.getInstance().getQueue2(),2);
	    	QueueListener thread3 =new QueueListener(QueueBean.getInstance().getQueue3(),3);
	    	QueueListener thread4 =new QueueListener(QueueBean.getInstance().getQueue4(),4);
	    	thread1.start();
	    	thread2.start();
	    	thread3.start();
	    	thread4.start();
	        return null;
	    }
	 
	    /**
    	* 向内存队列发送消息
    	* @param request
    	* @param response
    	* @return
	    */
	    @RequestMapping(value = "test4",method = RequestMethod.GET)
	    @ResponseBody
	    public  Object test4(HttpServletRequest request,HttpServletResponse response) {
	    	//第几个队列
	    	String queueNum = request.getParameter("str1");
	    	//消息内容
	    	String test = request.getParameter("str2");
	    	//向对应的 队列 发送消息
	    	if (queueNum.equals("1")) {
	        	QueueBean.getInstance().getQueue1().putMsg(test);      
			}else if (queueNum.equals("2")) {
	        	QueueBean.getInstance().getQueue2().putMsg(test);       
			}else if (queueNum.equals("3")) {
	        	QueueBean.getInstance().getQueue3().putMsg(test);       
			}else if (queueNum.equals("4")) {
	        	QueueBean.getInstance().getQueue4().putMsg(test);       
			}
	    	return null;
	    }
}
