package com.priority;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/6/28
 */
@Configuration
public class RabbitMqConfig {
    
    /**
     * 交换机名称
     */
    public static final String EXCHANGE_NAME = "spring-boot.priority.exchange";
    
    /**
     * 路由键
     */
    public static final String ROUNTING_KEY = "priority.queue";
    
    /**
     * 队列名称
     */
    public static final String QUEUE_NAME = "priority.queue";
    
    /**
     * 配置Direct交换机 * @return
     */
    @Bean
    public DirectExchange directExchange() {
        //        return new DirectExchange(EXCHANGE_NAME);
        return DirectExchange.DEFAULT;
    }
    
    
    /**
     * 配置队列 * @return
     */
    @Bean
    public Queue testQueue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-max-priority", 100);
        return new Queue(QUEUE_NAME, true, false, false, args);
    }
    
    /**
     * 将队列与交换机通过路由键绑定 * @return
     */
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(testQueue()).to(directExchange()).with(ROUNTING_KEY);
    }
}
