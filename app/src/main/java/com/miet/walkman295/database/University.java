package com.miet.walkman295.database;

public class University {
    private Integer id;
    private String university_name;
    private String university_info;
    private String university_rating;
    private String university_coordinate;

    public University(Integer id, String university_name, String university_info, String university_rating, String university_coordinate) {
        this.id = id;
        this.university_name = university_name;
        this.university_info = university_info;
        this.university_rating = university_rating;
        this.university_coordinate = university_coordinate;
    }


    public String getUniversity_coordinate() {
        return university_coordinate;
    }

    public void setUniversity_coordinate(String university_coordinate) {
        this.university_coordinate = university_coordinate;
    }

    public String getUniversity_rating() {
        return university_rating;
    }

    public void setUniversity_rating(String university_rating) {
        this.university_rating = university_rating;
    }

    public String getUniversity_info() {
        return university_info;
    }

    public void setUniversity_info(String university_info) {
        this.university_info = university_info;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id+") "+university_name+" "+university_info;
    }
}
