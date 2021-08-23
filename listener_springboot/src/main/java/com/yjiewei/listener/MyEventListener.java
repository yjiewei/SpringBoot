package com.yjiewei.listener;

import com.yjiewei.entity.User;
import com.yjiewei.event.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 自定义监听器需要实现 ApplicationListener 接口
 * @author yjiewei
 * @date 2021/8/23
 */
@Component
public class MyEventListener implements ApplicationListener<MyEvent> {

    // 自定义的监听器需要事件被发布才能被触发
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        // 把事件中的信息获取到
        User user = myEvent.getUser();
        // 处理事件，实际项目中可以通知别的微服务或者处理其他逻辑等等，这里如何告知其他微服务呢
        System.out.println("用户名：" + user.getUsername());
        System.out.println("密码：" + user.getPassword());
    }
}
