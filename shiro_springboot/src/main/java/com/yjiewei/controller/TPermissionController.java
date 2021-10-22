package com.yjiewei.controller;

import com.yjiewei.entity.TPermission;
import com.yjiewei.service.TPermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TPermission)表控制层
 *
 * @author makejava
 * @since 2021-10-22 12:45:54
 */
@RestController
@RequestMapping("tPermission")
public class TPermissionController {
    /**
     * 服务对象
     */
    @Resource
    private TPermissionService tPermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TPermission selectOne(Integer id) {
        return this.tPermissionService.queryById(id);
    }

}