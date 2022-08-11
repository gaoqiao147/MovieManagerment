package com.freesoft.controller;

import com.freesoft.model.MovieTreeDO;
import com.freesoft.service.MovieTreeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhouwei
 */
@RestController
@RequestMapping("/movie-tree")
public class MovieTreeController {
    @Resource
    MovieTreeService movieTreeService;

    @GetMapping("/menu")
    public List<MovieTreeDO> menu(){
        return movieTreeService.movieMenuTree();
    }
}
