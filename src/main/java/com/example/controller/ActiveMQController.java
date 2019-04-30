package com.example.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.example.service.ActiveMQConsumerService;
//import com.example.service.ActiveMQProducerService;
//
//import javax.annotation.Resource;
//import javax.jms.Destination;
//import javax.jms.TextMessage;
//
///**
// * Created by Administrator on 2017/1/5.
// */
//@Controller
//public class ActiveMQController {
//    private Logger logger = LoggerFactory.getLogger(ActiveMQController.class);
//    @Resource(name = "demoQueueDestination")
//    private Destination destination;
//
//    //队列消息生产者
//    @Autowired
//    private ActiveMQProducerService producer;
//
//    //队列消息消费者
//    @Autowired
//    private ActiveMQConsumerService consumer;
//
//    @RequestMapping(value = "/SendMessage", method = RequestMethod.POST)
//    @ResponseBody
//    public void send(String msg) {
//        logger.info(Thread.currentThread().getName()+"------------send to jms Start");
//        producer.sendMessage(msg);
//        logger.info(Thread.currentThread().getName()+"------------send to jms End");
//    }
//
//    @RequestMapping(value= "/ReceiveMessage",method = RequestMethod.GET)
//    @ResponseBody
//    public Object receive(){
//        logger.info(Thread.currentThread().getName()+"------------receive from jms Start");
//        TextMessage tm = consumer.receive(destination);
//        logger.info(Thread.currentThread().getName()+"------------receive from jms End");
//        return tm;
//    }
//
//}