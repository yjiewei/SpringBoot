package com.yjiewei.controller;

import com.yjiewei.producer.MsgProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * 点对点消息的生产
 * activemq controller
 * @author yjiewei
 * @date 2021/10/8
 */
@Slf4j
@RestController
@RequestMapping("/activemq")
public class ActiveMqController {

    @Resource
    private MsgProducer producer;

    @Resource
    private Destination queue;

    @Resource
    private Destination topic;

    @GetMapping("/send/queue")
    public String sendQueueMessage(){
        log.info("开始发送点对点消息...");
        producer.sendMessage(queue, "Queue: hello, activemq");
        return "success";
    }

    @GetMapping("/send/topic")
    public String sendTopicMessage() {
        log.info("开始发送订阅消息...");
        producer.sendMessage(topic, "Topic: hello, activemq");
        return "success";
    }

}
