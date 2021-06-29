package com.priority;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/6/28
 */
@RestController
public class SendMsgController {
    
    private static Logger log = LoggerFactory.getLogger(SendMsgController.class);
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    /**
     * 发送消息 * @param msg 消息内容
     *
     * @return
     */
    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public boolean send(String msg) {
        try {
            rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, RabbitMqConfig.ROUNTING_KEY, msg);
        } catch (AmqpException e) {
            log.error("发送消息异常：{}", e);
            return false;
        }
        return true;
    }
    
    
    @RequestMapping(value = "/send/priority", method = RequestMethod.GET)
    public boolean send(String msg, Integer priority) {
        try {
            msg = msg + "优先级为" + priority;
            rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, RabbitMqConfig.ROUNTING_KEY, msg, message -> {
                message.getMessageProperties().setPriority(priority);
                return message;
            });
        } catch (AmqpException e) {
            log.error("发送消息异常：{}", e);
            return false;
        }
        return true;
    }
    
    
}
