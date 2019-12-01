package com.ccxg.service;

import com.ccxg.entity.TbCourse;

import java.util.List;
import java.util.Map;

public interface TbCourseService {
    List<TbCourse> findByMap();
    int insert(TbCourse course);
    int deleteByCourse(TbCourse course);
    List<String> selectByCourse(TbCourse course);
    List<TbCourse> search(TbCourse course);
}
