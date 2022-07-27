package com.freesoft.enums;

import com.freesoft.handler.SuperEnumFace;
import lombok.AllArgsConstructor;

/**
 * @author zhouwei
 */
@AllArgsConstructor
public enum ExceptionEnum implements SuperEnumFace {
    /**
     * 基本处理字段
     */
    SUCCESS(20000, "调用接口成功"),
    FAIL(40000, "调用接口失败"),
    ERROR(50000, "服务器异常，请稍后重试"),
    ;

    private int code;
    private String message;

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
