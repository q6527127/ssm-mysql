package com.example.service;
/**
 * springIOC 管理BEAN application-bean.xml配置BEAN 
 * init-method="start" 添加配置 BEAN加载完成后自动执行方法
 * @author xiaodi
 *
 */
public class SpringIOCBeanConfigStartService {
	public void start() {
		System.out.println("==============SpringIOCBeanConfigStartService启动加载============");
	}
}
