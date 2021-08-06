package com.yjiewei.controller;

import com.yjiewei.entity.User;
import com.yjiewei.result.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yjiewei
 * @date 2021/8/6
 */
@RestController
@RequestMapping("json")
public class JsonController {

    @GetMapping("string")
    public String getString(){
        return null;
    }

    /**
     * 1.返回user对象
     *  {
     * "id": 1,
     * "username": "yjiewei",
     * "password": "123456"
     * }
     * @return
     */
    @GetMapping("user")
    public JsonResult<User> getUser(){
        // return new User(1L,"yjiewei", "123456");
        User user = new User(1L, "yjiewei", "123456");
        return new JsonResult<User>(user);
    }

    /**
     * 2.返回list数组对象
     * [
     * {
     * "id": 1,
     * "username": "杨杰炜",
     * "password": "123456"
     * },
     * {
     * "id": 2,
     * "username": "听我的",
     * "password": "123456"
     * }
     * ]
     * @return
     */
    @RequestMapping("list")
    public JsonResult<List<User>> getUserList() {
        List<User> userList = new ArrayList<>();
        User user1 = new User(1L, "杨杰炜", "123456");
        User user2 = new User(2L, "听我的", "123456");
        userList.add(user1);
        userList.add(user2);
        // return userList;
        return new JsonResult<>(userList);
    }

    /**
     * 3.返回map对象，包括多种数据类型
     * {
     * "作者信息": {
     * "id": 1,
     * "username": "杨杰炜",
     * "password": "123456"
     * },
     * "粉丝数量": null,
     * "天空才是极限": true,
     * "github地址": "https://github.com/yjiewei/SpringBoot"
     * }
     * 这里的null值直接显示，配置一个专门用来处理null值的配置类，"粉丝数量": "",
     */
    @RequestMapping("map")
    public Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>(3);
        User user = new User(1L, "杨杰炜", "123456");
        map.put("作者信息", user.toString());
        map.put("github地址", "https://github.com/yjiewei/SpringBoot");
        map.put("粉丝数量", null);
        map.put("天空才是极限", "");
        return map;
    }
}
