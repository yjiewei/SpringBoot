package com.yjiewei.service;

import com.yjiewei.entity.TUser;
import java.util.List;
import java.util.Set;

/**
 * (TUser)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 12:46:27
 */
public interface TUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TUser queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    TUser insert(TUser tUser);

    /**
     * 修改数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    TUser update(TUser tUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 通过用户名返回角色集
     * @param username 用户名
     * @return
     */
    Set<String> getRoles(String username);

    /**
     * 通过用户名获取对应的权限
     * @param username
     * @return
     */
    Set<String> getPermissions(String username);

    /**
     * 通过用户名返回对应的用户
     * @param username
     * @return
     */
    TUser getByUsername(String username);

}