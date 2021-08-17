比较简单，写一下整合步骤
1. 引入依赖
```xml
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```
2. yaml配置数据源
```yaml
# 指定服务器下端口的指定数据库
datasource:
  url: localhost:3306/shiro

spring:
  datasource:
    url: jdbc:mysql://${datasource.url}?serverTimezone=GMT&useSSL=false&useUnicode=true&characterEncoding=utf-8 # 连不上的话十有八九就是这里
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: root
    password: root
    hikari: # 自带的高性能数据库连接池
      maximum-pool-size: 10
      max-lifetime: 1770000

mybatis:
  # 指定别名设置的包为所有entity
  type-aliases-package: com.yjiewei.entity
  configuration:
    map-underscore-to-camel-case: true # 驼峰命名规范，比如user_name能够匹配实体的userName
  mapper-locations: # mapper映射文件位置
        - classpath:mapper/*.xml
```

3. 基于XML整合
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.yjiewei.dao.UserDao">

    <resultMap id="BaseResultMap" type="com.yjiewei.entity.User">
        <id column="id" jdbcType="INTEGER" property="id" />
        <result column="username" jdbcType="VARCHAR" property="username" />
        <result column="password" jdbcType="VARCHAR" property="password" />
        <result column="salt" jdbcType="VARCHAR" property="salt" />
    </resultMap>

    <!-- resultType="User" 和 resultMap="BaseResultMap" 效果一样-->
    <select id="getUserByName" resultType="User" parameterType="String">
        select * from t_user where username = #{username}
    </select>
    <!--这个文件名需要和dao的文件名一致-->
</mapper>
```

4. 启动类上扫描dao文件
   `@MapperScan("com.yjiewei.dao")`
   
5. 基于注解整合
```java
/**
 * 通过找到对应的xml文件进行sql查询，或者通过注解的方式
 * @author yjiewei
 * @date 2021/8/17
 */
@Mapper
public interface UserDao {

    User getUserByName(String username);

    @Select("select * from t_user where id = #{id}")
    @ResultMap("BaseResultMap")  // 另外一个相同用处的注解是@Results
    User getUserById(Integer id);

    @Select("select * from t_user where id = #{id} and username=#{username}")
    User getUserByIdAndName(@Param("id") Integer id, @Param("username") String username);
}
```

6. 启动测试