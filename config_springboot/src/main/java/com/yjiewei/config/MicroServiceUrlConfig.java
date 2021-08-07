package com.yjiewei.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yjiewei
 * @date 2021/8/7
 */
@Data
@Component
@ConfigurationProperties(prefix = "url") // 会根据属性自动注入，需要一一对应
public class MicroServiceUrlConfig {

    private String orderUrl;
    private String userUrl;
    private String shoppingUrl;

}
