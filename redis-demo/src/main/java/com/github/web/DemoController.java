package com.github.web;

import com.github.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/7/8
 */

@RestController("/demo")
public class DemoController {
    
    public static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    
    @Autowired
    UserService userService;
    
    @GetMapping("/user/{id}")
    String getUserInfo(@PathVariable("id") String id) {
        logger.info("收到请求id:{}", id);
        return userService.getUserById(id).toJSONString();
    }
}

