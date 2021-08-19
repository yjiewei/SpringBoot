package com.yjiewei.controller;

import com.yjiewei.entity.User;
import com.yjiewei.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @author yjiewei
 * @date 2021/8/17
 */
@RestController
public class TestMybatisController {

    @Resource
    private UserService userService;

    @GetMapping("/getUser/{username}")
    public void getUserByName(@PathVariable("username") String username){
        User user = userService.getUserByName(username);
        System.out.println(user.toString());
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        User user = userService.getUserById(id);
        return user;
    }

    @PostMapping("/adduser")
    public String addUser(@RequestBody User user) throws SQLException {
        if (null != user) {
            userService.insertUser(user);
            return "success";
        } else {
            return "false";
        }
    }
}
