package com.example.iwak;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.iwak.model.ModelStage;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.iwak.RVStage.idIkan;
import static com.example.iwak.RVStage.idStage;
import static com.example.iwak.StageSelectorActivity.modelStages;

public class MateriActivity extends AppCompatActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.materi)
    TextView materi;
    @BindView(R.id.btn)
    Button btn;
    ModelStage stage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);
        ButterKnife.bind(this);

        for (int i = 0; i < modelStages.size(); i++) {
            if (modelStages.get(i).getIdIkan() == idIkan
                    && modelStages.get(i).getId() == idStage) {
                stage=modelStages.get(i);
                break;
            }
        }

        title.setText(stage.getName());
        materi.setText(stage.getMateri());
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(this, QuizActivity.class);
            startActivity(intent);
        });

    }
}
