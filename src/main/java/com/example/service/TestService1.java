package com.example.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 启动加载
 * 继承BeanFactoryPostProcessor 该bean加载完毕后自动执行代码
 * @author xiaodi
 *
 */
public class TestService1 implements BeanFactoryPostProcessor{
	public void TestService2Fun() {
		System.out.println("TestService2Fun!!");

	}

	/**
	 * 继承BeanFactoryPostProcessor 该bean加载完毕后自动执行代码
	 */
	public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0) throws BeansException {
		System.out.println("======================TestService1启动加载======================");
		
	}
}
