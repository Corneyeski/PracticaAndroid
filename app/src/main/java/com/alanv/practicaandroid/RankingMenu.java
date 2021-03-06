package com.alanv.practicaandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alanv.practicaandroid.Entities.GameRanking;
import com.alanv.practicaandroid.adapter.RankingMenuAdapter;
import com.alanv.practicaandroid.asynctask.RankingMenuSearchTask;
import com.alanv.practicaandroid.asynctask.RankingSnakeSearchTask;
import com.google.gson.Gson;

import java.util.List;

public class RankingMenu extends AppCompatActivity
        implements RankingMenuSearchTask.WeakReference,
        View.OnClickListener,
        RankingMenuAdapter.OnItemClickListener {

    Button snake;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_menu);

        snake = findViewById(R.id.snake);
        recyclerView = findViewById(R.id.recycleView);

        snake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RankingMenu.this, Ranking.class);

                startActivity(intent);
            }
        });

        search();
    }

    public void search() {
        RankingMenuSearchTask task = new RankingMenuSearchTask(this);
        task.execute();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void finished(List<GameRanking> list) {

        RankingMenuAdapter adapter = new RankingMenuAdapter(list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void itemClicked(View view, GameRanking set){

        String setNum = String.valueOf(set.getId());
        Toast.makeText(view.getContext(), "SET " + setNum, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Ranking.class);
        intent.putExtra("game", setNum);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {search();}
}
