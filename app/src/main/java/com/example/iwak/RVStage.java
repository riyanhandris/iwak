package com.example.iwak;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iwak.model.ModelNilai;
import com.example.iwak.model.ModelQuiz;
import com.example.iwak.model.ModelStage;

import java.util.ArrayList;
import java.util.List;

import static com.example.iwak.database.MyApp.db;

public class RVStage extends RecyclerView.Adapter<RVStage.ViewHolder> {
    private ArrayList<ModelStage> modelStages = new ArrayList<>();
    private ArrayList<ModelNilai> nilais= new ArrayList<>();
    public static int idStage,idIkan;
    RVStage() {

    }

    public void setArrayList(ArrayList<ModelStage> modelStages, List<ModelNilai> nilais) {
        this.modelStages.clear();
        this.modelStages.addAll(modelStages);
        this.nilais.clear();
        this.nilais.addAll(nilais);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stageselector,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("asd", "onBindViewHolder: "+position);
        holder.textView.setText(modelStages.get(position).getName());
        if (nilais.size()!=position){
            holder.ratingBar.setRating(nilais.get(position).getNilai());
        }
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), MateriActivity.class);
            idStage=modelStages.get(position).getId();
            idIkan=modelStages.get(position).getIdIkan();
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        int size=1;
        if (db.nilaiDao().Selector(idIkan).size()==0){
            size=1;
        }
        else if (db.nilaiDao().Selector(idIkan).get(0).getNilai()<=2) {
            size= nilais.size();
        }
        else {
            size= nilais.size()+1;
        }
        if (size>=5){
            size=5;
        }
        Log.d("asd", "getItemCount: "+size);
        return size;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        RatingBar ratingBar;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ratingBar=itemView.findViewById(R.id.rating);
            textView=itemView.findViewById(R.id.rv_title);
        }

    }
}
