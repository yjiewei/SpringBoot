package com.yjiewei.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * 使用ServletRequestListener获取访问信息
 * @author yjiewei
 * @date 2021/8/23
 */
@Component
public class MyServletRequestListener implements ServletRequestListener {

    private static final Logger logger = LoggerFactory.getLogger(MyServletRequestListener.class);

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // 这里就获取一下前面保存的值
        logger.info("request destroyed");
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        logger.info("request域中保存的name值为{}", request.getAttribute("name"));
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        logger.info("request initialized");
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        logger.info("session id 为 {}", request.getRequestedSessionId());
        logger.info("session url 为 {}", request.getRequestURL());

        request.setAttribute("name", "杨杰炜");
    }
}
