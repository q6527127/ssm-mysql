package com.example.base;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import com.example.controller.RedisController;

@Component
@EnableAutoConfiguration
public class baseController {
	protected Logger log = Logger.getLogger(RedisController.class);
    
    @Resource(name="redisTemplate0")
    protected RedisTemplate<String, Object> redistemplate0;
    
    @Resource(name="redisTemplate1")
    protected RedisTemplate<String, Object> redistemplate1;
    
    @Resource(name="redisTemplate2")
    protected RedisTemplate<String, Object> redistemplate2;
    
}
