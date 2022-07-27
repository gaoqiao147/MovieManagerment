package com.freesoft.service.impl;

import com.freesoft.model.MovieInformationDO;
import com.freesoft.mapper.MovieInformationMapper;
import com.freesoft.service.MovieInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-22
 */
@Service
public class MovieInformationServiceImpl extends ServiceImpl<MovieInformationMapper, MovieInformationDO> implements MovieInformationService {

    @Resource
    private MovieInformationMapper movieInformationMapper;

    @Override
    public List<MovieInformationDO> listAllMovieInfo() {
        List listAllMovie = movieInformationMapper.selectList(null);
        return listAllMovie;
    }

    @Override
    public Integer addMovieInfo(MovieInformationDO movieInformationDO) {
        Integer addResult = movieInformationMapper.insert(movieInformationDO);
        return addResult;
    }
}
