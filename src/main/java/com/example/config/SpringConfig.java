package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations={"classpath:application-bean.xml","application-spring.xml"})
public class SpringConfig {
    
}