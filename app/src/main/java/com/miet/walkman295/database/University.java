package com.miet.walkman295.database;

/**
 * Created by Boris on 10.05.2017.
 */

public class University {
    private Integer university_id;
    private String university_name;
    private String university_city;
    private String university_phone_number;
    private String university_address;
    private String university_email;
    private String university_web;
    private String university_rating;
    private String university_coordinate1;
    private String university_coordinate2;

    public University(Integer university_id, String university_name, String university_city,
                      String university_phone_number, String university_address, String university_email,
                      String university_web, String university_rating, String university_coordinate1,
                      String university_coordinate2) {
        this.university_id = university_id;
        this.university_name = university_name;
        this.university_city = university_city;
        this.university_phone_number = university_phone_number;
        this.university_address = university_address;
        this.university_email = university_email;
        this.university_web = university_web;
        this.university_rating = university_rating;
        this.university_coordinate1 = university_coordinate1;
        this.university_coordinate2 = university_coordinate2;
    }

    public Integer getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(Integer university_id) {
        this.university_id = university_id;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public String getUniversity_city() {
        return university_city;
    }

    public void setUniversity_city(String university_city) {
        this.university_city = university_city;
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

    public void setUniversity_address(String university_address) {
        this.university_address = university_address;
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

    public String getUniversity_rating() {
        return university_rating;
    }

    public void setUniversity_rating(String university_rating) {
        this.university_rating = university_rating;
    }

    public String getUniversity_coordinate1() {
        return university_coordinate1;
    }

    public void setUniversity_coordinate1(String university_coordinate1) {
        this.university_coordinate1 = university_coordinate1;
    }

    public String getUniversity_coordinate2() {
        return university_coordinate2;
    }

    public void setUniversity_coordinate2(String university_coordinate2) {
        this.university_coordinate2 = university_coordinate2;
    }

    @Override
    public String toString() {
        return "University{" +
                "university_id=" + university_id +
                ", university_name='" + university_name + '\'' +
                ", university_city='" + university_city + '\'' +
                ", university_phone_number='" + university_phone_number + '\'' +
                ", university_address='" + university_address + '\'' +
                ", university_email='" + university_email + '\'' +
                ", university_web='" + university_web + '\'' +
                ", university_rating='" + university_rating + '\'' +
                ", university_coordinate1='" + university_coordinate1 + '\'' +
                ", university_coordinate2='" + university_coordinate2 + '\'' +
                '}';
    }
}
