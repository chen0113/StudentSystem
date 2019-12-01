package com.ccxg.mapper;

import com.ccxg.entity.TbCourse;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbCourseMapper {
    @Select("select * from tb_course")
    List<TbCourse> selectAll();

    int deleteByPrimaryKey(TbCourse key);

    int insert(TbCourse record);

    int insertSelective(TbCourse record);

    @Select("select * from tb_course where Course_Name=#{course.getCourseName} and Major_ID=#{course.getMajorId} and Grade=#{course.getGrade}")
    List<TbCourse> selectByCourse(TbCourse course);

    List<TbCourse> search(TbCourse course);
}