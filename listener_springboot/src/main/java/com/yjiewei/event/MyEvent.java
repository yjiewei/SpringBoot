package com.yjiewei.event;

import com.yjiewei.entity.User;
import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件，需要继承ApplicationEvent
 * @author yjiewei
 * @date 2021/8/23
 */
public class MyEvent extends ApplicationEvent {

    private User user;

    public MyEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
