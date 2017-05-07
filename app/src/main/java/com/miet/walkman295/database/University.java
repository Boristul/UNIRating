package com.miet.walkman295.database;

public class University {
    private Integer university_id;
    private String university_name;
    private String university_city;
    private String university_phone_number;
    private String university_address;
    private String university_email;
    private String university_web;
    private String university_coordinate;
    private String university_rating;


    public University(Integer university_id, String university_name, String university_city, String university_phone_number,
                      String university_address, String university_email, String university_web,
                      String university_rating, String university_coordinate) {
        this.university_id = university_id;
        this.university_name = university_name;
        this.university_city = university_city;
        this.university_phone_number = university_phone_number;
        this.university_address = university_address;
        this.university_email = university_email;
        this.university_web = university_web;
        this.university_rating = university_rating;
        this.university_coordinate = university_coordinate;


    }


    public String getUniversity_coordinate() {
        return university_coordinate;
    }


    public String getUniversity_phone_number() {

        return university_phone_number;
    }

    public void setUniversity_phone_number(String university_phone_number) {
        this.university_phone_number = university_phone_number;
    }


    public String getUniversity_address() {
        return university_address;
    }

    public void setUniversity_address(String university_adress) {
        this.university_address = university_adress;
    }

    public String getUniversity_email() {
        return university_email;
    }

    public void setUniversity_email(String university_email) {
        this.university_email = university_email;
    }

    public String getUniversity_web() {
        return university_web;
    }

    public void setUniversity_web(String university_web) {
        this.university_web = university_web;
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

    public String getUniversity_city() {
        return university_city;
    }

    public void setUniversity_city(String university_city) {
        this.university_city = university_city;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public Integer getId() {
        return university_id;
    }

    public void setId(Integer id) {
        this.university_id = id;
    }

    @Override
    public String toString() {
        return university_id + ") " + university_name + " " + university_city;
    }
}
