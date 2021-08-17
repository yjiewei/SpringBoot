package com.yjiewei.handler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 1.引入AOP依赖
 * 2.定义切面和处理方法
 * 2.1 @Aspect 注解用来描述一个切面类
 *     - @Pointcut：定义一个切面，即上面所描述的关注的某件事入口。
 *     - @Before：在做某件事之前做的事。
 *     - @After：在做某件事之后做的事。
 *     - @AfterReturning：在做某件事之后，对其返回值做增强处理。
 *     - @AfterThrowing：在做某件事抛出异常时，处理。
 *
 * @author yjiewei
 * @date 2021/8/11
 */
@Aspect
@Component
public class LogAspectHandler {

    private final Logger logger = LoggerFactory.getLogger(LogAspectHandler.class);

    /**
     * 定义一个切面，controller包和子包下的所有方法
     * 解释一下： * com.yjiewei.controller..*.*(..)
     *          返回值类型、
     *          yjiewei.controller（当前包、子包下所有类的方法）、
     *          第二个星号（类名，所有类）、
     *          第三个星号以及括号内两点（所有方法的所有参数）
     */
    @Pointcut("execution(* com.yjiewei.controller..*.*(..))")
    public void pointCut(){}

    /**
     * 针对某个注解来定义切面，比如对GetMapping做切面
     * 针对不同注解有不同的逻辑处理
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void annotation(){}

    /**
     * 在上面定义的切面方法执行之前执行该方法
     * @param joinPoint 切面方法？切入点？通过他可以来获取签名函数
     */
    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("==================进入doBefore方法进入=================");
        // 获取签名
        Signature signature = joinPoint.getSignature();
        // 获取切入的包名
        String declaringTypeName = signature.getDeclaringTypeName();
        // 获取即将执行的方法名
        String funName = signature.getName();
        logger.info("即将执行的方法为:{}, 属于 {} 包", funName, declaringTypeName);

        // 也可以用来记录一些信息，比如获取请求的URL和IP
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        // 获取请求的URL
        String requestURL = request.getRequestURL().toString();
        String requestURI = request.getRequestURI();
        logger.info("请求的URL是：{}，请求的URI是：{}", requestURL, requestURI);

        String ip = request.getRemoteAddr();
        logger.info("用户请求的IP地址是：{}", ip);

        logger.info("joinPoint中的参数信息有：{}", joinPoint.getArgs());
        logger.info("==================结束doBefore方法结束=================");
    }

    /**
     * 在上面定义的切面方法之后执行该方法
     * @param joinPoint jointPoint
     */
    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        logger.info("==================进入doAfter方法进入=================");
        Signature signature = joinPoint.getSignature();
        String method = signature.getName();
        logger.info("signature.getDeclaringTypeName: {}", signature.getDeclaringTypeName());
        logger.info("方法{}已经执行完", method);
        logger.info("==================结束doAfter方法结束=================");
    }


    /**
     * 在上面定义的切面方法返回后执行该方法，可以捕获返回对象或者对返回对象进行增强
     * 对返回值进行业务逻辑的增强处理
     * @param joinPoint joinPoint 切入点
     * @param result result 最主要的功能就是对结果的增强
     * 注意：注解中的returning名字要和函数名中的参数保持一致
     */
    @AfterReturning(pointcut = "pointCut()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("==================进入doAfterReturning方法进入=================");
        Signature signature = joinPoint.getSignature();
        String classMethod = signature.getName();
        logger.info("方法{}执行完毕，返回结果为：{}", classMethod, result);
        // 实际项目中可以根据业务做具体的返回值增强
        logger.info("对返回参数进行业务上的增强：{}", result + "增强版");
        logger.info("==================结束doAfterReturning方法结束=================");
    }

    /**
     * 在上面定义的切面方法执行抛异常时，执行该方法
     * @param joinPoint jointPoint
     * @param ex ex
     */
    @AfterThrowing(pointcut = "pointCut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        logger.info("==================进入doAfterThrowing方法进入=================");
        Signature signature = joinPoint.getSignature();
        String method = signature.getName();
        // 处理异常的逻辑
        logger.info("AfterThrowing执行的话，就不会执行AfterReturning，执行方法{}出错，异常为：{}", method, ex.getMessage());
        logger.info("==================结束doAfterThrowing方法结束=================");
    }
}





