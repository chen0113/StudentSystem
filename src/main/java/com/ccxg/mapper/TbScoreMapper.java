package com.ccxg.mapper;

import com.ccxg.entity.TbScore;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TbScoreMapper {

    @Select("select * from tb_score")
    List<TbScore> selectAll();

    List<TbScore> selectByStudent(TbScore tbScore);

    @Insert("insert into tb_score (Student_ID, Student_Name, Course_Name, Score) values(#{studentId}, #{studentName}, #{courseName}, #{score})")
    Integer addScore(TbScore tbScore);

    @Update("update tb_score set Score = #{score}")
    Integer updateScore(TbScore tbScore);

    @Delete("delete from tb_score where Student_ID = #{studentId} and Course_Name = #{courseName}")
    Integer deleteScore(TbScore tbScore);
}