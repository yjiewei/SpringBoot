package com.yjiewei.service;

import com.yjiewei.entity.User;
import com.yjiewei.event.MyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yjiewei
 * @date 2021/8/19
 */
@Service("userService")
public class UserService {

    @Resource
    private ApplicationContext applicationContext;

    /**
     * 获取用户信息
     * @return user
     */
    public User getUser() {
        // 实际中会根据具体的业务场景，从数据库中查询对应的信息
        return new User(1, "杨杰炜", "123456");
    }

    /**
     * 发布事件
     * @return 当前业务逻辑处理完之后就会触发事件，事件处理完才返回
     */
    public User getUser2() {
        User user = new User(1, "杨杰炜", "123456");
        // 发布事件
        MyEvent event = new MyEvent(this, user);
        applicationContext.publishEvent(event);
        return user;
    }
}
