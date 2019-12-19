package com.example.iwak;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.iwak.model.ModelQuiz;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdminActivity extends AppCompatActivity {

    @BindView(R.id.et_title)
    EditText etTitle;
    @BindView(R.id.et_soal)
    EditText etSoal;
    @BindView(R.id.et_pilihanA)
    EditText etPilihanA;
    @BindView(R.id.et_pilihanB)
    EditText etPilihanB;
    @BindView(R.id.et_pilihanC)
    EditText etPilihanC;
    @BindView(R.id.et_pilihanD)
    EditText etPilihanD;
    @BindView(R.id.et_jawaban)
    EditText etJawaban;
    DatabaseReference reference;
    @BindView(R.id.et_ikan)
    EditText etIkan;
    @BindView(R.id.et_stage)
    EditText etStage;
    @BindView(R.id.btn)
    Button btn;

    @SuppressLint("ShowToast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ButterKnife.bind(this);
////        Log.d("TAG", "onCreate: "+etIkan.getText().toString().trim());
//        btn.setOnClickListener(v -> {
//            reference = FirebaseDatabase.getInstance().getReference(etIkan.getText().toString().trim());
//            String id = reference.push().getKey();
//            ModelQuiz modelQuiz = new ModelQuiz(id, etStage.getText().toString().trim(), etSoal.getText().toString().trim(), etPilihanA.getText().toString().trim(), etPilihanB.getText().toString().trim(), etPilihanC.getText().toString().trim(), etPilihanD.getText().toString().trim(), etJawaban.getText().toString().trim(), etTitle.getText().toString().trim());
//            reference.child(id).setValue(modelQuiz);
//            Toast.makeText(this,"Berhasil",Toast.LENGTH_SHORT);
//        });

    }
}
