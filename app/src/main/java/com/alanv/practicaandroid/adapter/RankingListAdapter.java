package com.alanv.practicaandroid.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.alanv.practicaandroid.Entities.GameRanking;

public class RankingListAdapter
        extends RecyclerView.Adapter<RankingListAdapter.ViewHolder> {

    private GameRanking list;
    public RankingListAdapter(GameRanking list) {
        super();
        this.list = list;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) { super(view); }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
