package com.alanv.practicaandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RankingMenu extends AppCompatActivity {

    Button snake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_menu);

        snake = findViewById(R.id.snake);

        snake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RankingMenu.this, AjustesPerfil.class);

                startActivity(intent);
            }
        });
    }
}
