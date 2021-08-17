package com.yjiewei.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yjiewei
 * @date 2021/8/11
 */
@RestController
@RequestMapping("aop")
public class AopController {

    @GetMapping("test/{id}")
    public String testAop(@PathVariable Integer id){
        return "我都忘了。";
    }

    @GetMapping("testAopAfterThrowing/{id}")
    public String testAopAfterThrowing(@PathVariable Integer id){
        throw new RuntimeException("我在测试AfterThrowing异常处理...");
    }
}
