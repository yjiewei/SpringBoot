package com.yjiewei.exception;

import com.yjiewei.constant.BusinessMsgEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 4.2自定义业务异常，待会抛这个异常，全局异常处理拦截返回对应的枚举信息
 * @author yjiewei
 * @date 2021/8/11
 */
@Getter
@Setter
public class BusinessErrorException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    /**
     * 异常码 异常信息
     */
    private String code;
    private String msg;

    /**
     * 通过创建枚举对象来创建异常的内部信息，由于枚举类是单例且私有（本来就私有），
     * 所以你要抛出你只有抛出我内部一定定义好的
     * @param businessMsgEnum 枚举类实例对象信息
     */
    public BusinessErrorException(BusinessMsgEnum businessMsgEnum){
        this.code = businessMsgEnum.getCode();
        this.msg = businessMsgEnum.getMsg();
    }
}
