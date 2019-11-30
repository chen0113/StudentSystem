package com.ccxg.entity;

import java.io.Serializable;

/**
 * tb_major
 * @author 
 */
public class TbMajor implements Serializable {
    private String majorId;

    private String majorName;

    private String departmentId;

    private static final long serialVersionUID = 1L;

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
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
        TbMajor other = (TbMajor) that;
        return (this.getMajorId() == null ? other.getMajorId() == null : this.getMajorId().equals(other.getMajorId()))
            && (this.getMajorName() == null ? other.getMajorName() == null : this.getMajorName().equals(other.getMajorName()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMajorId() == null) ? 0 : getMajorId().hashCode());
        result = prime * result + ((getMajorName() == null) ? 0 : getMajorName().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", majorId=").append(majorId);
        sb.append(", majorName=").append(majorName);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}