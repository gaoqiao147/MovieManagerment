package com.freesoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.freesoft.dto.UserDTO;
import com.freesoft.model.MovieUserinfoDO;
import com.freesoft.mapper.MovieUserinfoMapper;
import com.freesoft.service.MovieUserinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.freesoft.vo.MovieNameVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-22
 */
@Service
public class MovieUserinfoServiceImpl extends ServiceImpl<MovieUserinfoMapper, MovieUserinfoDO> implements MovieUserinfoService {
    @Resource
    private MovieUserinfoMapper movieUserinfoMapper;

    @Override
    public List<MovieNameVO> getCollectionMovieByUId(Integer uid) {
        List listCollectionMovieByUId = movieUserinfoMapper.getCollectionMovie(uid);
        return listCollectionMovieByUId;
    }

    @Override
    public MovieUserinfoDO queryUserByName(String username) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        MovieUserinfoDO user = movieUserinfoMapper.selectOne(queryWrapper);
        return user;
    }

    @Override
    public Integer insertUser(MovieUserinfoDO user) {
        Integer res = movieUserinfoMapper.insert(user);
        return res;
    }
}
