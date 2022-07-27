package com.freesoft.service.impl;

import com.freesoft.model.MovieCategoryDO;
import com.freesoft.mapper.MovieCategoryMapper;
import com.freesoft.service.MovieCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
public class MovieCategoryServiceImpl extends ServiceImpl<MovieCategoryMapper, MovieCategoryDO> implements MovieCategoryService {

    @Resource
    private MovieCategoryMapper movieCategoryMapper;

    @Override
    public List<MovieCategoryDO> listAllCategory() {
        List listAllCategory = movieCategoryMapper.selectList(null);
        return listAllCategory;
    }

    @Override
    public Integer addCategory(MovieCategoryDO movieCategoryDO) {
        Integer addResult = movieCategoryMapper.insert(movieCategoryDO);
        return addResult;
    }
}
