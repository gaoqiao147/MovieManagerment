package com.freesoft.mapper;

import com.freesoft.model.MovieUserinfoDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.freesoft.vo.MovieNameVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-22
 */
public interface MovieUserinfoMapper extends BaseMapper<MovieUserinfoDO> {
    /**
     * 获取收藏电影
     *
     * @param uid
     * @return
     */
    List<MovieNameVO> getCollectionMovie(@Param("uid") Integer uid);
}
