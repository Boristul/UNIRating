package com.miet.walkman295.database;

/**
 * Created by Boris on 07.05.2017.
 */

public class Department {
    private Integer department_id;
    private String department_name;
    private String department_info;
    private String department_university;

    public Department(Integer department_id, String department_name, String department_info, String department_university) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.department_info = department_info;
        this.department_university = department_university;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public void setDepartment_info(String department_info) {
        this.department_info = department_info;
    }

    public void setDepartment_university(String department_university) {
        this.department_university = department_university;
    }

    public Integer getDepartment_id() {

        return department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public String getDepartment_info() {
        return department_info;
    }

    public String getDepartment_university() {
        return department_university;
    }
}
