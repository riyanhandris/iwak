package com.example.iwak;

import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.iwak.model.ModelNilai;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.iwak.database.MyApp.db;

public class EndStageActivity extends AppCompatActivity {

    @BindView(R.id.stage)
    TextView stage;
    @BindView(R.id.rating)
    RatingBar rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_stage);
        ButterKnife.bind(this);
        String text= "Stage " + getIntent().getIntExtra("StageName",0);
        stage.setText(text);
        rating.setRating(getIntent().getIntExtra("StageNilai",0));
        List<ModelNilai> nilais= db.nilaiDao().SelectHasil();
        for (int i = 0; i <nilais.size() ; i++) {
            Log.d("asif", "onCreate: "+nilais.get(i).getNilai());
        }

    }
}
