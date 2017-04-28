package com.gao.ssm.module.service.menu;

import com.gao.ssm.module.pojo.menu.BaseMenu;
import com.gao.ssm.module.pojo.menu.BaseMenuExample;

import java.util.List;

/**
 * Created by 高保红 on 2017/4/26.
 */
public interface BaseMenuService {

    List<BaseMenu> selectByExample(BaseMenuExample example);
    List<BaseMenu> findAll();
}
