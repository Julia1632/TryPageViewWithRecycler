package com.trypageviewwithrecycler;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.trypageviewwithrecycler.Adapter.MyAdapter;
import com.trypageviewwithrecycler.Interface.ILoadMore;
import com.trypageviewwithrecycler.Model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static android.content.ContentValues.TAG;

/**
 * Created by User on 10.01.2018.
 */

public class SecondFragment extends Fragment {

    private String title;
    private int page;

    List<Item> items = new ArrayList<>();
    MyAdapter adapter;

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
        final View view = inflater.inflate(R.layout.fragment_second, container, false);
        TextView tvLabel = view.findViewById(R.id.tvLabel);
        tvLabel.setText(page + " -- " + title);
        //init();
        //- RecyclerView rv = view.findViewById(R.id.recyclerView);
        // rv.setHasFixedSize(true);
        // rv.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
        //rv.setAdapter(new InfoRecycleAdapter(info10));
        random10Data(0, 10);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        Log.e(TAG, "onCreateView: recycle" );

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new MyAdapter(recyclerView, view.getContext(), items);
        recyclerView.setAdapter(adapter);

        //Set Load more
        adapter.setLoadMore(new ILoadMore() {
            @Override
            public void onLoadMore() {
                if (items.size() <= 30) {
                    items.add(null);
                    adapter.notifyItemInserted(items.size() - 1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            items.remove(items.size() - 1);
                            adapter.notifyItemRemoved(items.size());

                            //random more data
                            int index = items.size();
                            int end = index + 10;
                            random10Data(index, end);
                            adapter.notifyDataSetChanged();
                            adapter.setLoaded();
                        }
                    }, 3000);
                } else {
                    Toast.makeText(view.getContext(), "Load data completed !!!", Toast.LENGTH_SHORT).show();
                }
            }

        });

        return view;
    }

    private void random10Data(int indexStart, int indexEnd) {
        //random data
        for (int i = indexStart; i < indexEnd; i++) {
            String name = UUID.randomUUID().toString();
            Item newItem = new Item(name, name.length());
            items.add(newItem);
        }
    }
}
