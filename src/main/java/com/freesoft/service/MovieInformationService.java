package com.freesoft.service;

import com.freesoft.mapper.MovieInformationMapper;
import com.freesoft.model.MovieCategoryDO;
import com.freesoft.model.MovieInformationDO;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-22
 */
public interface MovieInformationService extends IService<MovieInformationDO> {
    /**
     * 获取所有电影信息
     *
     * @return 所有电影类别
     */
    List<MovieInformationDO> listAllMovieInfo();

    /**
     * 添加电影详情操作
     *
     * @param movieInformationDO
     * @return
     */
    Integer addMovieInfo(MovieInformationDO movieInformationDO);
}
