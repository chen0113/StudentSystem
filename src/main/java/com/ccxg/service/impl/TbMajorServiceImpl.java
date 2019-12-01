package com.ccxg.service.impl;

import com.ccxg.entity.TbMajor;
import com.ccxg.mapper.TbMajorMapper;
import com.ccxg.service.TbMajorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbMajorServiceImpl implements TbMajorService {

    @Resource
    private TbMajorMapper tbMajorMapper;

    @Override
    public List<TbMajor> findByDepartmentId(String departmentId) {
        List<TbMajor> list = tbMajorMapper.selectAll(departmentId);
        return list;
    }

    @Override
    public int insert(TbMajor major) {
        return tbMajorMapper.insert(major);
    }

    @Override
    public int deleteById(String id){
        return tbMajorMapper.deleteByPrimaryKey(id);
    }

}
