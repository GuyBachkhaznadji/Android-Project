package com.example.magicapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class BlockersAdapter extends RecyclerView.Adapter<BlockersAdapter.ViewHolder> {
    private ArrayList<Creature> blockersRaw;

    BlockersAdapter(ArrayList<Creature> attackersRaw) {
        this.blockersRaw = blockersRaw;
    }

    @Override
    public BlockersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.small_row, parent, false);

        RecyclerView.ViewHolder vh = new ViewHolder(v);
        return (ViewHolder) vh;
    }

    @Override
    public void onBindViewHolder(BlockersAdapter.ViewHolder holder, int position) {
        holder.name.setText(blockersRaw.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return blockersRaw.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
