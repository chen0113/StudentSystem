package com.ccxg.service.impl;

import com.ccxg.entity.TbScore;
import com.ccxg.entity.TbStudent;
import com.ccxg.mapper.TbScoreMapper;
import com.ccxg.mapper.TbStudentMapper;
import com.ccxg.service.TbScoreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class TbScoreServiceImpl implements TbScoreService {

    @Resource
    private TbScoreMapper tbScoreMapper;

    @Resource
    private TbStudentMapper tbStudentMapper;

    @Override
    public List<TbScore> getAll() {

        return tbScoreMapper.selectAll();
    }

    @Override
    public List<TbScore> getByStudent(TbScore tbScore) {

        return tbScoreMapper.selectByStudent(tbScore);
    }

    @Override
    public Integer addScore(TbScore tbScore) {

        return tbScoreMapper.addScore(tbScore);
    }

    @Override
    public Integer updateScore(TbScore tbScore) {

        return tbScoreMapper.updateScore(tbScore);
    }

    @Override
    public Integer deleteScore(TbScore tbScore) {

        return tbScoreMapper.deleteScore(tbScore);
    }
}
