package com.alanv.practicaandroid.Entities;

import java.util.ArrayList;

/**
 * Created by alanv on 11/12/2017.
 */

public class GameRanking {
    int id;
    String name;
    String description;
    String imagePath;
    ArrayList<UserRanking> ranking;

    public GameRanking() {
    }

    public GameRanking(int id, String name, String description, String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
    }
}
