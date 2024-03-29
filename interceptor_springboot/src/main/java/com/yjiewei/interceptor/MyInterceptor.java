package com.yjiewei.interceptor;

import com.yjiewei.annotation.UnInterception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 自定义拦截器 1.实现HandlerInterceptor接口
 * @author yjiewei
 * @date 2021/8/24
 */
public class MyInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Override  // 第1步
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String methodName = method.getName();
        logger.info("=======拦截到了方法：{}，在该方法执行之前执行======", methodName);

        // 当方法上有这个注解的时候就直接放行，不需要判断是否携带token或者其他逻辑
        UnInterception unInterception = method.getAnnotation(UnInterception.class);
        if (unInterception != null) {
            return true;
        }

        // 判断用户有没有登陆，一般登陆之后的用户都有一个对应的token
        String token = request.getParameter("token");
        if (null == token || "".equals(token)) {
            logger.info("用户未登录，没有权限执行...请登录");
            return false;
        }
        // 返回true才会继续执行，返回false则取消当前请求
        return true;
    }

    @Override // 第3步
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("执行完方法之后进执行(Controller方法调用之后返回之前)，但是此时还没进行视图渲染");
    }

    @Override // 第4步
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("整个请求都处理完了，DispatcherServlet也渲染了对应的视图，此时可以做一些清理的工作了");
        logger.info("====================拦截处理结束=================");
    }
}
