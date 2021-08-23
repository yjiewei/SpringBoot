package com.yjiewei.listener;

import com.yjiewei.entity.User;
import com.yjiewei.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

/**
 * ContextRefreshedEvent 很显然，这个就是在上下文加载或刷新时重新加载资源。
 * 最后存储到 application 域中，这样前端在请求相应数据的时候，
 * 我们就可以直接从 application 域中获取信息，减少数据库的压力。
 * 不过，application 这种是缓存在内存中，对内存会有消耗，可以使用Redis
 * @author yjiewei
 * @date 2021/8/19
 */
@Component
public class MyServletContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // 1.先获取application上下文
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();

        // 2.获取对应的service
        UserService userService = (UserService) applicationContext.getBean("userService");
        User user = userService.getUser();

        // 3.获取application域对象，将查到的信息放到application域中
        ServletContext application = applicationContext.getBean(ServletContext.class);
        application.setAttribute("user", user);
    }
}
