package com.freesoft.handler;

/**
 * @author zhouwei
 */
public class BaseException extends RuntimeException{
    private int code;
    private String message;

    /**
     * 自定义异常枚举构造
     * @param superEnumFace
     */
    public BaseException(SuperEnumFace superEnumFace){
        this.code = superEnumFace.getCode();
        this.message = superEnumFace.getMessage();
    }
}
