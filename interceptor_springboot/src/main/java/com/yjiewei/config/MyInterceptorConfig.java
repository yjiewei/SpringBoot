package com.yjiewei.config;

import com.yjiewei.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 2.配置拦截器，2.x版本的springboot是继承WebMvcConfigurationSupport，之前是WebMvcConfigurerAdapter
 * @author yjiewei
 * @date 2021/8/24
 */
/*@Configuration
public class MyInterceptorConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**"); // 添加拦截器和路径
        super.addInterceptors(registry);
    }

    *//**
     * 用来指定静态资源不被拦截，否则继承WebMvcConfigurationSupport这种方式会导致静态资源无法直接访问
     * @see WebMvcConfigurationSupport
     * @param registry
     *//*
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}*/

/**
 * WebMvcConfigurer接口不会拦截静态资源
 */
@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }
}