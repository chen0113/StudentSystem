package com.ccxg.service;

import com.ccxg.entity.TbCourse;

import java.util.List;

public interface TbCourseService {
    List<TbCourse> findByMap();
    int insert(TbCourse course);
    int deleteByCourse(TbCourse course);
    List<TbCourse> selectByCourse(TbCourse course);
    List<TbCourse> search(TbCourse course);
}
