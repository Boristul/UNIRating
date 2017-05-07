package com.miet.walkman295.database;

/**
 * Created by Boris on 07.05.2017.
 */

public class User {
    private Integer user_id;
    private String user_login;
    private String user_password;
    //Favourite
    //Chat

    public User(Integer user_id, String user_login, String user_password) {
        this.user_id = user_id;
        this.user_login = user_login;
        this.user_password = user_password;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getUser_login() {
        return user_login;
    }

    public String getUser_password() {
        return user_password;
    }

}
