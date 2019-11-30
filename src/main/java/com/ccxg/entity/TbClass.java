package com.ccxg.entity;

import java.io.Serializable;

/**
 * tb_class
 * @author 
 */
public class TbClass implements Serializable {
    private Integer classId;

    private Integer grade;

    private String majorId;

    private static final long serialVersionUID = 1L;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }
}