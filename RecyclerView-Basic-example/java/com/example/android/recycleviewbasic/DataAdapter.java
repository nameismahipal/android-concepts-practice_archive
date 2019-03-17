package com.example.android.recycleviewbasic;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by @sayaMahi; www.runningnotes.info on 14/03/2018.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    ArrayList<DataModel> mData;
    int mNumofItems;

    public DataAdapter(ArrayList<DataModel> mData) {
        this.mData = mData;
        mNumofItems = mData.size();
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //return null;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        DataViewHolder viewHolder = new DataViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mNumofItems;
    }

    class DataViewHolder  extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTxtView;
        TextView mDescView;

        public DataViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.imageView);
            mTxtView = (TextView) itemView.findViewById(R.id.titleView);
            mDescView = (TextView) itemView.findViewById(R.id.descriptionView);
        }

        void onBind(int position){
            mImageView.setImageResource(mData.get(position).getiImageId());
            mTxtView.setText(mData.get(position).getmTitle());
            mDescView.setText(mData.get(position).getmDescription());
        }
    }
}
