package com.freesoft.controller;


import com.freesoft.model.MovieCategoryDO;
import com.freesoft.service.MovieCategoryService;
import com.freesoft.common.CommonResult;
import com.freesoft.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-22
 */

@RestController
@RequestMapping("/movie-category")
public class MovieCategoryController {

    @Resource
    private MovieCategoryService movieCategoryService;

    @GetMapping("/get-all-category")
    @ApiOperation(value = "获取电影全部类别", notes = "获取全部电影类别")
    public ResultVo getAllCategory(){
        List list = movieCategoryService.listAllCategory();
        if(null == list){
            return CommonResult.fail(null);
        }else{
            return CommonResult.success(list);
        }
    }

    @PostMapping("/add-category")
    @ApiOperation(value = "添加电影分类", notes = "添加电影分类", produces = "application/json")
    public ResultVo addCategory(@ApiParam(name = "传入电影类别信息" , value = "传入json数据格式") @RequestBody MovieCategoryDO movieCategoryDO){
        Integer addResult = movieCategoryService.addCategory(movieCategoryDO);
        if(addResult > 0){
            return CommonResult.success("添加电影分类成功");
        }else{
            return CommonResult.fail(null);
        }
    }
}

