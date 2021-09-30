package com.yjiewei.test;

import com.alibaba.fastjson.JSON;
import com.yjiewei.entity.User;
import com.yjiewei.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yjiewei
 * @date 2021/9/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    private static final Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Resource
    public RedisService redisService;

    @Test
    public void contextLoads() {
        // 1.测试Redis的String类型
        redisService.setString("yjiewei", "新时代农民工");
        logger.info("我的Github是{}", redisService.getString("yjiewei"));

        // 2.测试Redis的实体类型比如user
        User user = new User("yjiewei", "123456");
        redisService.setString("userinfo", JSON.toJSONString(user));
        logger.info("我这里存放的是实体对象信息{}，其实就是对象转字符串存储", redisService.getString("userinfo"));

        // 3.测试Redis中的hash类型
        redisService.setHash("user", "name", JSON.toJSONString(user));
        logger.info("用户姓名是: {}", redisService.getHash("user", "name"));

        // 4.测试Redis中的list类型数据设置和获取
        redisService.setList("list", "basketball");
        redisService.setList("list", "football");
        redisService.setList("list", "baseball");

        List<String> list = redisService.getList("list", 0, -1);
        for (String value : list) {
            logger.info("列表中的值有：{}", value);
        }
    }
}
