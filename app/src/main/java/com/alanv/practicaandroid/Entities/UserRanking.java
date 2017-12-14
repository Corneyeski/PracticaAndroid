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
}
