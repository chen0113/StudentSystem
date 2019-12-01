package com.ccxg.mapper;

import com.ccxg.entity.TbStudent;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TbStudentMapper {

    @Select("select * from tb_student")
    List<TbStudent> selectAll();

    int deleteByPrimaryKey(String studentId);

    int insert(TbStudent record);

    int insertSelective(TbStudent record);

    int updateByPrimaryKeySelective(TbStudent student);

    List<TbStudent> selectByPrimaryKey(String studentId);

    List<TbStudent> search(TbStudent student);

}