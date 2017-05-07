package com.miet.walkman295.database;

/**
 * Created by Boris on 07.05.2017.
 */

public class Person {
     private Integer person_id;
    private String person_name;
    private String person_info;
    private String person_university;

    public Person(Integer person_id, String person_name, String person_info, String person_university) {
        this.person_id = person_id;
        this.person_name = person_name;
        this.person_info = person_info;
        this.person_university = person_university;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public void setPerson_info(String person_info) {
        this.person_info = person_info;
    }

    public void setPerson_university(String person_university) {
        this.person_university = person_university;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public String getPerson_info() {
        return person_info;
    }

    public String getPerson_university() {
        return person_university;
    }
}
