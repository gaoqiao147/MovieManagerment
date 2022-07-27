package com.freesoft.service;

import com.freesoft.model.MovieCollectionDO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-22
 */
public interface MovieCollectionService extends IService<MovieCollectionDO> {
    /**
     * 实现用户收藏功能
     *
     * @return 操作成功1，操作失败0
     * @param movieCollectionDO
     */
    Integer addCollection(MovieCollectionDO movieCollectionDO);
}
