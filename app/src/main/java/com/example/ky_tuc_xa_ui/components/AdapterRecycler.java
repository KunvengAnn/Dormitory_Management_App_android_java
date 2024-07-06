package com.example.ky_tuc_xa_ui.components;

// Import RecyclerView from AndroidX

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.widget.Toast;

import com.example.ky_tuc_xa_ui.R;


public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyView> {

    private Context mContext;
    private AdapterView.OnItemClickListener listener;
    private List<String> lsTitle;
    private int selectedPosition = 0;

    public AdapterRecycler(Context context, List<String> lsTitle) {
        mContext = context;
        this.lsTitle = lsTitle;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        this.listener = listener;
    }

    // ViewHolder class
    public static class MyView extends RecyclerView.ViewHolder {
        TextView titleTextView;
        View cardView;

        public MyView(View view) {
            super(view);
            titleTextView =  view.findViewById(R.id.id_title_1_of_cm);
            cardView = view.findViewById(R.id.id_cardViewR1);

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
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_1_cm_page, parent, false);

        return new MyView(itemView);
    }


    @Override
    public void onBindViewHolder(final MyView holder, final int position) {
        if (lsTitle.isEmpty()) {
            Toast.makeText(mContext, "Recycler no data!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Set data to views
        holder.titleTextView.setText(lsTitle.get(position));

        // Change CardView color based on selection
        if (position == selectedPosition) {
            holder.cardView.setBackgroundColor(mContext.getResources().getColor(R.color.blue_2));
        } else {
            holder.cardView.setBackgroundColor(mContext.getResources().getColor(R.color.gray));
        }


        // Set click listener on the entire item view
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyItemChanged(selectedPosition); // Reset the previously selected item
                selectedPosition = holder.getAdapterPosition();
                notifyItemChanged(selectedPosition); // Highlight the newly selected item
            }
        });
    }

    @Override
    public int getItemCount() {
        return lsTitle.size();
    }
}