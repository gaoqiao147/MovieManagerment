package com.freesoft.service;

import com.freesoft.model.MovieTreeDO;

import java.util.List;

/**
 * @author zhouwei
 */
public interface MovieTreeService {
    /**
     * 获取电影分类菜单树
     * @return
     */
    List<MovieTreeDO> movieMenuTree();
}
