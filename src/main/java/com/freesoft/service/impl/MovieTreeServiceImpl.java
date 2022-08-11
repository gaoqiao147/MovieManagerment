package com.freesoft.service.impl;

import com.freesoft.mapper.MovieTreeMapper;
import com.freesoft.model.MovieTreeDO;
import com.freesoft.service.MovieTreeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouwei
 */
@Service
public class MovieTreeServiceImpl implements MovieTreeService {
    @Resource
    MovieTreeMapper movieTreeMapper;

    @Override
    public List<MovieTreeDO> movieMenuTree() {
        //定义一个存放父目录的数组
        List<MovieTreeDO> parentMenu = new ArrayList<>();
        //定义一个存放子目录的数组
        List<MovieTreeDO> childrenMenu = new ArrayList<>();
        //获取所有菜单
        List<MovieTreeDO> listAllMenu = movieTreeMapper.listAllMenu();
        //循环获取顶级菜单
        for (MovieTreeDO movieTreeDO : listAllMenu) {
            if (movieTreeDO.getParentID() == 0) {
                parentMenu.add(movieTreeDO);
            }
        }
        //递归查询子节点
        for (MovieTreeDO movieTreeDO : parentMenu) {
            int id = movieTreeDO.getId();
            childrenMenu = getChildren(id, parentMenu);
            movieTreeDO.setChildrenList(childrenMenu);
        }
        return parentMenu;
    }

    public List<MovieTreeDO> getChildren(Integer id, List<MovieTreeDO> list) {
        //获取所有菜单
        List<MovieTreeDO> listAllMenu = movieTreeMapper.listAllMenu();
        //定义一个存放子目录的数组
        List<MovieTreeDO> childrenMenu = new ArrayList<>();
        for (MovieTreeDO movie : listAllMenu) {
            if (movie.getParentID().equals(id)) {
                childrenMenu.add(movie);
            }
        }
        //判断子目录是否还有子目录
        for (MovieTreeDO movieTreeDO : childrenMenu) {
            movieTreeDO.setChildrenList(getChildren(movieTreeDO.getId(), listAllMenu));
        }
        if (childrenMenu.size() == 0) {
            return new ArrayList<>();
        }
        return childrenMenu;
    }
}
