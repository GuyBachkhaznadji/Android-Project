package com.example.magicapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class Player1CreaturesAdapter extends RecyclerView.Adapter<Player1CreaturesAdapter.ViewHolder> {
    private ArrayList<Creature> player1CreaturesRaw;

    Player1CreaturesAdapter(ArrayList<Creature> player1CreaturesRaw) {
        this.player1CreaturesRaw = player1CreaturesRaw;
    }

    @Override
    public Player1CreaturesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.small_row, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(Player1CreaturesAdapter.ViewHolder holder, int position) {
        holder.name.setText(player1CreaturesRaw.get(position).getName());
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
