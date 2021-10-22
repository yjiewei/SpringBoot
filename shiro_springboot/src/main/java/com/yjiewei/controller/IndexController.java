package com.yjiewei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yjiewei
 * @date 2021/10/22
 */
@Controller
public class IndexController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

}
