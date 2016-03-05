package com.grant.q35619180;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by grant on 2016/3/5.
 */
public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.SecondHolder> {


    private List<SecondModel> secondModels;

    private List<SecondModel> secondModel2Show;

    public SecondAdapter(List<SecondModel> secondModels) {
        this.secondModels = secondModels;
        this.secondModel2Show = this.secondModels;
    }

    boolean showAll = true;

    public void showOrCollapse() {
        if (showAll && secondModel2Show.size() >= 6) {
            this.secondModel2Show = this.secondModel2Show.subList(0, 6);
        } else {
            this.secondModel2Show = this.secondModels;
        }
        this.notifyDataSetChanged();
        showAll = !showAll;
    }

    @Override
    public SecondHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.second_item, parent, false);
        return new SecondHolder(v);
    }

    @Override
    public void onBindViewHolder(SecondHolder holder, int position) {
        SecondModel secondModel = secondModel2Show.get(position);
        holder.imageView.setImageResource(secondModel.getRes());
    }

    @Override
    public int getItemCount() {
        return secondModel2Show.size();
    }

    class SecondHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public SecondHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}