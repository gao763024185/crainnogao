package com.gao.ssm.module.mapper.user;

import com.gao.ssm.module.pojo.user.BaseUser;
import com.gao.ssm.module.pojo.user.BaseUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseUserMapper {

    int countByExample(BaseUserExample example);

    int deleteByExample(BaseUserExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(BaseUser record);

    int insertSelective(BaseUser record);

    List<com.gao.ssm.module.pojo.user.BaseUser> selectByExample(com.gao.ssm.module.pojo.user.BaseUserExample example);

    BaseUser selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") com.gao.ssm.module.pojo.user.BaseUser record, @Param("example") com.gao.ssm.module.pojo.user.BaseUserExample example);

    int updateByExample(@Param("record") com.gao.ssm.module.pojo.user.BaseUser record, @Param("example") com.gao.ssm.module.pojo.user.BaseUserExample example);

    int updateByPrimaryKeySelective(BaseUser record);

    int updateByPrimaryKey(BaseUser record);

    /* 自定义 start*/
    BaseUser loginValid (BaseUser user);

    List<BaseUser> findAll();
    /* 自定义 end*/
}