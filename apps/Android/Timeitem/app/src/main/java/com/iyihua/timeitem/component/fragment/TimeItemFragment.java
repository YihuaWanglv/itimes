package com.iyihua.timeitem.component.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iyihua.timeitem.R;
import com.iyihua.timeitem.component.view.ItemRecyclerViewAdapter;
import com.iyihua.timeitem.component.view.NormalRecyclerViewAdapter;

/**
 * Created by iyihua on 2016/5/15.
 */
public class TimeItemFragment extends Fragment {

    // Store instance variables
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    // newInstance constructor for creating fragment with arguments
    public static TimeItemFragment newInstance() {
        TimeItemFragment f = new TimeItemFragment();
        Bundle args = new Bundle();
//        args.putInt("pageIndex", pageIndex);
//        contentFragment.setArguments(args);
        return f;
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_layout, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(inflater.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new ItemRecyclerViewAdapter(inflater.getContext());
        mRecyclerView.setAdapter(mAdapter);

        return view;

    }
}
