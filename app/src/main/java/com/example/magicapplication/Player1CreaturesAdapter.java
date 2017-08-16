package com.example.magicapplication;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class Player1CreaturesAdapter extends RecyclerView.Adapter<Player1CreaturesAdapter.ViewHolder> {
    private ArrayList<Creature> player1CreaturesRaw;
    private View v;

    Player1CreaturesAdapter(ArrayList<Creature> player1CreaturesRaw) {
        this.player1CreaturesRaw = player1CreaturesRaw;
    }

    @Override
    public Player1CreaturesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.medium_row, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(Player1CreaturesAdapter.ViewHolder holder, int position) {
        holder.name.setText(player1CreaturesRaw.get(position).getName());
        v.setTag(player1CreaturesRaw.get(position));
        boolean tapped = player1CreaturesRaw.get(position).getTapped();
        if (tapped) {
            v.setPadding(2, 2, 2, 2);
            v.setBackgroundColor(Color.RED);
        } else {
            v.setPadding(2, 2, 2, 2);
            v.setBackgroundColor(Color.GREEN);
        }
        
    }

    @Override
    public int getItemCount() {
        return player1CreaturesRaw.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}
