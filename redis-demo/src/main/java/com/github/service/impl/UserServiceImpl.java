package com.github.service.impl;

import cn.hutool.core.lang.Pair;
import com.alibaba.fastjson.JSONObject;
import com.github.service.UserService;
import com.github.util.NameRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/7/8
 */

@Service
public class UserServiceImpl implements UserService {
    
    public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
    
    @Cacheable(key = "'userId:'+#userId",cacheNames = "UserServiceImpl")
    @Override
    public JSONObject getUserById(String userId) {
        logger.info("开始查询userId:{} 的用户信息", userId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", userId);
        Pair<String, String> chineseName = NameRandom.getChineseName();
        jsonObject.put("userName", chineseName.getKey());
        jsonObject.put("gender", chineseName.getValue());
        jsonObject.put("age", new Random().nextInt(4) + 18);
        logger.info("查询到用户信息:{}", jsonObject);
        return jsonObject;
    }
}
