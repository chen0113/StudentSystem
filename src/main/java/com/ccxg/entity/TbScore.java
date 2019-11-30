package com.ccxg.entity;

import java.io.Serializable;

/**
 * tb_score
 * @author 
 */
public class TbScore implements Serializable {
    private String courseName;

    private String studentId;

    private static final long serialVersionUID = 1L;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}