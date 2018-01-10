package com.trypageviewwithrecycler.Info;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.trypageviewwithrecycler.R;

/**
 * Created by User on 10.01.2018.
 */

public class InfoRecycleHolder extends RecyclerView.ViewHolder{

   public TextView name;
    public TextView surname;


    public InfoRecycleHolder(View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.name_textview);
        surname=itemView.findViewById(R.id.surname_textview);
    }
}
