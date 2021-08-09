package com.yjiewei.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 1.引入依赖
 * 2.丝袜哥配置
 * 3.@ApiModel 和 @ApiModelProperty俩注解带你起飞
 *
 * 如果没有及时生效，可以清除一下缓存
 * @author yjiewei
 * @date 2021/8/9
 */
@Configuration
@EnableSwagger2 // 必要
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 指定构建api文档的详细信息的方法：apiInfo()
                .apiInfo(apiInfo())
                .select()
                // 指定要生成api接口的包路径，这里把controller作为包路径，生成controller中的所有接口
                .apis(RequestHandlerSelectors.basePackage("com.yjiewei.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建api文档的详细信息
     * @return ApiInfo信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置页面标题
                .title("Spring Boot集成Swagger2接口总览")
                // 设置接口描述
                .description("杨杰炜学习SpringBoot的笔记")
                // 设置联系方式
                .contact("杨杰炜GitHub地址：" + "https://github.com/yjiewei/SpringBoot")
                // 设置版本
                .version("1.0")
                // 构建
                .build();
    }
}