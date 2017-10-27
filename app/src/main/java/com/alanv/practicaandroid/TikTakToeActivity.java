         package com.alanv.practicaandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

         public class TikTakToeActivity extends AppCompatActivity {

    List<Button> buttons = new ArrayList();

    boolean who = false;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tik_tak_toe);
    }

    public void xOrO(View view){

        Button c = (Button) view;

        if (c.getText().equals("")){
            if(!who){
                c.setText("X");
                who = true;
            }else {
                c.setText("O");
                who = false;
            }
            count++;
            buttons.add(c);

            if(count == 9){
                restart();
            }
        }
    }

    private void restart(){
        for(Button b : buttons){
            b.setText("");
        }
        buttons.removeAll(buttons);
        count = 0;
    }
}
