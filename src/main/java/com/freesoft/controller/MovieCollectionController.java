package com.freesoft.controller;

import com.freesoft.model.MovieCollectionDO;
import com.freesoft.service.MovieCollectionService;
import com.freesoft.common.CommonResult;
import com.freesoft.vo.CollectionInfo;
import com.freesoft.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-22
 */
@RestController
@Api(value = "电影收藏操作", tags = "movieCollectionController")
@RequestMapping("/movie-collection")
public class MovieCollectionController {
    @Resource
    private MovieCollectionService movieCollectionService;

    @PostMapping("/add-collection")
    @ApiOperation(value = "添加用户收藏", notes = "添加用户收藏", produces = "application/json")
    public ResultVo addCollection(@RequestBody CollectionInfo collectionInfo) {
        //获取当前时间
        Date currentDate = new Date();
        MovieCollectionDO movieCollectionDO = new MovieCollectionDO();
        movieCollectionDO.setDate(currentDate).setMid(collectionInfo.getMid()).setUid(collectionInfo.getUid());
        try {
            Integer res= movieCollectionService.addCollection(movieCollectionDO);
            return CommonResult.success(res);
        } catch (Exception e) {
            return CommonResult.fail(null);
        }
    }
}

