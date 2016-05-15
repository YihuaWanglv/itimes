package com.iyihua.timeitem.component.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iyihua.timeitem.R;
import com.iyihua.timeitem.models.item.Item;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

//import com.example.iyihua.myapplication.R;


public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.ItemViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private String[] mTitles;
    private List<Item> items;

    public ItemRecyclerViewAdapter(Context context) {
        mTitles = context.getResources().getStringArray(R.array.titles);
        items = Item.initTestDataList();
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(mLayoutInflater.inflate(R.layout.cardview_item_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
//        holder.mCardView.setText(mTitles[position]);
        Item item = items.get(position);
        holder.date.setText(item.getDate());
        holder.time.setText(item.getTime());
        holder.content.setText(item.getContent());
        holder.category.setText(item.getCategory());
        holder.project.setText(item.getProject());
        holder.location.setText(item.getLocation());
    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.length;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.cardview_item_date)
        TextView date;
        @InjectView(R.id.cardview_item_time)
        TextView time;
        @InjectView(R.id.cardview_item_content)
        TextView content;
        @InjectView(R.id.cardview_item_category)
        TextView category;
        @InjectView(R.id.cardview_item_project)
        TextView project;
        @InjectView(R.id.cardview_item_location)
        TextView location;

        ItemViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("NormalTextViewHolder", "onClick--> position = " + getPosition());
                }
            });
        }
    }
}
