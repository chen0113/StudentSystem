package com.ccxg.service.impl;

import com.ccxg.entity.TbStudent;
import com.ccxg.mapper.TbStudentMapper;
import com.ccxg.service.TbStudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class TbStudentServiceImpl implements TbStudentService {
    @Resource
    private TbStudentMapper tbStudentMapper;

    @Override
    public PageInfo<TbStudent> findByMap(String pageNum, String pageSize) {
        PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        List<TbStudent> list = tbStudentMapper.selectAll();
        PageInfo<TbStudent> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int insert(TbStudent student) {
        return tbStudentMapper.insertSelective(student);
    }

    @Override
    public int update(TbStudent student){
        return tbStudentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public int deleteById(String id){
        return tbStudentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TbStudent> selectByPrimaryKey(String id){
        List<TbStudent> list = tbStudentMapper.selectByPrimaryKey(id);
        return list;
    }

    @Override
    public List<TbStudent> search(TbStudent student){
        List<TbStudent> list = tbStudentMapper.search(student);
        return list;
    }
}
