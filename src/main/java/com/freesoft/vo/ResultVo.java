package com.freesoft.vo;

import lombok.Data;

/**
 * @author zhouwei
 */
@Data
public class ResultVo<T> {
    private Integer code;
    private String message;
    private T data;
}
