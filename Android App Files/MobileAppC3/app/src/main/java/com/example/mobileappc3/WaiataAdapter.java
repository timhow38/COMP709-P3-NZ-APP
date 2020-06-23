package com.example.mobileappc3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WaiataAdapter extends RecyclerView.Adapter<WaiataAdapter.ViewHolder> {
    private ArrayList<Waiata> mWaiataList;
    private onItemClickListener mListener;

    public interface onItemClickListener {
        void onItemClick(int position);
    }

    public void setonItemClickListener(onItemClickListener listener) {
        mListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;

        public ViewHolder(View itemView, final WaiataAdapter.onItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.waiata1);
            mTextView1 = itemView.findViewById(R.id.waiata_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public WaiataAdapter(ArrayList<Waiata> waiataList) {
        mWaiataList = waiataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carving_item, parent, false);
        WaiataAdapter.ViewHolder vh = new WaiataAdapter.ViewHolder(v, mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Waiata currentItem = mWaiataList.get(position);
        holder.mTextView1.setText(currentItem.getWaiataName());
    }

    @Override
    public int getItemCount() {
        return mWaiataList.size();
    }
}