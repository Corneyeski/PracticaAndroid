package com.alanv.practicaandroid.gamenegine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.MotionEvent;

/**
 * Created by alanv on 12/03/2018.
 */

public class GameEngine {

    private static final int UPDATE_DELAY = 50;

    private Context context;
    private GameView gameView;
    private BitmapSet bitmapSet;
    private Audio audio;
    private Handler handler;

    GameEngine(Context context, GameView gameView) {
        // Initialize everything
        this.context = context;
        bitmapSet = new BitmapSet(context);
        audio = new Audio(context);

        // Relate to the game view
        this.gameView = gameView;
        gameView.setGameEngine(this);

        // Program the Handler for engine refresh (physics et al)
        handler = new Handler();
        handler.postDelayed(runnable, UPDATE_DELAY);
    }

    // Refresh process
    private Runnable runnable = new Runnable() {
        @Override public void run() {
            handler.postDelayed(this, UPDATE_DELAY);
            physics();
            gameView.invalidate();
        }
    };

    // For activity start
    void start() {
        audio.startMusic();
    }

    // For activity stop
    void stop() {
        audio.stopMusic();
    }

    // For activity pause
    void pause() {
        audio.stopMusic();
    }

    // For activity resume
    void resume() {
        audio.startMusic();
    }

    // Attend user input
    boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    // Perform physics on all game objects
    private void physics() {
        x++; x %= 100;
        count++; count %= 4;
    }

    private Paint paint;
    private int count = 0, x = 0;
    private int screenWidth, screenHeight;

    // Screen redraw
    void redraw(Canvas canvas) {
        if (paint == null) paint = new Paint();
        screenWidth = canvas.getWidth();
        screenHeight = canvas.getHeight();
        if (screenWidth * screenHeight == 0) return;    // 0 px on screen (not fully loaded)

        // Background
        canvas.drawColor(Color.LTGRAY);

        // Test
        canvas.scale(8,8);
        Bitmap bitmap = bitmapSet.getBitmap(count);
        canvas.drawBitmap(bitmap, x, 0, paint);
    }
}
