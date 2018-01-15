package com.alanv.practicaandroid.Entities;

import java.util.List;

/**
 * Created by alanv on 04/01/2018.
 */

public class ReceivedGame {
    String error;
    String message;
    List<GameRanking> data;

    public ReceivedGame() {
    }

    public ReceivedGame(String error, String message, List<GameRanking> data) {
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

    public List<GameRanking> getData() {
        return data;
    }

    public void setData(List<GameRanking> data) {
        this.data = data;
    }
}
