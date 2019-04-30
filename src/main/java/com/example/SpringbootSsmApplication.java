package com.example;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * 项目入口e
 * @author XSWL pengfei.xiong
 * @date 2017年11月16日
 */
@SpringBootApplication
@EnableCaching
@EnableTransactionManagement 
public class SpringbootSsmApplication {
     //项目子入口
    public static void main(String[] args) {
        SpringApplication.run(SpringbootSsmApplication.class, args);
    }
}