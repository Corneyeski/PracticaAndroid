package com.alanv.practicaandroid.Entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alanv on 11/12/2017.
 */

public class User {
    int id;
    String username;
    String firstname;
    String lastname;
    String email;
    @SerializedName("avatar_path")
    String avatar;

    public User() {
    }

    public User(int id, String username, String firstname, String lastname, String email, String avatar) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
