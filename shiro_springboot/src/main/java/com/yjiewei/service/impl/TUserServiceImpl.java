package com.yjiewei.service.impl;

import com.yjiewei.entity.TUser;
import com.yjiewei.dao.TUserDao;
import com.yjiewei.service.TUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * (TUser)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 12:46:27
 */
@Service("userService")
public class TUserServiceImpl implements TUserService {

    @Resource
    private TUserDao tUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TUser queryById(Integer id) {
        return this.tUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TUser> queryAllByLimit(int offset, int limit) {
        return this.tUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    @Override
    public TUser insert(TUser tUser) {
        this.tUserDao.insert(tUser);
        return tUser;
    }

    /**
     * 修改数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    @Override
    public TUser update(TUser tUser) {
        this.tUserDao.update(tUser);
        return this.queryById(tUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tUserDao.deleteById(id) > 0;
    }

    @Override
    public Set<String> getRoles(String username) {
        List<String> roles = tUserDao.getRoles(username);
        return new HashSet<>(roles);
    }

    @Override
    public Set<String> getPermissions(String username) {
        List<String> permissions = tUserDao.getPermissions(username);
        return new HashSet<>(permissions);
    }

    @Override
    public TUser getByUsername(String username) {
        return tUserDao.getByUsername(username);
    }
}