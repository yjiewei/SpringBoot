package com.yjiewei.controller;

import com.yjiewei.annotation.UnInterception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yjiewei
 * @date 2021/8/24
 */
@RestController
@RequestMapping("/interceptor")
@Slf4j
public class InterceptorController {

    @GetMapping("/test")  // 第2步
    @UnInterception // 放弃拦截
    public String test() {
        log.info("这里是controller中的方法执行中");
        return "hello"; //返回字符串
    }

}
