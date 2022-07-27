package com.freesoft.service.impl;

import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;

/**
 * @author zhouwei
 */
public class CopySql {
    @Resource
    private SqlSessionFactory sqlSessionFactory;
    /**
     * getBoundSql()需要传入dao层方法对应的形参
     */
    String sql = sqlSessionFactory.getConfiguration().getMappedStatement("com.freesoft.mapper.MovieUserinfoMapper.getCollectionMovie").getBoundSql("uid").getSql();

}
