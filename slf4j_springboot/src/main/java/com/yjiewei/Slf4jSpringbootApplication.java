package com.yjiewei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 简单日志门面（是个门面，内部实现随时替换无需成本）
 * 阿里手册规定使用slf4j，不直接使用日志系统（Log4j,Logback）中的api
 */
@SpringBootApplication
public class Slf4jSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Slf4jSpringbootApplication.class, args);
    }

}
