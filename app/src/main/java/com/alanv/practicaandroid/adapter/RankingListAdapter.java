package com.alanv.practicaandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alanv.practicaandroid.Entities.GameRanking;
import com.alanv.practicaandroid.Entities.UserRanking;
import com.alanv.practicaandroid.R;
import com.squareup.picasso.Picasso;

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

    class RankingSetViewHolder extends ViewHolder{

        GameRanking set;
        ImageView avatar;
        TextView score, username;

        public RankingSetViewHolder(View view) {
            super(view);
            avatar = view.findViewById(R.id.avatar);
            score = view.findViewById(R.id.score);
            username = view.findViewById(R.id.username);


        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (list == null) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_ranking_view, parent, false);
            return new ViewHolder(itemView);
        }else {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_ranking_view, parent, false);
            return new RankingSetViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (list == null) return;
        RankingSetViewHolder vh = (RankingSetViewHolder) holder;
        UserRanking set = list.getRanking().get(position);
        Context context = vh.tvSetNum.getContext();
        vh.set = set;
        vh.tvSetNum.setText(set.getSetNum());
        vh.tvName.setText(set.getName());
        vh.tvYear.setText(context.getString(R.string.year, set.getYear()));
        vh.tvNumParts.setText(context.getString(R.string.numParts, set.getNumParts()));
        Picasso.with(context).load(set.getSetImgUrl()).into(vh.imgSet);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
