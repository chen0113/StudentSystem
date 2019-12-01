package com.ccxg.service;

import com.ccxg.entity.TbDepartment;

import java.util.List;

public interface TbDepartmentService {
    List<TbDepartment> findByMap();
    int insert(TbDepartment department);
    int update(TbDepartment department);
    int deleteById(String id);
    List<TbDepartment> selectById(String id);
    List<TbDepartment> search(TbDepartment department);
}
