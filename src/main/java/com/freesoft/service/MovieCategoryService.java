package com.freesoft.service;

import com.freesoft.model.MovieCategoryDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-22
 */
public interface MovieCategoryService extends IService<MovieCategoryDO> {
    /**
     * 获取电影类别信息
     *
     * @return 所有电影类别
     */
    List<MovieCategoryDO> listAllCategory();

    /**
     * 添加电影分类操作
     *
     * @param movieCategoryDO
     * @return
     */
    Integer addCategory(MovieCategoryDO movieCategoryDO);
}
