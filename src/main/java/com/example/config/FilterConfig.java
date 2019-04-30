package com.example.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.filter.CustomFilter;
import com.example.service.TestBeanService;

@Configuration
public class FilterConfig {
	//过滤器
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        List<String> urlPatterns = new ArrayList<String>();
        CustomFilter testFilter = new CustomFilter();   //new过滤器
        urlPatterns.add("/*");      //指定需要过滤的url
        filterRegistrationBean.setFilter(testFilter);       //set
        filterRegistrationBean.setUrlPatterns(urlPatterns);     //set
        filterRegistrationBean.setOrder(Integer.MAX_VALUE);//过滤器顺序
        return filterRegistrationBean;
    }
}
