package com.freesoft.common;

import com.freesoft.enums.ExceptionEnum;
import com.freesoft.handler.SuperEnumFace;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;

/**
 * @author zhouwei
 */
@Data
@AllArgsConstructor
public class Result<T> implements Serializable {
    /**
     * 状态码
     */
    private int code;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(SuperEnumFace superEnumFace) {
        this.code = superEnumFace.getCode();
        this.message = superEnumFace.getMessage();
    }

    public Result(SuperEnumFace superEnumFace, T data) {
        this.code = superEnumFace.getCode();
        this.message = superEnumFace.getMessage();
        this.data = data;
    }

    /**
     * 服务器错误
     *
     * @param message
     * @return
     */
    public static Result error(String message) {
        if (ObjectUtils.isEmpty(message)) {
            return new Result(ExceptionEnum.ERROR);
        } else {
            return new Result(ExceptionEnum.ERROR.getCode(), message);
        }
    }

    /**
     * @param data
     * @return
     */
    public static <T> Result success(T data) {
        return new Result(ExceptionEnum.SUCCESS, data);
    }
}