package com.example.iwak;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iwak.model.ModelIwak;

import java.util.ArrayList;


public class RVSelector extends RecyclerView.Adapter<RVSelector.viewholder> {
    private ArrayList<ModelIwak> modelIwaks= new ArrayList<>();

    public RVSelector(ArrayList<ModelIwak> modelIwaks) {
        this.modelIwaks.clear();
        this.modelIwaks.addAll(modelIwaks);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_iwakselector,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final viewholder holder, final int position) {
        holder.textView.setText(modelIwaks.get(position).getTitle());
        holder.imageView.setImageDrawable(modelIwaks.get(position).getDrawable());
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(),StageSelectorActivity.class);
            intent.putExtra("TITLE",modelIwaks.get(position).getId());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return modelIwaks.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.rv_title);
            imageView=itemView.findViewById(R.id.rv_image);
        }
    }
}

