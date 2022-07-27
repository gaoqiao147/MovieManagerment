package com.freesoft.service;

import com.freesoft.dto.UserDTO;
import com.freesoft.model.MovieUserinfoDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.freesoft.vo.MovieNameVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-22
 */
public interface MovieUserinfoService extends IService<MovieUserinfoDO> {
    /**
     * 通过用户id查询该用户收藏的电影
     *
     * @param uid
     * @return
     */
    List<MovieNameVO> getCollectionMovieByUId(Integer uid);

    /**
     * 通过姓名查询数据库
     *
     * @param username
     * @return
     */
    MovieUserinfoDO queryUserByName(String username);

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    Integer insertUser(MovieUserinfoDO user);
}
