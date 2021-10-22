package com.yjiewei.dao;

import com.yjiewei.entity.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TUser)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 12:46:27
 */
public interface TUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TUser queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tUser 实例对象
     * @return 对象列表
     */
    List<TUser> queryAll(TUser tUser);

    /**
     * 新增数据
     *
     * @param tUser 实例对象
     * @return 影响行数
     */
    int insert(TUser tUser);

    /**
     * 修改数据
     *
     * @param tUser 实例对象
     * @return 影响行数
     */
    int update(TUser tUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 通过用户名来获取角色列表
     * @param username
     * @return
     */
    List<String> getRoles(String username);

    /**
     * 通过用户名来获取权限
     * @param username
     * @return
     */
    List<String> getPermissions(String username);

    /**
     * 通过用户名查询数据
     *
     * @param username
     * @return 实例对象
     */
    TUser getByUsername(String username);

}