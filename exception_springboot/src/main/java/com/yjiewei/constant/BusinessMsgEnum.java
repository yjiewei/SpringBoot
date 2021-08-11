package com.yjiewei.constant;

import lombok.Getter;

/**
 * 4.1业务异常提示信息枚举类
 * @author yjiewei
 * @date 2021/8/11
 */
@Getter
public enum BusinessMsgEnum {
    /**
     * 102 参数异常
     */
    PARAMETER_EXCEPTION("102", "参数异常！"),

    /**
     * 103 等待超时
     */
    SERVICE_TIMEOUT("103", "服务调用超时！"),

    /**
     * 102 参数过大
     */
    PARAMETER_BIG_EXCEPTION("102", "你咋这么多参数，搞错了吧！"),

    /**
     * 500 其他异常
     */
    UNEXPECTED_EXCEPTION("500", "系统异常，请找管理员处理！");

    // 可以接着自定义其他异常

    private String code; // 消息码
    private String msg;  // 消息内容

    private BusinessMsgEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
