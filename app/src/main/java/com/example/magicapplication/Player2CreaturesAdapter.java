package com.example.magicapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class Player2CreaturesAdapter extends RecyclerView.Adapter<Player2CreaturesAdapter.ViewHolder> {
    private ArrayList<Creature> player2CreaturesRaw;

    Player2CreaturesAdapter(ArrayList<Creature> player2CreaturesRaw) {
        this.player2CreaturesRaw = player2CreaturesRaw;
    }

    @Override
    public Player2CreaturesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.small_row, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(Player2CreaturesAdapter.ViewHolder holder, int position) {
        holder.name.setText(player2CreaturesRaw.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return player2CreaturesRaw.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}
