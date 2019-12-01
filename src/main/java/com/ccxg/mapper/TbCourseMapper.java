package com.ccxg.mapper;

import com.ccxg.entity.TbCourse;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TbCourseMapper {
    @Select("select * from tb_course")
    List<TbCourse> selectAll();

    int deleteByPrimaryKey(TbCourse key);

    int insert(TbCourse record);

    int insertSelective(TbCourse record);

    @Select("select Course_Name from tb_course where Major_ID=#{majorId} and Grade=#{grade}")
    List<String> selectByCourse(TbCourse course);

    List<TbCourse> search(TbCourse course);
}