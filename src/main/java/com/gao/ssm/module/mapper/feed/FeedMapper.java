package com.gao.ssm.module.mapper.feed;

import com.gao.ssm.module.pojo.feed.Feed;

public interface FeedMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Feed record);

    int insertSelective(Feed record);

    Feed selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Feed record);

    int updateByPrimaryKey(Feed record);
}