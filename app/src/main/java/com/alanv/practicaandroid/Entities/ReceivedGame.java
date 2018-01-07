package com.alanv.practicaandroid.Entities;

/**
 * Created by alanv on 04/01/2018.
 */

public class ReceivedGame {
    String error;
    String message;
    GameRanking data;

    public ReceivedGame() {
    }

    public ReceivedGame(String error, String message, GameRanking data) {
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GameRanking getData() {
        return data;
    }

    public void setData(GameRanking data) {
        this.data = data;
    }
}
