package com.ccxg.mapper;

import com.ccxg.entity.TbScore;

public interface TbScoreMapper {
    int deleteByPrimaryKey(TbScore key);

    int insert(TbScore record);

    int insertSelective(TbScore record);

    TbScore selectByPrimaryKey(TbScore key);

    int updateByPrimaryKeySelective(TbScore record);

    int updateByPrimaryKey(TbScore record);
}