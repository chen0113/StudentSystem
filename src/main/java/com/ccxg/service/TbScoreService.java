package com.ccxg.service;

import com.ccxg.entity.TbScore;

import java.util.List;

public interface TbScoreService {

    List<TbScore> getAll();

    List<TbScore> getByStudent(TbScore tbScore);

    Integer addScore(TbScore tbScore);
}
