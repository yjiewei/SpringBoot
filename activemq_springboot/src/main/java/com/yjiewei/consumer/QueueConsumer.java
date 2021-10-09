package com.yjiewei.consumer;

import com.yjiewei.config.ActiveMqConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * 点对点消息的消费
 * @author yjiewei
 * @date 2021/10/8
 */
@Service
public class QueueConsumer {

    /**
     * 监听目的地，只要有消息就会被消费
     * @param msg 接收点对点消息
     */
    @JmsListener(destination = ActiveMqConfig.QUEUE_NAME)
    public void receiveQueueMsg(String msg) {
        System.out.println("收到的消息是：" + msg);
    }


    // 这里手动设置多个订阅，能够成功接收到 JmsListener监听时默认只接收queue消息，所以这里添加了factory
    /**
     * 接收订阅消息
     * @param msg
     */
    @JmsListener(destination = ActiveMqConfig.TOPIC_NAME, containerFactory = "topicListenerContainer")
    public void receiveTopicMsg(String msg) {
        System.out.println("收到的消息为：" + msg);
    }

    /**
     * 接收订阅消息
     * @param msg
     */
    @JmsListener(destination = ActiveMqConfig.TOPIC_NAME, containerFactory = "topicListenerContainer")
    public void receiveTopicMsg1(String msg) {
        System.out.println("收到的消息为：" + msg);
    }

    /**
     * 接收订阅消息
     * @param msg
     */
    @JmsListener(destination = ActiveMqConfig.TOPIC_NAME, containerFactory = "topicListenerContainer")
    public void receiveTopicMsg2(String msg) {
        System.out.println("收到的消息为：" + msg);
    }

}
