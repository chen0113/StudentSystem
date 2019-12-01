package com.ccxg.service.impl;

import com.ccxg.entity.TbMajor;
import com.ccxg.mapper.TbMajorMapper;
import com.ccxg.service.TbMajorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class TbMajorServiceImpl implements TbMajorService {

    @Resource
    private TbMajorMapper tbMajorMapper;

    @Override
    public List<TbMajor> findByDepartmentId(String departmentId) {
        List<TbMajor> list = tbMajorMapper.selectAll(departmentId);
        return list;
    }

    @Override
    public TbMajor selectById(String majorId) {
        return tbMajorMapper.selectById(majorId);
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
