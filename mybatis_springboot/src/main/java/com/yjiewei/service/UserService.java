package com.yjiewei.service;

import com.yjiewei.dao.UserDao;
import com.yjiewei.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @author yjiewei
 * @date 2021/8/17
 */
@Service
public class UserService {

    @Resource
    public UserDao userDao;

    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Transactional(rollbackFor = SQLException.class) // 这是在service层进行事务管理
    public void insertUser(User user) throws SQLException {
        try{
            // 插入用户信息
            userDao.insertUser(user);
            // 手动抛出异常，事务会回滚
            throw new SQLException("手动抛出异常测试@Transactional是否回滚");
        }catch (Exception e){
            // 我这里不处理，直接吃掉异常
        }
    }
}
