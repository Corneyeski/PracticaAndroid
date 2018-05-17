package com.alanv.practicaandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alanv.practicaandroid.gamenegine.Game;

public class MainMenu extends AppCompatActivity {

    Button jugar;
    Button ranquing;
    Button ajustes;
    Button quant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        jugar = findViewById(R.id.jugar);

        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, Game.class);

                startActivity(intent);
            }
        });

        ranquing = findViewById(R.id.ranquing);

        ranquing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, RankingMenu.class);

                startActivity(intent);
            }
        });

        ajustes = findViewById(R.id.ajustaments);

        ajustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, AjustesPerfil.class);

                startActivity(intent);
            }
        });

        quant = findViewById(R.id.quant);

        quant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, TikTakToeActivity.class);

                startActivity(intent);
            }
        });
    }
}
