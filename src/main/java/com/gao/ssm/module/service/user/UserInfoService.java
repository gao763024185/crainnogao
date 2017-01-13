package com.gao.ssm.module.service.user;


import com.gao.ssm.module.pojo.user.BaseUser;

import java.util.List;

/**
 * Created by gaobh on 2016/12/14.
 */
public interface UserInfoService {
    //验证用户登录
    BaseUser loginValid(BaseUser user);
    //输出所有用户（哈哈 就我一人儿）
    List<BaseUser> findAll();
}
