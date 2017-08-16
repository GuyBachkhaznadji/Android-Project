package com.example.magicapplication;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class Player1HandAdapter extends RecyclerView.Adapter<Player1HandAdapter.ViewHolder> {
    private ArrayList<Card> player1HandRaw;
    private View v;

    Player1HandAdapter(ArrayList<Card> player1HandRaw) {
        this.player1HandRaw = player1HandRaw;
    }

    @Override
    public Player1HandAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(Player1HandAdapter.ViewHolder holder, int position) {
        holder.name.setText(player1HandRaw.get(position).getName());
        v.setTag(player1HandRaw.get(position));

    }

    @Override
    public int getItemCount() {
        return player1HandRaw.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;

        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);


        }
    }
}
