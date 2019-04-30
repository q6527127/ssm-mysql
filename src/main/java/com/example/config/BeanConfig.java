package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.service.TestBeanService;

@Configuration
public class BeanConfig {
	  //这个相当于是get方法了,给这个返回的对象添加上注解,那么这个FunctionService就是一个Bean了
    @Bean //2
    public TestBeanService functionService (){
        return new TestBeanService();
    }
}
