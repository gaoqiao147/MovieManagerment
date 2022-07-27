package com.freesoft.handler;

/**
 * 定义异常枚举接口
 *
 * @author zhouwei
 */
public interface SuperEnumFace {
    /**
     * 获取状态码
     * @return
     */
    int getCode();

    /**
     * 获取响应消息
     * @return
     */
    String getMessage();

}
