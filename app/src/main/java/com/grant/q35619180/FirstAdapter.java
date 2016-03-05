package com.grant.q35619180;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by grant on 2016/3/5.
 */
public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.FirstHolder> {

    private List<FirstModel> firstModels;

    private Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public FirstAdapter(List<FirstModel> firstModels) {
        this.firstModels = firstModels;
    }

    @Override
    public FirstHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_item, parent, false);
        return new FirstHolder(view);
    }

    @Override
    public void onBindViewHolder(FirstHolder holder, int position) {
        FirstModel firstModel = firstModels.get(position);
        holder.cat.setText(firstModel.getCat());
        final SecondAdapter secondAdapter = new SecondAdapter(firstModel.getSecondModels());
        holder.rcv.setLayoutManager(new FullyGridLayoutManager(activity, 3));
        holder.rcv.setAdapter(secondAdapter);
        holder.cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                secondAdapter.showOrCollapse();
            }
        });
    }

    @Override
    public int getItemCount() {
        return firstModels.size();
    }

    class FirstHolder extends RecyclerView.ViewHolder {

        public RecyclerView rcv;

        public TextView cat;

        public FirstHolder(View itemView) {
            super(itemView);
            rcv = (RecyclerView) itemView.findViewById(R.id.rcv);
            cat = (TextView) itemView.findViewById(R.id.cat);
        }
    }
}
