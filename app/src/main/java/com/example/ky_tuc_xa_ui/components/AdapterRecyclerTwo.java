package com.example.ky_tuc_xa_ui.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ky_tuc_xa_ui.R;

import java.util.List;

public class AdapterRecyclerTwo extends RecyclerView.Adapter<AdapterRecyclerTwo.MyView> {
    private Context mContext;
    private AdapterView.OnItemClickListener listener;
    private List<Integer> lsFloor;

    public AdapterRecyclerTwo(Context context, List<Integer> lsFloor) {
        mContext = context;
        this.lsFloor = lsFloor;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        this.listener = listener;
    }

    // ViewHolder class
    public static class MyView extends RecyclerView.ViewHolder {
        TextView floorTextView;

        public MyView(View view) {
            super(view);
            floorTextView = view.findViewById(R.id.id_text_floor);

            // Set click listener on the entire item view
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        // Handle the click event here
                        //Toast.makeText(mContext, "Item clicked at position: " + position, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_2_cm_page, parent, false);
        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final MyView holder, final int position) {
        if (lsFloor.isEmpty()) {
            Toast.makeText(mContext, "Recycler no data!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Set data to views
        holder.floorTextView.setText(String.valueOf(lsFloor.get(position)));
    }

    @Override
    public int getItemCount() {
        return lsFloor.size();
    }
}
