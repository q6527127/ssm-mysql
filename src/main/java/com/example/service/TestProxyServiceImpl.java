package com.example.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Service;

/**
 * CGLIB动态代理用类
 * @author xiaodi
 *
 */
@Service
public class  TestProxyServiceImpl implements TestProxyService {

	public void test() {
		System.out.println("TestProxyServiceImpl.test()");
	}

}
