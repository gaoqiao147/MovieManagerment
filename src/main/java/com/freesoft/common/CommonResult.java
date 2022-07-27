package com.freesoft.common;

import com.freesoft.vo.ResultVo;

import java.util.List;

/**
 * 配置公共返回方法
 *
 * @author zhouwei
 */
public class CommonResult {
    public static ResultVo success(Object object) {
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setCode(1);
        resultVo.setMessage("成功！");
        resultVo.setData(object);
        return resultVo;
    }

    public static ResultVo fail(Object object) {
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setCode(-1);
        resultVo.setMessage("失败！");
        resultVo.setData(object);
        return resultVo;
    }

    public static ResultVo resultInt(Integer res,String message) {
        if (res > 0) {
            return CommonResult.success(res);
        } else {
            return CommonResult.fail(message);
        }
    }

    public static ResultVo resultList(List res) {
        if (null == res) {
            return CommonResult.fail(null);
        } else {
            return CommonResult.success(res);
        }
    }
}
