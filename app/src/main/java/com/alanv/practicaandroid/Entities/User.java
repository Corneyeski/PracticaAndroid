package com.alanv.practicaandroid.Entities;

/**
 * Created by alanv on 11/12/2017.
 */

public class User {
    int id;
    String username;
    String firstname;
    String lastname;
    String email;
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
}
