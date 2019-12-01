package com.ccxg.mapper;

import com.ccxg.entity.TbScore;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbScoreMapper {

    @Select("select * from tb_score")
    List<TbScore> selectAll();

    List<TbScore> selectByStudent(TbScore tbScore);

    @Insert("insert into tb_score (Student_ID, Student_Name, Course_Name, Score) values(#{studentId}, #{studentName}, #{courseName}, #{score})")
    Integer addScore(TbScore tbScore);
}