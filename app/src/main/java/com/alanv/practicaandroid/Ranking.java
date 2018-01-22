package com.alanv.practicaandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.alanv.practicaandroid.Entities.GameRanking;
import com.alanv.practicaandroid.adapter.RankingListAdapter;
import com.alanv.practicaandroid.asynctask.RankingSnakeSearchTask;

public class Ranking extends AppCompatActivity implements
        RankingSnakeSearchTask.WeakReference{

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        recyclerView = findViewById(R.id.recycleView);

        search();

    }

    public void search() {
        RankingSnakeSearchTask task = new RankingSnakeSearchTask(this);

        Intent intent = getIntent();

        if (intent.getStringExtra("game") != null) task.execute(intent.getStringExtra("game"));

        else task.execute("1");
    }

    @Override
    public Context getContext() {
        return this;
    }

    //TODO obtiene la progrs bar (que no hay)
    @Override
    public ProgressBar getProgressBar() {
        return null;
    }

    @Override
    public void finished(GameRanking list) {
        RankingListAdapter adapter = new RankingListAdapter(list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        //adapter.setOnItemClickListener(this);
    }
}
