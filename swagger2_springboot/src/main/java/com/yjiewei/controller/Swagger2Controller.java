package com.yjiewei.controller;

import com.yjiewei.entity.User;
import com.yjiewei.result.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * 把接口显示在api-docs页面上
 * @author yjiewei
 * @date 2021/8/9
 */
@RestController
@RequestMapping("/swagger")
@Api(value = "Swagger2Controller 在线接口文档")
public class Swagger2Controller {

    @GetMapping("/get/{id}")
    @ApiOperation(value = "根据用户唯一标识获取用户信息")
    public JsonResult<User> getUserInfo(@PathVariable @ApiParam(value = "用户唯一标识") Long id) {
        // 模拟数据库中根据id获取User信息
        User user = new User(id, "yjiewei", "123456");
        return new JsonResult(user);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "添加用户信息")
    public JsonResult<Void> insertUser(@RequestBody @ApiParam(value = "用户信息") User user) {
        // 处理添加逻辑
        return new JsonResult<>();
    }
}
