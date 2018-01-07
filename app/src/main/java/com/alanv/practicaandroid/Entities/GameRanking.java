package com.alanv.practicaandroid.Entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by alanv on 11/12/2017.
 */

public class GameRanking {
    int id;
    String name;
    String description;
    @SerializedName("image_path")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public ArrayList<UserRanking> getRanking() {
        return ranking;
    }

    public void setRanking(ArrayList<UserRanking> ranking) {
        this.ranking = ranking;
    }
}
