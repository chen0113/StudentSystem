package com.ccxg.service;

import com.ccxg.entity.TbMajor;

import java.util.List;

public interface TbMajorService {
    List<TbMajor> findByDepartmentId(String departmentId);
    int insert(TbMajor major);
    int deleteById(String id);
}
