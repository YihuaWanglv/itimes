package com.iyihua.timeitem.frame.nav;
/**
 * Copyright (C) 2015 Mustafa Ozcan
 * Created on 06 May 2015 (www.mustafaozcan.net)
 * *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * *
 * http://www.apache.org/licenses/LICENSE-2.0
 * *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.TextView;

import com.iyihua.timeitem.R;
import com.iyihua.timeitem.component.view.NormalRecyclerViewAdapter;

public class ContentFragment extends Fragment {
    // Store instance variables
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    // newInstance constructor for creating fragment with arguments
    public static ContentFragment newInstance(int pageIndex) {
        ContentFragment contentFragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putInt("pageIndex", pageIndex);
        contentFragment.setArguments(args);
        return contentFragment;
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_layout, container, false);

//        Bundle bundle = this.getArguments();
//        if (bundle != null) {
//            int pageIndex = bundle.getInt("pageIndex", 0);
//
//            TextView tvSection = (TextView) view.findViewById(R.id.tvSection);
//            tvSection.setText(getString(R.string.page) + " " + String.valueOf(pageIndex + 1));
//        }


        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(inflater.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new NormalRecyclerViewAdapter(inflater.getContext());
        mRecyclerView.setAdapter(mAdapter);

        return view;

    }
}
