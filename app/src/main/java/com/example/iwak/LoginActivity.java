package com.example.iwak;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btn_memulaibaru)
    Button btnMemulaibaru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        btnMemulaibaru.setOnClickListener(v -> {
            Intent i = new Intent(this, AdminActivity.class);
            startActivity(i);
        });
    }
}
