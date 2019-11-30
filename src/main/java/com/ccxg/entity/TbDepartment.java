package com.ccxg.entity;

import java.io.Serializable;

/**
 * tb_department
 * @author 
 */
public class TbDepartment implements Serializable {
    private String departmentId;

    private String departmentName;

    private static final long serialVersionUID = 1L;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}