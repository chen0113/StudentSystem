package com.ccxg.service;

import com.ccxg.entity.TbStudent;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TbStudentService {
    PageInfo<TbStudent> findByMap();
    int insert(TbStudent student);
    int update(TbStudent student);
    int deleteById(String id);
    List<TbStudent> selectByPrimaryKey(String id);
    List<TbStudent> search(TbStudent student);
}
