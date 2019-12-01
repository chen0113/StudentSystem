package com.ccxg.service.impl;

import com.ccxg.entity.TbDepartment;
import com.ccxg.mapper.TbDepartmentMapper;
import com.ccxg.service.TbDepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbDepartmentServiceImpl implements TbDepartmentService {
    @Resource
    private TbDepartmentMapper tbDepartmentMapper;

    @Override
    public List<TbDepartment> findByMap() {
        List<TbDepartment> list = tbDepartmentMapper.selectAll();
        return list;
    }

    @Override
    public int insert(TbDepartment department) {
        return tbDepartmentMapper.insert(department);
    }

    @Override
    public int update(TbDepartment department){
        return tbDepartmentMapper.updateByPrimaryKeySelective(department);
    }

    @Override
    public int deleteById(String id){
        return tbDepartmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TbDepartment> selectById(String id){
        List<TbDepartment> list = tbDepartmentMapper.selectByPrimaryKey(id);
        return list;
    }

    @Override
    public List<TbDepartment> search(TbDepartment department){
        List<TbDepartment> list = tbDepartmentMapper.search(department);
        return list;
    }
}
