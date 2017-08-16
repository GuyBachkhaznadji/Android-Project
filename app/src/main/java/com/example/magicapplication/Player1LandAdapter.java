package com.example.magicapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class Player1LandAdapter extends RecyclerView.Adapter<Player1LandAdapter.ViewHolder> {
    private ArrayList<Land> player1LandRaw;

    Player1LandAdapter(ArrayList<Land> player1HandRaw) {
        this.player1LandRaw = player1HandRaw;
    }

    @Override
    public Player1LandAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.small_row, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(Player1LandAdapter.ViewHolder holder, int position) {
        holder.name.setText(player1LandRaw.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return player1LandRaw.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}
