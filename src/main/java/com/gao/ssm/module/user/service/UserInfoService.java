package com.gao.ssm.module.user.service;

import com.youmeek.ssm.module.user.pojo.BaseUser;

/**
 * Created by 孙皓 on 2016/12/14.
 */
public interface UserInfoService {
    BaseUser loginValid(BaseUser user);
}
