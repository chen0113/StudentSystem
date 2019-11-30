package com.ccxg.mapper;

import com.ccxg.entity.TbClass;

public interface TbClassMapper {
    int deleteByPrimaryKey(TbClass key);

    int insert(TbClass record);

    int insertSelective(TbClass record);
}