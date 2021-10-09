package com.yjiewei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * activemq下载地址：https://activemq.apache.org/activemq-5015003-release
 * Windows下执行流程：1.下载bin.zip  2.命令行执行 activemq.bat start
 * Linux下执行：解压缩之后直接启动./activemq start
 */
@SpringBootApplication
public class ActivemqSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivemqSpringbootApplication.class, args);
    }

}
