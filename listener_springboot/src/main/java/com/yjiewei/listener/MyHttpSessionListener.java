package com.yjiewei.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 使用HttpSessionListener统计在线用户数的监听器
 * @author yjiewei
 * @date 2021/8/19
 */
@Component
public class MyHttpSessionListener implements HttpSessionListener {

    private static final Logger logger = LoggerFactory.getLogger(MyHttpSessionListener.class);

    /**
     * 统计在线用户数量
     */
    private Integer count = 0;

    /**
     * 加锁
     * @param se
     */
    @Override
    public synchronized void sessionCreated(HttpSessionEvent se) {
        logger.info("用户上线啦");
        count++; // 加锁是出于此处考虑，但绝对不推荐
        ServletContext application = se.getSession().getServletContext();
        se.getSession().setAttribute("count", count);
        application.setAttribute("count", count);
    }

    @Override
    public synchronized void sessionDestroyed(HttpSessionEvent se) {
        logger.info("用户下线了...");
        count--;
        se.getSession().setAttribute("count", count); // 这种方式不行，为什么呢。已修改，都是可行的，创建时没有添加attribute
        se.getSession().getServletContext().setAttribute("count", count);
    }
}
