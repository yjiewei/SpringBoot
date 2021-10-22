package com.yjiewei.controller;

import com.yjiewei.entity.TUser;
import com.yjiewei.service.TUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * (TUser)表控制层
 *
 * @author makejava
 * @since 2021-10-22 12:46:27
 */
@Controller
@RequestMapping("user")
public class TUserController {
    /**
     * 服务对象
     */
    @Resource
    private TUserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TUser selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    /**
     * 身份认证测试接口
     * @param request
     * @return
     */
    @RequestMapping("/admin")
    public String admin(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("user");
        return "success";
    }

    /**
     * 角色认证测试接口
     * @param request
     * @return
     */
    @GetMapping("/student")
    public String student(HttpServletRequest request) {
        return "success";
    }
    /**
     * 权限认证测试接口
     * @param request
     * @return
     */
    @GetMapping("/teacher")
    public String teacher(HttpServletRequest request) {
        return "success";
    }

    /**
     * 用户登录接口
     * @param user user
     * @param request request
     * @return string
     */
    @PostMapping("/login")
    public String login(TUser user, HttpServletRequest request) {
        // 根据用户名和密码创建token
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        // 获取subject认证主体
        Subject subject = SecurityUtils.getSubject();
        try{
            // 开始认证，这一步会跳到我们自定义的realm中
            subject.login(token);
            request.getSession().setAttribute("user", user);
            return "success";
        }catch(Exception e){
            e.printStackTrace();
            request.getSession().setAttribute("user", user);
            request.setAttribute("error", "用户名或密码错误！");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "login";
    }
}