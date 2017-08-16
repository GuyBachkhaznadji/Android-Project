package com.example.magicapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class AttackersAdapter extends RecyclerView.Adapter<AttackersAdapter.ViewHolder> {
    private ArrayList<Creature> attackersRaw;

    AttackersAdapter(ArrayList<Creature> attackersRaw) {
        this.attackersRaw = attackersRaw;
    }

    @Override
    public AttackersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.small_row, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AttackersAdapter.ViewHolder holder, int position) {
        holder.name.setText(attackersRaw.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return attackersRaw.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}
