package com.ccxg.entity;

import java.io.Serializable;

/**
 * tb_course
 * @author 
 */
public class TbCourse implements Serializable {
    private String courseId;

    private String courseName;

    private String majorId;

    private Integer grade;

    private Integer pageNum;

    private Integer pageSize;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


    private static final long serialVersionUID = 1L;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbCourse other = (TbCourse) that;
        return (this.getCourseName() == null ? other.getCourseName() == null : this.getCourseName().equals(other.getCourseName()))
            && (this.getMajorId() == null ? other.getMajorId() == null : this.getMajorId().equals(other.getMajorId()))
            && (this.getGrade() == null ? other.getGrade() == null : this.getGrade().equals(other.getGrade()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCourseName() == null) ? 0 : getCourseName().hashCode());
        result = prime * result + ((getMajorId() == null) ? 0 : getMajorId().hashCode());
        result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", courseName=").append(courseName);
        sb.append(", majorId=").append(majorId);
        sb.append(", grade=").append(grade);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}