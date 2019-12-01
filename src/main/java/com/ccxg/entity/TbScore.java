package com.ccxg.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * tb_score
 * @author 
 */
public class TbScore implements Serializable {
    private String studentName;

    private String studentId;

    private String courseName;

    private BigDecimal score;

    private static final long serialVersionUID = 1L;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
}