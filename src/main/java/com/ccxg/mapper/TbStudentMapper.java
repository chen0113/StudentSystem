package com.ccxg.mapper;

import com.ccxg.entity.TbStudent;

public interface TbStudentMapper {
    int deleteByPrimaryKey(String studentId);

    int insert(TbStudent record);

    int insertSelective(TbStudent record);

    TbStudent selectByPrimaryKey(String studentId);

    int updateByPrimaryKeySelective(TbStudent record);

    int updateByPrimaryKey(TbStudent record);
}