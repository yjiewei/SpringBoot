package com.yjiewei.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yjiewei
 * @date 2021/8/6
 */
@RestController
@RequestMapping("slf4j")
public class Slf4jController {

    private final static Logger logger = LoggerFactory.getLogger(Slf4jController.class);

    @RequestMapping("/log")
    public String testLog() {
        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");
        // 可以使用占位符打印出一些参数信息
        String str1 = "yjiewei";
        String str2 = "netca";
        logger.info("我叫{}，就职于{}。", str1, str2);
        return "success";
    }
}
