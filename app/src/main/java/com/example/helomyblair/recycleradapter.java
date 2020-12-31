package com.example.helomyblair;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recycleradapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   Context context;
   String[] items;
    public recycleradapter(Context context,String[]items){
        this.context=context;
        this.items=items;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.recyclelayout, parent, false);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return items.length;
    }
    public class item extends RecyclerView.ViewHolder {
        TextView textView;
        public item(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.item);
        }
    }
}
