package com.ccxg.mapper;

import com.ccxg.entity.TbMajor;

public interface TbMajorMapper {
    int deleteByPrimaryKey(String majorId);

    int insert(TbMajor record);

    int insertSelective(TbMajor record);

    TbMajor selectByPrimaryKey(String majorId);

    int updateByPrimaryKeySelective(TbMajor record);

    int updateByPrimaryKey(TbMajor record);
}