package com.ccxg.service.impl;

import com.ccxg.entity.TbCourse;
import com.ccxg.entity.TbStudent;
import com.ccxg.mapper.TbCourseMapper;
import com.ccxg.service.TbCourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbCourseServiceImpl implements TbCourseService {
    @Resource
    private TbCourseMapper tbCourseMapper;

    @Override
    public List<TbCourse> findByMap() {
        List<TbCourse> list = tbCourseMapper.selectAll();
        return list;
    }

    @Override
    public int insert(TbCourse course) {
        return tbCourseMapper.insert(course);
    }

    @Override
    public int deleteByCourse(TbCourse course) {
        return tbCourseMapper.deleteByPrimaryKey(course);
    }

    @Override
    public List<TbCourse> selectByCourse(TbCourse course) {
        List<TbCourse> list = tbCourseMapper.selectByCourse(course);
        return list;
    }

    @Override
    public List<TbCourse> search(TbCourse course) {
        List<TbCourse> list = tbCourseMapper.search(course);
        return list;
    }

}
