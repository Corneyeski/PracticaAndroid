package com.alanv.practicaandroid;

import android.content.Context;
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


    }

    public void search() {
        recyclerView.setAdapter(null);
        RankingSnakeSearchTask task = new RankingSnakeSearchTask(this);
        task.execute();
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
