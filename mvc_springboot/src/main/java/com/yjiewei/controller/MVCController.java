package com.yjiewei.controller;

import com.yjiewei.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * mvc在springboot中通常表示为几个注解，需要掌握区别
 * @author yjiewei
 * @date 2021/8/9
 */
@RestController // @Controller和@ResponseBody的结合体，针对前后端分离的项目，返回json
public class MVCController {

    // 处理请求地址映射，三个属性：value指定请求的实际地址，method是请求的类型，produces指定返回内容类型
    @RequestMapping(value = "/test", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public String test(){
        return "json";
    }

    // @PathVariable用来获取URL参数
    @GetMapping("/user/{iid}")
    public String testPathVariable(@PathVariable("iid") Integer id){
        System.out.println("页面传入的参数是：" + id);
        return "json";
    }

    // @RequestParam也是用来获取URL参数，区别是这个传入的是 ?id=1，前面那个是直接 /1  (get/post 都能用)
    @GetMapping("/user")
    public String testRequestParam(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id){
        System.out.println("页面传入的参数是：" + id);
        return "json";
    }

    // 如果使用实体的话，不使用@reqestbody注解也行，但是你接收的时候得写一个实体类，然后去get，参数 username="yjiewei", password="123456"
    @GetMapping("/user2")
    public String testRequestParam2(User user){
        System.out.println("页面传入的参数是：" + user.getUsername() + "-" + user.getPassword());
        return "json";
    }

    // 使用@RequestBody，这时你在postman上传参的时候就得用一个json串了，get post都可以用
    @PostMapping("/user3")
    public String testRequestBody(@RequestBody User user) {
        System.out.println("获取到的username为：" + user.getUsername());
        System.out.println("获取到的password为：" + user.getPassword());
        return "success";
    }

}
