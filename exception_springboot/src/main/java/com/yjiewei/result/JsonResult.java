package com.yjiewei.result;

import lombok.Data;

/**
 * 简化，没有返回数据，主要用来处理异常
 * @author yjiewei
 * @date 2021/8/6
 */
@Data
public class JsonResult {
    private String code;
    private String msg;
    /**
     * 若没有数据返回，默认状态码为0，提示信息为：操作成功！
     */
    public JsonResult() {
        this.code = "0";
        this.msg = "操作成功！";
    }
    /**
     * 若没有数据返回，可以人为指定状态码和提示信息
     * @param code
     * @param msg
     */
    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
