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

        UserRanking set;
        ImageView avatar;
        TextView id, score, username;

        public RankingSetViewHolder(View view) {
            super(view);
            id = view.findViewById(R.id.id);
            avatar = view.findViewById(R.id.avatar);
            score = view.findViewById(R.id.score);
            username = view.findViewById(R.id.username);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (list == null) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.view_user_ranking, parent, false);
            return new ViewHolder(itemView);
        }else {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.view_user_ranking, parent, false);
            return new RankingSetViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (list == null) return;
        RankingSetViewHolder vh = (RankingSetViewHolder) holder;
        UserRanking set = list.getRanking().get(position);
        Context context = vh.id.getContext();
        vh.set = set;
        vh.id.setText(String.valueOf(set.getId()));
        vh.username.setText(set.getUser().getUsername());
        vh.score.setText(String.valueOf(set.getScore()));
        Picasso.with(context).load(set.getUser().getAvatar()).into(vh.avatar);
    }

    @Override
    public int getItemCount() {
        return (list == null) ? 1 : list.getRanking().size();
    }
}
