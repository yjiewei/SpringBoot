package com.yjiewei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yjiewei
 * @date 2021/8/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blogger {
    private Long id;
    private String name;
    private String pass;
}
