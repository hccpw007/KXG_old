package com.cqts.kxg.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cqts.kxg.R;

import static android.support.v7.widget.RecyclerView.*;

/**
 * Created by Administrator on 2016/4/19.
 */
public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.MyViewHolder> {
    Context context;

    public HomeRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_homerv, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class MyViewHolder extends ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
