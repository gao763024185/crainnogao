package com.gao.ssm.module.user.service.impl;

import com.youmeek.ssm.module.user.mapper.BaseUserMapper;
import com.youmeek.ssm.module.user.pojo.BaseUser;
import com.youmeek.ssm.module.user.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 孙皓 on 2016/12/14.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Resource
    private BaseUserMapper baseUserMapper;

    public BaseUser loginValid(BaseUser user){
        return baseUserMapper.loginValid(user);
    }
}
