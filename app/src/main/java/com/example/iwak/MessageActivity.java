package com.example.iwak;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.iwak.model.ModelNilai;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.iwak.RVStage.idIkan;
import static com.example.iwak.database.MyApp.db;

public class MessageActivity extends AppCompatActivity {

    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.rating)
    RatingBar rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        List<ModelNilai> modelNilais = db.nilaiDao().SelectHasil(idIkan);
        int nilaiAkhir = 0;
        for (int i = 0; i < modelNilais.size(); i++) {
            nilaiAkhir += modelNilais.get(i).getNilai();
        }
        tv.setText(nilaiAkhir * 4 +"%");
        rating.setRating(nilaiAkhir/5);

        btn.setOnClickListener(v -> {
            Intent intent = new Intent(this, IwakSelectorActivity.class);
            startActivity(intent);
        });
    }
}
