package com.yjiewei.dao;

import com.yjiewei.entity.User;
import org.apache.ibatis.annotations.*;

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

    @Insert("insert into t_user (username, password, salt) values (#{username}, #{password}, #{salt})")
    Integer insertUser(User user);
}
