package com.priority;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/6/28
 */
//@Component
public class HandleMsgService {
    
    private static Logger log = LoggerFactory.getLogger(HandleMsgService.class);
    
    @RabbitListener(queues = "priority.queue")
    public void handle(String msg) throws InterruptedException {
        Thread.sleep(10 * 1000);
        log.info("收到消息:{}", msg);
    }
    
}
