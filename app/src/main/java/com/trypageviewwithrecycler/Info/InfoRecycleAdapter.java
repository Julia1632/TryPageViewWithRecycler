package com.trypageviewwithrecycler.Info;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trypageviewwithrecycler.R;

import java.util.List;

/**
 * Created by User on 10.01.2018.
 */

public class InfoRecycleAdapter extends RecyclerView.Adapter<InfoRecycleHolder> {
    private List<Info> infolist;



    public InfoRecycleAdapter(final List<Info> info) {
        this.infolist = info;
    }

    @Override
    public InfoRecycleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new InfoRecycleHolder(view);
    }

    @Override
    public void onBindViewHolder(InfoRecycleHolder holder, int position) {
        Info info=infolist.get(position);

        holder.name.setText(info.getName());
        holder.surname.setText(info.getSurname());
    }

    @Override
    public int getItemCount() {
        return infolist.size();
    }

}
