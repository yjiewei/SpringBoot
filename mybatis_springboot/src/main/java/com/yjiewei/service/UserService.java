package com.yjiewei.service;

import com.yjiewei.dao.UserDao;
import com.yjiewei.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
