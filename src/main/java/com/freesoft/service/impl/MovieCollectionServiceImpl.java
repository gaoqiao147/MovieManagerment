package com.freesoft.service.impl;

import com.freesoft.enums.ExceptionEnum;
import com.freesoft.handler.BaseException;
import com.freesoft.model.MovieCollectionDO;
import com.freesoft.mapper.MovieCollectionMapper;
import com.freesoft.service.MovieCollectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouwei
 * @since 2022-07-22
 */
@Service
public class MovieCollectionServiceImpl extends ServiceImpl<MovieCollectionMapper, MovieCollectionDO> implements MovieCollectionService {

    @Resource
    private MovieCollectionMapper movieCollectionMapper;

    @Override
    public Integer addCollection(MovieCollectionDO movieCollectionDO) {
        Integer addResult = movieCollectionMapper.insert(movieCollectionDO);
        return addResult;
    }
}
