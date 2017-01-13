package com.gao.ssm.module.mapper.user;

import com.gao.ssm.module.pojo.user.BaseUser;

import java.util.List;

public interface BaseUserMapper {

    int deleteByPrimaryKey(Integer uid);

    int insert(BaseUser record);

    int insertSelective(BaseUser record);

    BaseUser selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(BaseUser record);

    int updateByPrimaryKey(BaseUser record);

    /* 自定义 start*/
    BaseUser loginValid (BaseUser user);

    List<BaseUser> findAll();
    /* 自定义 end*/
}