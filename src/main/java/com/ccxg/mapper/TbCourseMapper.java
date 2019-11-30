package com.ccxg.mapper;

import com.ccxg.entity.TbCourse;

public interface TbCourseMapper {
    int deleteByPrimaryKey(TbCourse key);

    int insert(TbCourse record);

    int insertSelective(TbCourse record);
}