package com.example.mobileappc3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarvingAdapter extends RecyclerView.Adapter<CarvingAdapter.ViewHolder> {
    private ArrayList<Carving> mCarvingList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;

        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView_carving);
            mTextView1 = itemView.findViewById(R.id.text_carving_01);
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

    public CarvingAdapter(ArrayList<Carving> carvingList) {
        mCarvingList = carvingList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carving_item, parent, false);
        ViewHolder vh = new ViewHolder(v, mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Carving currentItem = mCarvingList.get(position);
        holder.mImageView.setImageResource(currentItem.getCarvImageName());
        holder.mTextView1.setText(currentItem.getCarvName());
    }

    @Override
    public int getItemCount() {
        return mCarvingList.size();
    }
}