package com.ccxg.mapper;

import com.ccxg.entity.TbDepartment;

public interface TbDepartmentMapper {
    int deleteByPrimaryKey(String departmentId);

    int insert(TbDepartment record);

    int insertSelective(TbDepartment record);

    TbDepartment selectByPrimaryKey(String departmentId);

    int updateByPrimaryKeySelective(TbDepartment record);

    int updateByPrimaryKey(TbDepartment record);
}