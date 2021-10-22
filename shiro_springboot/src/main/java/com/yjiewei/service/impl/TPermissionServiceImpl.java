package com.yjiewei.service.impl;

import com.yjiewei.entity.TPermission;
import com.yjiewei.dao.TPermissionDao;
import com.yjiewei.service.TPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TPermission)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 12:45:53
 */
@Service("permissionService")
public class TPermissionServiceImpl implements TPermissionService {
    @Resource
    private TPermissionDao tPermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TPermission queryById(Integer id) {
        return this.tPermissionDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TPermission> queryAllByLimit(int offset, int limit) {
        return this.tPermissionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tPermission 实例对象
     * @return 实例对象
     */
    @Override
    public TPermission insert(TPermission tPermission) {
        this.tPermissionDao.insert(tPermission);
        return tPermission;
    }

    /**
     * 修改数据
     *
     * @param tPermission 实例对象
     * @return 实例对象
     */
    @Override
    public TPermission update(TPermission tPermission) {
        this.tPermissionDao.update(tPermission);
        return this.queryById(tPermission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tPermissionDao.deleteById(id) > 0;
    }
}