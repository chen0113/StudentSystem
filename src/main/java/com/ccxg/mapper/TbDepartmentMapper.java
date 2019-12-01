package com.ccxg.mapper;

import com.ccxg.entity.TbDepartment;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbDepartmentMapper {
    @Select("select * from tb_department")
    List<TbDepartment> selectAll();

    int deleteByPrimaryKey(String departmentId);

    int insert(TbDepartment record);

    int insertSelective(TbDepartment record);

    List<TbDepartment> selectByPrimaryKey(String departmentId);

    int updateByPrimaryKeySelective(TbDepartment record);

    int updateByPrimaryKey(TbDepartment record);

    List<TbDepartment> search(TbDepartment department);
}