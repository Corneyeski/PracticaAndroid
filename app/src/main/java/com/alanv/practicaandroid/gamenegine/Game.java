package com.alanv.practicaandroid.gamenegine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.alanv.practicaandroid.R;

public class Game extends AppCompatActivity {

    GameEngine gameEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_game);

        GameView gameView = new GameView(this);
        setContentView(gameView);

        gameEngine = new GameEngine(this, gameView);
        gameEngine.start();
    }

    @Override public void onResume() {
        super.onResume();
        gameEngine.resume();
    }
    @Override public void onPause() {
        super.onPause();
        gameEngine.pause();
    }
    @Override public void onDestroy() {
        super.onDestroy();
        gameEngine.stop();
    }
}
