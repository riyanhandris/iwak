package com.example.iwak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.iwak.model.ModelIwak;

import java.util.ArrayList;

public class IwakSelectorActivity extends AppCompatActivity {

    RecyclerView recycleView;
    ArrayList<ModelIwak> modelIwaks= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iwak_selector);
        modelIwaks.add(new ModelIwak(1,"NILA", ContextCompat.getDrawable(this, R.drawable.nila_selector)));
        modelIwaks.add(new ModelIwak(2,"LELE", ContextCompat.getDrawable(this, R.drawable.lele_selector)));
        modelIwaks.add(new ModelIwak(3,"KOI", ContextCompat.getDrawable(this, R.drawable.koi_selector)));
        modelIwaks.add(new ModelIwak(4,"GURAMI", ContextCompat.getDrawable(this, R.drawable.gurami_selector)));
        recycleView=findViewById(R.id.rv);
        RVSelector rvSelector = new RVSelector(modelIwaks);
        recycleView.setAdapter(rvSelector);
        recycleView.setLayoutManager(new GridLayoutManager(this,2));
    }
}
