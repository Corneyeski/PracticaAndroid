package com.alanv.practicaandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.alanv.practicaandroid.Entities.GameRanking;
import com.alanv.practicaandroid.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by alanv on 15/01/2018.
 */

public class RankingMenuAdapter extends RecyclerView.Adapter<RankingMenuAdapter.ViewHolder>{

    private List<GameRanking> list;
    public RankingMenuAdapter(List<GameRanking> list) {
        super();
        this.list = list;
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) { super(view); }
    }

    class RankingMenuSetViewHolder extends ViewHolder{

        GameRanking set;
        ImageButton image;
        TextView name, description, id;

        public RankingMenuSetViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.image);
            name = view.findViewById(R.id.gameName);
            description = view.findViewById(R.id.description);
            id = view.findViewById(R.id.id);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(list == null){
            View itemView = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.view_menu_ranking, parent, false);

            return new ViewHolder(itemView);
        }else{
            View itemView = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.view_menu_ranking, parent, false);

            return new RankingMenuSetViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(RankingMenuAdapter.ViewHolder holder, int position) {
        if(list == null) return;

        RankingMenuSetViewHolder view = (RankingMenuSetViewHolder) holder;
        GameRanking set = list.get(position);

        Context context = view.id.getContext();
        view.set = set;
        view.name.setText(set.getName());
        view.description.setText(set.getDescription());
        Picasso.with(context).load(set.getImagePath()).into(view.image);
    }

    @Override
    public int getItemCount() {
        return (list == null) ? 1 : list.size();
    }
}
