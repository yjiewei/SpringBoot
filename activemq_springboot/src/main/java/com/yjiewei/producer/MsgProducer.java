package com.yjiewei.producer;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * 消息发送者:只要注入 JmsMessagingTemplate 模板即可快速发送消息
 * @author yjiewei
 * @date 2021/10/8
 */
@Service
public class MsgProducer {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(Destination destination, String msg) {
        /**
         * 两个参数是：消息发送的目的地；消息
         */
        jmsMessagingTemplate.convertAndSend(destination, msg);
    }

}
