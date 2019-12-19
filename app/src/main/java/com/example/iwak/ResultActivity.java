package com.example.iwak;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.iwak.RVStage.idIkan;

public class ResultActivity extends AppCompatActivity {

    @BindView(R.id.tv_stage)
    TextView tvStage;
    @BindView(R.id.benar1)
    ImageView benar1;
    @BindView(R.id.benar2)
    ImageView benar2;
    @BindView(R.id.benar3)
    ImageView benar3;
    @BindView(R.id.benar4)
    ImageView benar4;
    @BindView(R.id.benar5)
    ImageView benar5;
    @BindView(R.id.salah1)
    ImageView salah1;
    @BindView(R.id.salah2)
    ImageView salah2;
    @BindView(R.id.salah3)
    ImageView salah3;
    @BindView(R.id.salah4)
    ImageView salah4;
    @BindView(R.id.salah5)
    ImageView salah5;
    @BindView(R.id.btn_lanjutkan)
    Button btnLanjutkan;
    @BindView(R.id.btn_keluar)
    Button btnKeluar;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
        boolean[] hasil = getIntent().getBooleanArrayExtra("Nilai");
        if (!hasil[0]) {
            salah1.setVisibility(View.VISIBLE);
        } else {
            benar1.setVisibility(View.VISIBLE);
        }
        if (!hasil[1]) {
            salah2.setVisibility(View.VISIBLE);
        } else {
            benar2.setVisibility(View.VISIBLE);
        }
        if (!hasil[2]) {
            salah3.setVisibility(View.VISIBLE);
        } else {
            benar3.setVisibility(View.VISIBLE);
        }
        if (!hasil[3]) {
            salah4.setVisibility(View.VISIBLE);
        } else {
            benar4.setVisibility(View.VISIBLE);
        }
        if (!hasil[4]) {
            salah5.setVisibility(View.VISIBLE);
        } else {
            benar5.setVisibility(View.VISIBLE);
        }
        btnLanjutkan.setOnClickListener(v -> {
            intent=new Intent(this,StageSelectorActivity.class);
            intent.putExtra("TITLE",idIkan);
            startActivity(intent);
        });
        btnKeluar.setOnClickListener(v -> {
            intent=new Intent(this,IwakSelectorActivity.class);
            startActivity(intent);
        });
    }
}
