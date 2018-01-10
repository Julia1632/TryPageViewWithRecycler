package com.trypageviewwithrecycler;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trypageviewwithrecycler.Info.Info;
import com.trypageviewwithrecycler.Info.InfoRecycleAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 10.01.2018.
 */

public class SecondFragment extends Fragment {

    private String title;
    private int page;
    private List<Info> info10;

    public static SecondFragment newInstance(int page, String title) {
        SecondFragment fragmentFirst = new SecondFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");


    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        TextView tvLabel = view.findViewById(R.id.tvLabel);
        tvLabel.setText(page + " -- " + title);
        init();
        RecyclerView rv = view.findViewById(R.id.recyclerView);
        // rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(new InfoRecycleAdapter(info10));
        return view;
    }

    private void init() {
        info10 = new ArrayList<>();
        info10.add(new Info("1name", "1s"));
        info10.add(new Info("2name", "2s"));
        info10.add(new Info("3name", "3s"));
        info10.add(new Info("4name", "4s"));
        info10.add(new Info("5name", "5s"));
        info10.add(new Info("6name", "6s"));
        info10.add(new Info("7name", "7s"));
        info10.add(new Info("8name", "8s"));
        info10.add(new Info("9name", "9s"));
        info10.add(new Info("1name", "1s"));
        info10.add(new Info("2name", "2s"));
        info10.add(new Info("3name", "3s"));
        info10.add(new Info("4name", "4s"));
        info10.add(new Info("5name", "5s"));
        info10.add(new Info("6name", "6s"));
        info10.add(new Info("7name", "7s"));
        info10.add(new Info("8name", "8s"));
        info10.add(new Info("9name", "9s"));


    }
}
