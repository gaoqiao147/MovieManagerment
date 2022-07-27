package com.freesoft.controller;

import com.freesoft.model.MovieUserinfoDO;
import com.freesoft.service.MovieUserinfoService;
import com.freesoft.common.CommonResult;
import com.freesoft.vo.MovieNameVO;
import com.freesoft.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-22
 */
@RestController
@Validated
@Api(value = "查询收藏操作", tags = "movieUserController")
@RequestMapping("/userinfo")
public class MovieUserinfoController {
    @Resource
    private MovieUserinfoService movieUserinfoService;

    @GetMapping("/get-movie-by-uid")
    @ApiOperation(value = "查询用户电影收藏", notes = "查询电影收藏")
    public ResultVo getCollection(@RequestParam("uid") Integer uid) {
        List<MovieNameVO> list = movieUserinfoService.getCollectionMovieByUId(uid);
        return CommonResult.resultList(list);
    }

    @PostMapping("/add-user")
    public ResultVo addUser(@RequestBody @Validated MovieUserinfoDO user, BindingResult result) {
        String ps = new Md5Hash(user.getPassword(), "salt", 2).toString();
        user.setPassword(ps);
        //获取参数校验信息
        String message = result.getFieldError().getDefaultMessage();
        if(result.hasErrors()){
            return CommonResult.resultInt(-1,message);
        }else{
            Integer res = movieUserinfoService.insertUser(user);
            return CommonResult.resultInt(res,message);
        }
    }
}

