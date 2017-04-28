package com.gao.ssm.module.service.impl.menu;

import com.gao.ssm.module.mapper.menu.BaseMenuMapper;
import com.gao.ssm.module.pojo.menu.BaseMenu;
import com.gao.ssm.module.pojo.menu.BaseMenuExample;
import com.gao.ssm.module.service.menu.BaseMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 高保红 on 2017/4/26.
 */
@Service
public class BaseMenuServiceImpl implements BaseMenuService {

    @Resource
    private BaseMenuMapper baseMenuMapper;
    public List<BaseMenu> selectByExample(BaseMenuExample example){
        return baseMenuMapper.selectByExample(example);
    }
    public  List<BaseMenu> findAll(){
        return baseMenuMapper.findAll();
    }
}
