package com.yjiewei.controller;

import com.yjiewei.constant.BusinessMsgEnum;
import com.yjiewei.exception.BusinessErrorException;
import com.yjiewei.result.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @author yjiewei
 * @date 2021/8/10
 */
@RestController
@RequestMapping("/exception")
public class ExceptionController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    /**
     * 【-H "Content-Type: application/json" 指定请求头 -d 表示POST内容 -X请求协议】
     * curl -X POST -d '{"name":"yjiewei"}' "http://localhost:8003/exception/test"
     * {"code":"400","msg":"缺少必要的请求参数"}
     * 少传入一个参数
     * @return 异常处理返回
     */
    @PostMapping("/test") // 这一这里是post请求
    public JsonResult test(@RequestParam("name") String name, @RequestParam("pass") String pass) {
        logger.info("name：{}", name);
        logger.info("pass：{}", pass);
        return new JsonResult();
    }

    // 论如何自己抛出一个空指针异常
    @GetMapping("/testNull")
    public JsonResult testNull() {
        String s = null;
        s = s.replace("a","");
        return new JsonResult();
    }

    // 4.4抛出自定义的异常，并友好展示错误信息
    @GetMapping("business")
    public JsonResult testBusinessException() {
        try{
            int i = 1/0;
        }catch(Exception e){
            throw new BusinessErrorException(BusinessMsgEnum.UNEXPECTED_EXCEPTION);
        }
        return new JsonResult();
    }
}
