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
    private GameLogic game;
    private View v;

    Player1HandAdapter(ArrayList<Card> player1HandRaw, GameLogic game) {
        this.player1HandRaw = player1HandRaw;
        this.game = game;
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
        boolean playable = game.playable(player1HandRaw.get(position), game.getPlayer(0));
        if (!playable) {
            v.setPadding(2, 2, 2, 2);
            v.setBackgroundColor(Color.RED);
        } else {
            v.setPadding(2, 2, 2, 2);
            v.setBackgroundColor(Color.GREEN);
        }

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
