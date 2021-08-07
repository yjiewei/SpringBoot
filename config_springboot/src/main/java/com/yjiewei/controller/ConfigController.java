package com.yjiewei.controller;

import com.yjiewei.config.MicroServiceUrlConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yjiewei
 * @date 2021/8/7
 */
@RestController
@RequestMapping("/test")
public class ConfigController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigController.class);

    /**
     * 一个地址还好说，如果多个，每一个都使用@Value来注入，确实比较繁琐
     * 可以封装一个配置类来读取配置，把配置注入到配置类中，到时我么使用的时候直接用配置类来获取属性，
     * 属性又已经注入值了，这样就很方便了。
     */
    @Value("${url.orderUrl}")
    private String orderUrl;

    @RequestMapping("/config")
    public String testConfig() {
        LOGGER.info("获取的订单服务地址为：{}", orderUrl);
        return "success";
    }

    // 通过配置类的方式来使用属性
    @Resource
    private MicroServiceUrlConfig microServiceUrlConfig;

    @RequestMapping("/configClass")
    public String testConfigFromClass() {
        LOGGER.info("获取的订单服务地址为：{}", microServiceUrlConfig.getOrderUrl());
        LOGGER.info("获取的用户服务地址为：{}", microServiceUrlConfig.getUserUrl());
        LOGGER.info("获取的购物车服务地址为：{}",
                microServiceUrlConfig.getShoppingUrl());
        return "success";
    }
}
