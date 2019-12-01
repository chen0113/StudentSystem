package com.ccxg.mapper;

import com.ccxg.entity.TbMajor;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbMajorMapper {
    @Select("select * from tb_major where Department_ID = #{departmentId}")
    List<TbMajor> selectAll(@Param("departmentId") String departmentId);

    @Select("select * from tb_major where Major_ID = #{majorId}")
    TbMajor selectById(@Param("majorId") String majorId);

    int deleteByPrimaryKey(String majorId);

    int insert(TbMajor record);

    int insertSelective(TbMajor record);

    TbMajor selectByPrimaryKey(String majorId);

    int updateByPrimaryKeySelective(TbMajor record);

    int updateByPrimaryKey(TbMajor record);
}