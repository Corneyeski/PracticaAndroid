package com.alanv.practicaandroid.Entities;

/**
 * Created by alanv on 11/12/2017.
 */

public class UserRanking {
    int id;
    int userId;
    int gameId;
    long Score;
    User user;

    public UserRanking() {
    }

    public UserRanking(int id, int userId, int gameId, long score, User user) {
        this.id = id;
        this.userId = userId;
        this.gameId = gameId;
        Score = score;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public long getScore() {
        return Score;
    }

    public void setScore(long score) {
        Score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
