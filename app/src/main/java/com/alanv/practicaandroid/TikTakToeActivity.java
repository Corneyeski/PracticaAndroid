         package com.alanv.practicaandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TikTakToeActivity extends AppCompatActivity {

    List<Button> buttons = new ArrayList();

    boolean who = false;
    int count;

    int pPlayerOne;
    int pPlayerTwo;

    TextView gameOver;
    Button reboot;
    TextView whoPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tik_tak_toe);
        gameOver = (TextView) findViewById(R.id.gameOver);
        reboot = (Button) findViewById(R.id.reboot);
        whoPlay = findViewById(R.id.who);

        reboot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restart();
            }
        });
    }

    public void xOrO(View view){

        Button c = (Button) view;

        if (c.getText().equals("")){
            if(!who){
                c.setText("X");
                who = true;
                whoPlay.setText("Play: X");
            }else {
                c.setText("O");
                who = false;
                whoPlay.setText("Play: O");
            }
            count++;
            buttons.add(c);

            if(count == 9){
                restart();
            }
        }
    }

    private void end(){
        gameOver.setVisibility(View.VISIBLE);
        reboot.setVisibility(View.VISIBLE);


    }

    public void restart(){
        for(Button b : buttons){
            b.setText("");
        }
        buttons.removeAll(buttons);
        count = 0;

        gameOver.setVisibility(View.INVISIBLE);
        reboot.setVisibility(View.INVISIBLE);
    }

    public void check(){

    }
}
