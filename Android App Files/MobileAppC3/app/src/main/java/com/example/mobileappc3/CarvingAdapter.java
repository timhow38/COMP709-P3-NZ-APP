package com.example.mobileappc3;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarvingAdapter extends RecyclerView.Adapter<CarvingAdapter.ViewHolder> {
    private static final String TAG = "PlantAdapter";
    private ArrayList<Carving> mCarving = new ArrayList<>();
    private onCarvingListener mOnCarvingListener;
    private Context context;

    public CarvingAdapter(ArrayList<Carving> mPlants, onCarvingListener mOnCarvingListener){
        this.mCarving = mPlants;
        this.mOnCarvingListener = mOnCarvingListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_carving_info, parent, false);
        context = parent.getContext();
        return new ViewHolder(view, mOnCarvingListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try{
            Carving carving = mCarving.get(position);
            String carvName = carving.getCarvName();
            String carvEngName = carving.getCarvEngName();
            String carvDesc = carving.getCarvDesc();
            String carvImageName = carving.getCarvImageName();


            holder.carvName.setText(carvName);
            holder.carvEngName.setText(carvEngName);
            holder.carvDesc.setText(carvDesc);

            Resources resources = context.getResources();
            final int resourceId = resources.getIdentifier(String.valueOf(carving.getCarvImageName()), "drawable", context.getPackageName());
            holder.carvImageName.setImageResource(resourceId);


        } catch (NullPointerException e){
            Log.e(TAG, "onBindViewHolder: Null Pointer: " + e.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return mCarving.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView carvName, carvEngName, carvDesc;
        ImageView carvImageName;
        onCarvingListener mOnCarvingListener;

        public ViewHolder(View itemView, onCarvingListener mOnCarvingListener){
            super(itemView);
            carvName = itemView.findViewById(R.id.carvingName);
            carvEngName = itemView.findViewById(R.id.carvingEngName);
            carvDesc = itemView.findViewById(R.id.carvingDesc);
            carvImageName = itemView.findViewById(R.id.carvingImage);

            this.mOnCarvingListener = mOnCarvingListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick:" + getAdapterPosition());
            mOnCarvingListener.onCarvingClick(getAdapterPosition());
        }
    }

    public interface onCarvingListener{
        void onCarvingClick(int position);
    }
}
