package com.example.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.util.FreemarkCustomLabelUtil;

import freemarker.template.Configuration;
import freemarker.template.TemplateModelException;

/**
 * freemark 配置类
 * @author xiaodi
 */
@Component
public class FreemarkerConfig {
	  @Autowired
	  private Configuration configuration;
	  @Autowired
	  private FreemarkCustomLabelUtil userTopicDirective;

	  @PostConstruct
	  public void setSharedVariable() throws TemplateModelException {
	    configuration.setSharedVariable("in_page", userTopicDirective);
	  }
}
