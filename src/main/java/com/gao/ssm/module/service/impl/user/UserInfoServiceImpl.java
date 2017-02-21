package com.gao.ssm.module.service.impl.user;

import com.gao.ssm.module.mapper.user.BaseUserMapper;
import com.gao.ssm.module.pojo.user.BaseUser;
import com.gao.ssm.module.service.user.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gaobh on 2016/12/14.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Resource
    private BaseUserMapper baseUserMapper;

    public BaseUser loginValid(BaseUser user){
        return baseUserMapper.loginValid(user);
    }

    public List<BaseUser> findAll(){ return baseUserMapper.findAll();}

    public  int updateByPrimaryKeySelective(BaseUser user){return baseUserMapper.updateByPrimaryKeySelective(user);}

    public  BaseUser selectByPrimaryKey(Integer id){return baseUserMapper.selectByPrimaryKey(id);}
}
