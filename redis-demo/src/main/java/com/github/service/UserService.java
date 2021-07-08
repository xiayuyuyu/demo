package com.github.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/7/8
 */
public interface UserService {
    
    /**
     * 获取
     *
     * @param userId userId
     * @return java.lang.String
     */
    JSONObject getUserById(String userId);
    
}
