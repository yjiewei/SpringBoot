package com.yjiewei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO：由于本地的activemq没有启动成功，测试没有成功
 */
@SpringBootApplication
public class ActivemqSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivemqSpringbootApplication.class, args);
    }

}
