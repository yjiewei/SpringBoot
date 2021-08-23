package com.yjiewei.controller;

import com.yjiewei.entity.User;
import com.yjiewei.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author yjiewei
 * @date 2021/8/19
 */
@RestController
@RequestMapping("/listener")
public class UserController {

    @GetMapping("/user")
    public User getUser(HttpServletRequest request) {
        ServletContext application = request.getServletContext();
        return (User) application.getAttribute("user");
    }

    /**
     * 但是这里有个问题，关闭浏览器之后重新打开访问，应该销毁session，但是没有-1
     * @param request
     * @return
     */
    @GetMapping("/online")
    public String getOnlineCount(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count"); // 这种方式始终为null；修改成功，监听器没有存放attribute。
        Integer count1 = (Integer) session.getServletContext().getAttribute("count");
        System.out.println(count);
        System.out.println(count1);
        return "当前在线人数是:" + count1;
    }

    /**
     * 解决上一步中关闭session时未能执行sessionDestroyed方法
     * @param request
     * @return
     */
    @GetMapping("/online2")
    public String getOnlineCount2(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie;
        try{
            // 把sessionId记录在浏览器中
            cookie = new Cookie("JSESSIONID", URLEncoder.encode(request.getSession().getId(), "UTF-8"));
            cookie.setPath("/");
            // 设置cookie的有效期，可以设置长一点
            cookie.setMaxAge(48 * 60 * 60);
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count");
        System.out.println(count);
        return "当前在线人数是："+ count;
    }

    @GetMapping("/request")
    public String getRequestInfo(HttpServletRequest request) {
        System.out.println("requestListener中的初始化的name数据：" + request.getAttribute("name"));
        return "success";
    }

    @Resource
    public UserService userService;

    @GetMapping("/publish")
    public String publish(HttpServletRequest request) {
        User user = userService.getUser2();
        return "success";
    }

}
