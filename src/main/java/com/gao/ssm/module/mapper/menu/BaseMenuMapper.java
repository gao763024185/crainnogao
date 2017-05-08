package com.gao.ssm.module.mapper.menu;

import com.gao.ssm.module.pojo.menu.BaseMenu;
import com.gao.ssm.module.pojo.menu.BaseMenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMenuMapper {
    int countByExample(BaseMenuExample example);

    int deleteByExample(BaseMenuExample example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(BaseMenu record);

    int insertSelective(BaseMenu record);

    List<BaseMenu> selectByExample(BaseMenuExample example);

    BaseMenu selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") BaseMenu record, @Param("example") BaseMenuExample example);

    int updateByExample(@Param("record") BaseMenu record, @Param("example") BaseMenuExample example);

    int updateByPrimaryKeySelective(BaseMenu record);

    int updateByPrimaryKey(BaseMenu record);

    /*自定义*/
    List<BaseMenu> findAll();
}