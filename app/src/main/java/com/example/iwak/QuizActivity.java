package com.example.iwak;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.iwak.model.ModelNilai;
import com.example.iwak.model.ModelQuiz;
import com.example.iwak.model.ModelResults;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.iwak.RVStage.idIkan;
import static com.example.iwak.RVStage.idStage;
import static com.example.iwak.database.MyApp.db;

public class QuizActivity extends AppCompatActivity {

    private static int stage = 0;
    private static ModelResults results = new ModelResults();
    private static int NilaiAkhir = 0;
    public ArrayList<ModelQuiz> modelQuizs = new ArrayList<>();
    public ModelQuiz modelQuiz;
    @BindView(R.id.btn_pilih)
    Button btnPilih;
    @BindView(R.id.btn_d)
    Button btnD;
    @BindView(R.id.btn_c)
    Button btnC;
    @BindView(R.id.btn_b)
    Button btnB;
    @BindView(R.id.btn_a)
    Button btnA;
    @BindView(R.id.tv_soal)
    TextView tvSoal;
    @BindView(R.id.iv_benar)
    ImageView ivBenar;
    @BindView(R.id.iv_salah)
    ImageView ivSalah;
    String jawaban = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ButterKnife.bind(this);
        setdata();
        for (int i = 0; i < modelQuizs.size(); i++) {
            if (modelQuizs.get(i).getIdIkan() == idIkan
                    && modelQuizs.get(i).getIdStage() == idStage
                    && stage == modelQuizs.get(i).getId()) {
                modelQuiz = modelQuizs.get(i);
                break;
            }
        }
        btnA.setText(modelQuiz.getPilihanA());
        btnB.setText(modelQuiz.getPilihanB());
        btnC.setText(modelQuiz.getPilihanC());
        btnD.setText(modelQuiz.getPilihanD());
        tvSoal.setText(modelQuiz.getSoal());
        btnPilih.setOnClickListener(view -> {
            if (jawaban.equals(modelQuiz.getJawaban())) {
                ivBenar.setVisibility(View.VISIBLE);
                results.setHasil(stage);
                Log.d("asd", "onCreate: " + results.getHasil()[stage]);
                NilaiAkhir++;
            } else {
                ivSalah.setVisibility(View.VISIBLE);
            }
        });
    }
//


    @OnClick({R.id.btn_pilih, R.id.btn_d, R.id.btn_c, R.id.btn_b, R.id.btn_a, R.id.iv_benar, R.id.iv_salah})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_pilih:
                break;
            case R.id.btn_d:
                btnD.setBackground(ContextCompat.getDrawable(this, R.drawable.buttonprimarygrey2));
                btnC.setBackground(ContextCompat.getDrawable(this, R.drawable.buttonprimarygrey));
                btnB.setBackground(ContextCompat.getDrawable(this, R.drawable.buttonprimarygrey));
                btnA.setBackground(ContextCompat.getDrawable(this, R.drawable.buttonprimarygrey));
                jawaban = modelQuiz.getPilihanD();
                break;
            case R.id.btn_c:
                btnD.setBackground(ContextCompat.getDrawable(this, R.drawable.buttonprimarygrey));
                btnC.setBackground(ContextCompat.getDrawable(this, R.drawable.buttonprimarygrey2));
                btnB.setBackground(ContextCompat.getDrawable(this, R.drawable.buttonprimarygrey));
                btnA.setBackground(ContextCompat.getDrawable(this, R.drawable.buttonprimarygrey));
                jawaban = modelQuiz.getPilihanC();
                break;
            case R.id.btn_b:
                btnD.setBackground(ContextCompat.getDrawable(this, R.drawable.buttonprimarygrey));
                btnC.setBackground(ContextCompat.getDrawable(this, R.drawable.buttonprimarygrey));
                btnB.setBackground(ContextCompat.getDrawable(this, R.drawable.buttonprimarygrey2));
                btnA.setBackground(ContextCompat.getDrawable(this, R.drawable.buttonprimarygrey));
                jawaban = modelQuiz.getPilihanB();
                break;
            case R.id.btn_a:
                btnD.setBackground(ContextCompat.getDrawable(this, R.drawable.buttonprimarygrey));
                btnC.setBackground(ContextCompat.getDrawable(this, R.drawable.buttonprimarygrey));
                btnB.setBackground(ContextCompat.getDrawable(this, R.drawable.buttonprimarygrey));
                btnA.setBackground(ContextCompat.getDrawable(this, R.drawable.buttonprimarygrey2));
                jawaban = modelQuiz.getPilihanA();
                break;
            case R.id.iv_salah:
            case R.id.iv_benar:
                if (stage < 4) {
                    Intent intent = new Intent(QuizActivity.this, QuizActivity.class);
                    startActivity(intent);
                    stage++;
                } else {
                    Intent intent;
                    if (idStage==5 && NilaiAkhir>=3){
                        intent = new Intent(QuizActivity.this, MessageActivity.class);
                        intent.putExtra("Nilai", results.getHasil());
                    }else{
                        intent = new Intent(QuizActivity.this, ResultActivity.class);
                        intent.putExtra("Nilai", results.getHasil());
                    }
                    if (db.nilaiDao().SelectHasil(idIkan, idStage).size() == 0) {
                        db.nilaiDao().insertNilai(new ModelNilai(idIkan, idStage, NilaiAkhir));
                    } else {
                        if (db.nilaiDao().SelectHasil(idIkan, idStage).get(0).getNilai() < NilaiAkhir) {
                            db.nilaiDao().updateHasil(NilaiAkhir, idIkan, idStage);
                        }
                    }
                    stage = 0;
                    results = new ModelResults();
                    NilaiAkhir = 0;
                    startActivity(intent);
                }
                break;
        }
    }

    private void setdata() {
        modelQuizs.clear();
        //stage 1
//Nila
        modelQuizs.add(new ModelQuiz(0, 1, 1, "Apa warna tubuh dari ikan nila ?", "Kuning cerah", "Merah", "Hitam ke abu abuan", "Maroon", "Hitam ke abu abuan"));
        modelQuizs.add(new ModelQuiz(1, 1, 1, "Untuk sekali memijah , ikan nila dapat menghasilkan telur sebanyak ?", "2 butir", " 1-2 juta butir", "300-1500 butir", "10000 butir", "300-1500 butir"));
        modelQuizs.add(new ModelQuiz(2, 1, 1, "Apa kebiasaan unik dari ikan nila setelah terjadi proses pemijahan dan bertelur ?", "Memakan telurnya sendiri", "Mati", "Sakit", "Mengulum telur kedalam rongga mulutnya", "Mengulum telur kedalam rongga mulutnya"));
        modelQuizs.add(new ModelQuiz(3, 1, 1, "Apa ciri-ciri dari ikan nila betina", "Kumis lebih panjang", "Perut lebih besar", "Warna lebih gelap", "Tulang rahang melebar", "Perut lebih besar"));
        modelQuizs.add(new ModelQuiz(4, 1, 1, "Berikut adalah proses tahapan yang terjadi setelah memilih indukan adalah?", "Menyiapkan kolam pemijahan", "Telur dierami didalam mulut induk betina", "Pindahkan larva ikan yang telah menetas ke kolam khusus", "Masukkan indukan ke kolam khusus", "Masukkan indukan ke kolam khusus"));

        modelQuizs.add(new ModelQuiz(0,2,1,"Sebutkan 4 tipe kolam yang digunakan untuk membudidayakan benih ikan nila ?","Kolam pemeliharaan indukan , Kolam pemijahan, Kolam pemeliharaan larva, Kolam pendinginan","Kolam pemeliharaan indukan , Kolam pemijahan, Kolam pemeliharaan larva, Kolam pendederan benih","Kolam pemeliharaan indukan , Kolam penetasan , Kolam pemeliharaan larva, Kolam pendederan benih","Kolam pemeliharaan larva  , Kolam pemijahan, Kolam pemeliharaan larva, Kolam pendederan benih","Kolam pemeliharaan indukan , Kolam pemijahan, Kolam pemeliharaan larva, Kolam pendederan benih"));
        modelQuizs.add(new ModelQuiz(1,2,1,"Sebutkan ciri ciri ikan nila yang mempunyai kualitas unggul","Tidak cacat, badan tebal, sisik sedikit pucat dan lincah","Tidak cacat, badan lonjong, sisik sedikit pucat dan lincah","Tidak cacat, badan tebal, sisik mengkilap dan lincah","Tidak cacat, badan lonjong, sisik mengkilap dan lincah","Tidak cacat, badan tebal, sisik mengkilap dan lincah"));
        modelQuizs.add(new ModelQuiz(2,2,1,"Mengapa sebelum pemijahan indukan nila darus dipisahkan antara jantan dan betina ?","Agar ikan memperolah pangan yang cukup","Agar ikan tidak stres","Agar ikan tidak saling beradu","Agar tidak terjadi pembuahan liar","Agar tidak terjadi pembuahan liar"));
        modelQuizs.add(new ModelQuiz(3,2,1,"Pemijahan ikan nila biasa terjadi di?","Pinggiran kolam","Dasar kolam","Permukaan kolam","Tumbuhan air dipermukaan kolam","Dasar kolam"));
        modelQuizs.add(new ModelQuiz(4,2,1,"Induk ikan nila biasanya mengarami telur dimulutnya selama ?","1 minggu","2 hari","2 minggu","23 jam","1 minggu"));

        modelQuizs.add(new ModelQuiz(0,3,1,"Ikan nila betina memasuki matang gonad setelah berumur ?","2 bulan saja","5 – 6 bulan","3 – 4 bulan ","12 minggu","5 – 6 bulan"));
        modelQuizs.add(new ModelQuiz(1,3,1,"Berikut merupakan ciri ciri ikan nila yang memiliki kualitas unggul, kecuali ?","Gerakan lincah","Badan tebal","Ekor panjang","Mengkilap","Ekor panjang"));
        modelQuizs.add(new ModelQuiz(2,3,1,"Masa produktivitas indukan untuk pembenihan ikan  nila berkisaran?","1,5-2 tahun","1 tahun saja","3 tahun","10 tahun","1,5-2 tahun"));
        modelQuizs.add(new ModelQuiz(3,3,1,"Pemberian pakan untuk calon indukan sebainya memiliki ?","Vitamin","Protein tinggi","Kalsium","Tumbuhan air","Protein tinggi"));
        modelQuizs.add(new ModelQuiz(4,3,1,"Jumlah pakan yang di perlukan untuk untuk pemeliharaan indukan sebanyak ?","3% dari bobot tubuhnya","2% dari bobot tubuhnya","4% dari bobot tubuhnya","7% dari bobot tubuhnya","3% dari bobot tubuhnya"));

        modelQuizs.add(new ModelQuiz(0,4,1,"Dibandingkan dengan kolam lain, apa keunggulan dari kolam tanah ?","Biaya murah","Semua jawaban benar","Tempat tumbuh pakan alami","Mudah membuatnya","Semua jawaban benar"));
        modelQuizs.add(new ModelQuiz(1,4,1,"Berikut merupakan tahapan penyiapan kolam ikan nila dengan urut yang benar adalah ?","Penjemuran - pengairan - pembajakan tanah – pengapuran – pemupukan - pengairan","Penjemuran - pengapuran – pembajakan tanah – pemupukan - pengairan","Pembajakan tanah – pengapuran – pemupukan – pengairan - Penjemuran","Penjemuran - pembajakan tanah – pengapuran – pemupukan - pengairan","Penjemuran - pembajakan tanah – pengapuran – pemupukan - pengairan"));
        modelQuizs.add(new ModelQuiz(2,4,1,"Penjemuran biasanya berlangsung selama ?","3-7 hari","1 hari saja","2 minggu","2 hari","3-7 hari"));
        modelQuizs.add(new ModelQuiz(3,4,1,"pH optimal untuk budidaya ikan nila ada pada kisaran ?","2-3","7-8","10","6","7-8"));
        modelQuizs.add(new ModelQuiz(4,4,1,"Ketinggian air kolam maksimal dalam pembenihan ikan nila berkisar antara ?","60–70 cm","1 meter","2 meter","30 cm","60-70 cm"));

        modelQuizs.add(new ModelQuiz(0,5,1,"Pemijahan ikan nila biasanya terjadi di?","Pinggir kolam","Dasar kolam","Permukaan kolam","Semua jawaban benar","Dasar kolam"));
        modelQuizs.add(new ModelQuiz(1,5,1,"Telur di erami didalam mulut ikan nila biasanya akan menetas dalam kurun waktu ?","2 minggu","3 minggu","1 minggu","5 hari","1 minggu"));
        modelQuizs.add(new ModelQuiz(2,5,1,"Pemindahan dilakukan setelah larva berumur?","5-7 hari","3 hari","10 hari","20 hari","5-7 hari"));
        modelQuizs.add(new ModelQuiz(3,5,1,"Ketika larva berumur 5 – 7 hari , frekuensi pemberian pakannya adalah ?","3 kali","5-4 kali","6 kali","1-3 kali","5-4 kali"));
        modelQuizs.add(new ModelQuiz(4,5,1,"Ketika masih larva sebaiknya memberikan pakan yang memiliki ?","Protein tinggi","Vitamin","Zat besi","Gizi tinggi","Protein tinggi"));

//Lele
        modelQuizs.add(new ModelQuiz(0, 1, 2, "Ikan lele termasuk jenis ikan yang dihidup di air ?", "Laut", "Tawar", "Payau", "Semua jawaban benar", "Tawar"));
        modelQuizs.add(new ModelQuiz(1, 1, 2, "Berikut merupakan ciri-ciri ikan lele yang benar adalah ?", "Tubuh licin, pipih memanjang, serta memiliki kumis", "Tubuh bersisik, lonjong, serta memiliki kumis", "Tubuh licin, lonjong, serta tidak memiliki kumis", "Tubuh bersisik, pipih memanjang, serta tidak memiliki kumis", "Tubuh licin, pipih memanjang, serta memiliki kumis"));
        modelQuizs.add(new ModelQuiz(2, 1, 2, "Apa fungsi sungut yang ada pada ikan lele ?", "Peraba di air yang gelap", "Peraba di air yang dingin", "Pemancar sinyal", "Tidak berfungsi", "Peraba di air yang gelap"));
        modelQuizs.add(new ModelQuiz(3, 1, 2, "Ikan lele mempunyai pertahanan tubuh berbentuk tulang tajam pada sirip-sirip dadanya yang disebut ?", "Tanduk", "Sungut", "Patil", "Taring", "Patil"));
        modelQuizs.add(new ModelQuiz(4, 1, 2, "Berikut adalah tahapan-tahapan pembenihan ikan lele secara urut yang benar adalah ?", "Masukkan kolam khusus-Pemijahan-Pisahkan indukan dengan larva-Pemeliharaan larva-Pilih indukan", "Memilih indukan-Masukkan kolam khusus-Pemijahan-Pisahkan indukan dengan larva-Pemeliharaan larva", "Pemeliharaan larva-Memilih indukan-Masukkan kolam khusus-Pemijahan-Pisahkan indukan dengan larva", "Memilih indukan-Pemijahan-Pisahkan indukan dengan larva-Pemeliharaan larva-Masukkan kolam khusus", "Memilih indukan-Masukkan kolam khusus-Pemijahan-Pisahkan indukan dengan larva-Pemeliharaan larva"));

        modelQuizs.add(new ModelQuiz(0, 2, 2, "Indukan ikan lele yang bersifat unggul memiliki ciri ciri ?","Tidak cacat, memiliki sungut panjang, sirip panjang","Tidak cacat, memiliki bentuk tubuh yang baik, lompatan tinggi","Tidak cacat, memiliki bentuk tubuh yang baik, gerakannya lincah","Semua jawaban benar","Tidak cacat, memiliki bentuk tubuh yang baik, gerakannya lincah"));
        modelQuizs.add(new ModelQuiz(1, 2, 2, "Pemijahan yang perkawinannya tidak memerlukan campur tangan manusia dalam proses pembuahan sel telur dengan sperma disebut ?","Perkawinan alami","Penyuntikan hipofisa","Penyuntikan hormon buatan","Pembuahan in vitro (dalam tabung)","Perkawinan alami"));
        modelQuizs.add(new ModelQuiz(2, 2, 2, "Berapa banyak butir telur yang dihasilkan indukan lele untuk sekali memijah ?","20 ribu – 30 ribu butir","3 butir","5000 – 10.000 butir","Ratusan butir","20 ribu – 30 ribu butir"));
        modelQuizs.add(new ModelQuiz(3, 2, 2, "Mengapa setelah terjadi proses pemijahan indukan ikan lele harus dipisahkan dari telurnya ?","Menantisipasi agar indukan kekurangan makanan","Mengantisipasi agar indukan stres","Mengantisipasi agar telurnya tidak dimakan","Mengantisipasi agar telur tidak tenggelam","Mengantisipasi agar telurnya tidak dimakan"));
        modelQuizs.add(new ModelQuiz(4, 2, 2, "Pada larva ikan lele biasanya masih membawa persediaan makanan dalam dirinya, jadi tidak perlu diberi pakan yang bertahan sampai ?","1 minggu","3-4 hari","1 hari","23 jam saja","3-4 hari"));

        modelQuizs.add(new ModelQuiz(0, 3, 2,"Persyaratan krusial yang harus dilakukan sebelum memijahkan ikan adalah ?","pH air kolam","Perawatan kolam","Pemilihan indukan","Semua jawaban benar","Pemilihan indukan"));
        modelQuizs.add(new ModelQuiz(1, 3, 2,"Sebaiknya indukan ikan lele tidak mengalami kelainan fisik yang dapat mempengaruhi kepada ?","Benih yang dihasilkan","Proses pemijahan","Pemberian pakan","Pendederan ikan","Benih yang dihasilkan"));
        modelQuizs.add(new ModelQuiz(2, 3, 2,"Bagian perut membesar ke arah anus merupakan ciri ciri dari ikan  ?","Lele betina","Nila jantan","Lele jantan","Hiu putih","Lele betina"));
        modelQuizs.add(new ModelQuiz(3, 3, 2,"Berikut merupakan ciri ciri dari ikan lele jantan adalah ?","Tubuh ramping, alat kelamin putih","Tubuh bulat, alat kelamin putih","Tubuh ramping, alat kelamin merah","Tubuh bulat, alat kelamin merah","Tubuh ramping, alat kelamin merah"));
        modelQuizs.add(new ModelQuiz(4, 3, 2,"Apa akibat yang terjadi jika memijahkan ikan lele dengan kualitas indukan yang asal pilih ?","Gagal bertelur","Terjadi perkawinan sekerabat","Ikan jantan mati","Pemijahan lama","Terjadi perkawinan sekerabat"));

        modelQuizs.add(new ModelQuiz(0, 4, 2, "Tipe-tipe kolam yang umum digunakan dalam budidaya ikan lele kecuali ?","Kolam tanah","kolam terpal","Kolam dangkal","Kolam jaring","Kolam dangkal"));
        modelQuizs.add(new ModelQuiz(1, 4, 2, "Setelah pengeringan dan pengolahan tanah tahapan berikutnya adalah ?","Jawaban b dan d benar","Pengapuran","Pendederan","Pemupukan","Jawaban b dan d benar"));
        modelQuizs.add(new ModelQuiz(2, 4, 2, "Tahapan yang harus dilakukan dalam menyiapkan kolam tanah ikan kecuali ?","Pemeriksaan dasar kolam","Pengaturan air kolam","Pengeringan dan pengolahan tanah","Pengeringan dan pengolahan tanah","Pemeriksaan dasar kolam"));
        modelQuizs.add(new ModelQuiz(3, 4, 2, "Pada tahap pengapuran jenis kapur yang digunakan adalah?","Barus","Gamping","Dolomid","Semua jawaban benar","Dolomid"));
        modelQuizs.add(new ModelQuiz(4, 4, 2, "Ketinggian air yang ideal untuk budidaya ikan lele adalah ?","200 cm","100-120 cm","50 cm","3 m","100-120 cm"));
//belum
        modelQuizs.add(new ModelQuiz(0, 5, 2, "Ikan lele termasuk jenis ikan yang dihidup di air ?", "Laut", "Tawar", "Payau", "Semua jawaban benar", "Tawar"));
        modelQuizs.add(new ModelQuiz(1, 5, 2, "Berikut merupakan ciri-ciri ikan lele yang benar adalah ?", "Tubuh licin, pipih memanjang, serta memiliki kumis", "Tubuh bersisik, lonjong, serta memiliki kumis", "Tubuh licin, lonjong, serta tidak memiliki kumis", "Tubuh bersisik, pipih memanjang, serta tidak memiliki kumis", "Tubuh licin, pipih memanjang, serta memiliki kumis"));
        modelQuizs.add(new ModelQuiz(2, 5, 2, "Apa fungsi sungut yang ada pada ikan lele ?", "Peraba di air yang gelap", "Peraba di air yang dingin", "Pemancar sinyal", "Tidak berfungsi", "Peraba di air yang gelap"));
        modelQuizs.add(new ModelQuiz(3, 5, 2, "Ikan lele mempunyai pertahanan tubuh berbentuk tulang tajam pada sirip-sirip dadanya yang disebut ?", "Tanduk", "Sungut", "Patil", "Taring", "Patil"));
        modelQuizs.add(new ModelQuiz(4, 5, 2, "Berikut adalah tahapan-tahapan pembenihan ikan lele secara urut yang benar adalah ?", "Masukkan kolam khusus-Pemijahan-Pisahkan indukan dengan larva-Pemeliharaan larva-Pilih indukan", "Memilih indukan-Masukkan kolam khusus-Pemijahan-Pisahkan indukan dengan larva-Pemeliharaan larva", "Pemeliharaan larva-Memilih indukan-Masukkan kolam khusus-Pemijahan-Pisahkan indukan dengan larva", "Memilih indukan-Pemijahan-Pisahkan indukan dengan larva-Pemeliharaan larva-Masukkan kolam khusus", "Memilih indukan-Masukkan kolam khusus-Pemijahan-Pisahkan indukan dengan larva-Pemeliharaan larva"));

//Koi
        modelQuizs.add(new ModelQuiz(0, 1, 3, "Apa fungsi kumis kecil yang ada pada ikan koi ?", "Mendeteksi makanan", "Menangkap massa", "Merpetahankan diri", "Tidak berfungsi", "Mendeteksi makanan"));
        modelQuizs.add(new ModelQuiz(1, 1, 3, "Berasal dari Negara manakah sebenarnya ikan koi ?", "Indonesia", "Malaysia", "Korea selatan", "Jepang", "Jepang"));
        modelQuizs.add(new ModelQuiz(2, 1, 3, "Untuk jenis-jenis ikan dari ikan koi dapat dibedakan dan dilihat dari ?", "Warna, sungut dan polanya", "Warna, pola dan ukurannya", "Pola, ukuran dan makanannya", "Pola, warna dan makanannya", "Warna, pola dan ukurannya"));
        modelQuizs.add(new ModelQuiz(3, 1, 3, "Berikut adalah tahapan tahapan pembenihan ikan lele secara urut yang benar adalah ?", "Pemeliharaan larva - Memilih indukan – Masukkan kolam khusus – Pemijahan – Pisahkan indukan kekolam lain", "Memilih indukan – Pemijahan – Pisahkan indukan kekolam lain – Pemeliharaan larva –  Masukkan kolam khusus", "Masukkan kolam khusus  – Pemijahan – Pisahkan indukan kekolam lain – Pemeliharaan larva – Pilih indukan", "Memilih indukan – Masukkan kolam khusus – Pemijahan – Pisahkan indukan kekolam lain – Pemeliharaan larva", "Memilih indukan – Masukkan kolam khusus – Pemijahan – Pisahkan indukan kekolam lain – Pemeliharaan larva"));
        modelQuizs.add(new ModelQuiz(4, 1, 3, "Apa alat yang membantu ikan gurame hingga bisa berenang dengan cepat ?", "Selaput sirip", "Sungut", "Rahang bawah", "Moncong", "Selaput sirip"));

        modelQuizs.add(new ModelQuiz(0, 2, 3, "Fungsi saringan halus pada tempat keluar masuknyanya air pada kolam adalah ?","Menjaga kualitas air kolam","Menyaring kotoran","Mencegah larva masuk dan mencegah hama keluar","Mencegah larva keluar dan mencegah hama masuk","Mencegah larva keluar dan mencegah hama masuk"));
        modelQuizs.add(new ModelQuiz(1, 2, 3,"Berikut merupakan ciri ciri indukan ikan koi yang memiliki kualias unggul, kecuali ?","Kumis tebal","Bentuk seperti torpedo","Usia diats 2 tahun","Warna mencolok","Kumis tebal"));
        modelQuizs.add(new ModelQuiz(2, 2, 3,"Pada pemijahan ikan koi biasanya indukan betina dimasukkan kolam pemijahan terlebih dahulu, apa fungsinya ?","Agar ikan dapat memijah cepat","Agar ikan mendapat makanan yang banyak","Agar ikan beradaptasi","Agar ikan memperoleh oksigen yang cukup","Agar ikan beradaptasi"));
        modelQuizs.add(new ModelQuiz(3, 2, 3,"Berapa banyak ikan koi jantang pada 1 kali proses pemijahan ?","3-5 ekor","10 ekor","1 ekor","6-8 ekor","3-5 ekor"));
        modelQuizs.add(new ModelQuiz(4, 2, 3,"Pada keadaan normal telur ikan koi akan menetas dalam jangka waktu ?","23 jam","48 jam","36 jam","24 jam","48 jam"));
//belum
        modelQuizs.add(new ModelQuiz(0, 3, 3, "Apa fungsi kumis kecil yang ada pada ikan koi ?", "Mendeteksi makanan", "Menangkap massa", "Merpetahankan diri", "Tidak berfungsi", "Mendeteksi makanan"));
        modelQuizs.add(new ModelQuiz(1, 3, 3, "Berasal dari Negara manakah sebenarnya ikan koi ?", "Indonesia", "Malaysia", "Korea selatan", "Jepang", "Jepang"));
        modelQuizs.add(new ModelQuiz(2, 3, 3, "Untuk jenis-jenis ikan dari ikan koi dapat dibedakan dan dilihat dari ?", "Warna, sungut dan polanya", "Warna, pola dan ukurannya", "Pola, ukuran dan makanannya", "Pola, warna dan makanannya", "Warna, pola dan ukurannya"));
        modelQuizs.add(new ModelQuiz(3, 3, 3, "Berikut adalah tahapan tahapan pembenihan ikan lele secara urut yang benar adalah ?", "Pemeliharaan larva - Memilih indukan – Masukkan kolam khusus – Pemijahan – Pisahkan indukan kekolam lain", "Memilih indukan – Pemijahan – Pisahkan indukan kekolam lain – Pemeliharaan larva –  Masukkan kolam khusus", "Masukkan kolam khusus  – Pemijahan – Pisahkan indukan kekolam lain – Pemeliharaan larva – Pilih indukan", "Memilih indukan – Masukkan kolam khusus – Pemijahan – Pisahkan indukan kekolam lain – Pemeliharaan larva", "Memilih indukan – Masukkan kolam khusus – Pemijahan – Pisahkan indukan kekolam lain – Pemeliharaan larva"));
        modelQuizs.add(new ModelQuiz(4, 3, 3, "Apa alat yang membantu ikan gurame hingga bisa berenang dengan cepat ?", "Selaput sirip", "Sungut", "Rahang bawah", "Moncong", "Selaput sirip"));

        modelQuizs.add(new ModelQuiz(0, 4, 3, "Apa fungsi kumis kecil yang ada pada ikan koi ?", "Mendeteksi makanan", "Menangkap massa", "Merpetahankan diri", "Tidak berfungsi", "Mendeteksi makanan"));
        modelQuizs.add(new ModelQuiz(1, 4, 3, "Berasal dari Negara manakah sebenarnya ikan koi ?", "Indonesia", "Malaysia", "Korea selatan", "Jepang", "Jepang"));
        modelQuizs.add(new ModelQuiz(2, 4, 3, "Untuk jenis-jenis ikan dari ikan koi dapat dibedakan dan dilihat dari ?", "Warna, sungut dan polanya", "Warna, pola dan ukurannya", "Pola, ukuran dan makanannya", "Pola, warna dan makanannya", "Warna, pola dan ukurannya"));
        modelQuizs.add(new ModelQuiz(3, 4, 3, "Berikut adalah tahapan tahapan pembenihan ikan lele secara urut yang benar adalah ?", "Pemeliharaan larva - Memilih indukan – Masukkan kolam khusus – Pemijahan – Pisahkan indukan kekolam lain", "Memilih indukan – Pemijahan – Pisahkan indukan kekolam lain – Pemeliharaan larva –  Masukkan kolam khusus", "Masukkan kolam khusus  – Pemijahan – Pisahkan indukan kekolam lain – Pemeliharaan larva – Pilih indukan", "Memilih indukan – Masukkan kolam khusus – Pemijahan – Pisahkan indukan kekolam lain – Pemeliharaan larva", "Memilih indukan – Masukkan kolam khusus – Pemijahan – Pisahkan indukan kekolam lain – Pemeliharaan larva"));
        modelQuizs.add(new ModelQuiz(4, 4, 3, "Apa alat yang membantu ikan gurame hingga bisa berenang dengan cepat ?", "Selaput sirip", "Sungut", "Rahang bawah", "Moncong", "Selaput sirip"));

        modelQuizs.add(new ModelQuiz(0, 5, 3, "Apa fungsi kumis kecil yang ada pada ikan koi ?", "Mendeteksi makanan", "Menangkap massa", "Merpetahankan diri", "Tidak berfungsi", "Mendeteksi makanan"));
        modelQuizs.add(new ModelQuiz(1, 5, 3, "Berasal dari Negara manakah sebenarnya ikan koi ?", "Indonesia", "Malaysia", "Korea selatan", "Jepang", "Jepang"));
        modelQuizs.add(new ModelQuiz(2, 5, 3, "Untuk jenis-jenis ikan dari ikan koi dapat dibedakan dan dilihat dari ?", "Warna, sungut dan polanya", "Warna, pola dan ukurannya", "Pola, ukuran dan makanannya", "Pola, warna dan makanannya", "Warna, pola dan ukurannya"));
        modelQuizs.add(new ModelQuiz(3, 5, 3, "Berikut adalah tahapan tahapan pembenihan ikan lele secara urut yang benar adalah ?", "Pemeliharaan larva - Memilih indukan – Masukkan kolam khusus – Pemijahan – Pisahkan indukan kekolam lain", "Memilih indukan – Pemijahan – Pisahkan indukan kekolam lain – Pemeliharaan larva –  Masukkan kolam khusus", "Masukkan kolam khusus  – Pemijahan – Pisahkan indukan kekolam lain – Pemeliharaan larva – Pilih indukan", "Memilih indukan – Masukkan kolam khusus – Pemijahan – Pisahkan indukan kekolam lain – Pemeliharaan larva", "Memilih indukan – Masukkan kolam khusus – Pemijahan – Pisahkan indukan kekolam lain – Pemeliharaan larva"));
        modelQuizs.add(new ModelQuiz(4, 5, 3, "Apa alat yang membantu ikan gurame hingga bisa berenang dengan cepat ?", "Selaput sirip", "Sungut", "Rahang bawah", "Moncong", "Selaput sirip"));

//Gurami
        modelQuizs.add(new ModelQuiz(0, 1, 4, "Ikan gurame dapat hidup di ?", "Sungai", "Rawa", "Air payau", "Semua jawaban benar", "Semua jawaban benar"));
        modelQuizs.add(new ModelQuiz(1, 1, 4, "Habitat yang paling disukai oleh ikan gurame adalah ... .", "Berlumpur serta dalam", "Kolam dangkal berlumpur dengan banyak tumbuhan air", "Banyak pohon pohon di sekitar kolam", "Kolam yang bening dengan banyak tumbuhan air", "Kolam dangkal berlumpur dengan banyak tumbuhan air"));
        modelQuizs.add(new ModelQuiz(2, 1, 4, "Bagaimana cara indukan ikan gurame untuk melindungi telur telurnya ?", "Menyimpan didalam mulutnya", "Diletakkan di sarang yang dibuat dari tetumbuhan air", "Membiarkannya didasar kolam", "Menempelkan telur  ke dinding kolam", "Diletakkan di sarang yang dibuat dari tetumbuhan air"));
        modelQuizs.add(new ModelQuiz(3, 1, 4, "Apa proses tahapan setelah ikan durame berhasil dipijahkan ?", "Ambil sarang yang berisi telur dan cuci telur", "Membiarkannya sampai menetas", "Mempersiapkan kolam untuk tempat pemijahan", "Mengambil indukannya", "Ambil sarang yang berisi telur dan cuci telur"));
        modelQuizs.add(new ModelQuiz(4, 1, 4, "Sampai berapakan total panjang ikan gurame jika dihitung dengan ekor dan siripnya ?", "2 meter", "1000 mm", "3 cm", "50 cm", "1000 mm"));

        modelQuizs.add(new ModelQuiz(0, 2, 4, "Ikan gurame dapat hidup di ?", "Sungai", "Rawa", "Air payau", "Semua jawaban benar", "Semua jawaban benar"));
        modelQuizs.add(new ModelQuiz(1, 2, 4, "Habitat yang paling disukai oleh ikan gurame adalah ... .", "Berlumpur serta dalam", "Kolam dangkal berlumpur dengan banyak tumbuhan air", "Banyak pohon pohon di sekitar kolam", "Kolam yang bening dengan banyak tumbuhan air", "Kolam dangkal berlumpur dengan banyak tumbuhan air"));
        modelQuizs.add(new ModelQuiz(2, 2, 4, "Bagaimana cara indukan ikan gurame untuk melindungi telur telurnya ?", "Menyimpan didalam mulutnya", "Diletakkan di sarang yang dibuat dari tetumbuhan air", "Membiarkannya didasar kolam", "Menempelkan telur  ke dinding kolam", "Diletakkan di sarang yang dibuat dari tetumbuhan air"));
        modelQuizs.add(new ModelQuiz(3, 2, 4, "Apa proses tahapan setelah ikan durame berhasil dipijahkan ?", "Ambil sarang yang berisi telur dan cuci telur", "Membiarkannya sampai menetas", "Mempersiapkan kolam untuk tempat pemijahan", "Mengambil indukannya", "Ambil sarang yang berisi telur dan cuci telur"));
        modelQuizs.add(new ModelQuiz(4, 2, 4, "Sampai berapakan total panjang ikan gurame jika dihitung dengan ekor dan siripnya ?", "2 meter", "1000 mm", "3 cm", "50 cm", "1000 mm"));

        modelQuizs.add(new ModelQuiz(0, 3, 4, "Ikan gurame dapat hidup di ?", "Sungai", "Rawa", "Air payau", "Semua jawaban benar", "Semua jawaban benar"));
        modelQuizs.add(new ModelQuiz(1, 3, 4, "Habitat yang paling disukai oleh ikan gurame adalah ... .", "Berlumpur serta dalam", "Kolam dangkal berlumpur dengan banyak tumbuhan air", "Banyak pohon pohon di sekitar kolam", "Kolam yang bening dengan banyak tumbuhan air", "Kolam dangkal berlumpur dengan banyak tumbuhan air"));
        modelQuizs.add(new ModelQuiz(2, 3, 4, "Bagaimana cara indukan ikan gurame untuk melindungi telur telurnya ?", "Menyimpan didalam mulutnya", "Diletakkan di sarang yang dibuat dari tetumbuhan air", "Membiarkannya didasar kolam", "Menempelkan telur  ke dinding kolam", "Diletakkan di sarang yang dibuat dari tetumbuhan air"));
        modelQuizs.add(new ModelQuiz(3, 3, 4, "Apa proses tahapan setelah ikan durame berhasil dipijahkan ?", "Ambil sarang yang berisi telur dan cuci telur", "Membiarkannya sampai menetas", "Mempersiapkan kolam untuk tempat pemijahan", "Mengambil indukannya", "Ambil sarang yang berisi telur dan cuci telur"));
        modelQuizs.add(new ModelQuiz(4, 3, 4, "Sampai berapakan total panjang ikan gurame jika dihitung dengan ekor dan siripnya ?", "2 meter", "1000 mm", "3 cm", "50 cm", "1000 mm"));

        modelQuizs.add(new ModelQuiz(0, 4, 4, "Ikan gurame dapat hidup di ?", "Sungai", "Rawa", "Air payau", "Semua jawaban benar", "Semua jawaban benar"));
        modelQuizs.add(new ModelQuiz(1, 4, 4, "Habitat yang paling disukai oleh ikan gurame adalah ... .", "Berlumpur serta dalam", "Kolam dangkal berlumpur dengan banyak tumbuhan air", "Banyak pohon pohon di sekitar kolam", "Kolam yang bening dengan banyak tumbuhan air", "Kolam dangkal berlumpur dengan banyak tumbuhan air"));
        modelQuizs.add(new ModelQuiz(2, 4, 4, "Bagaimana cara indukan ikan gurame untuk melindungi telur telurnya ?", "Menyimpan didalam mulutnya", "Diletakkan di sarang yang dibuat dari tetumbuhan air", "Membiarkannya didasar kolam", "Menempelkan telur  ke dinding kolam", "Diletakkan di sarang yang dibuat dari tetumbuhan air"));
        modelQuizs.add(new ModelQuiz(3, 4, 4, "Apa proses tahapan setelah ikan durame berhasil dipijahkan ?", "Ambil sarang yang berisi telur dan cuci telur", "Membiarkannya sampai menetas", "Mempersiapkan kolam untuk tempat pemijahan", "Mengambil indukannya", "Ambil sarang yang berisi telur dan cuci telur"));
        modelQuizs.add(new ModelQuiz(4, 4, 4, "Sampai berapakan total panjang ikan gurame jika dihitung dengan ekor dan siripnya ?", "2 meter", "1000 mm", "3 cm", "50 cm", "1000 mm"));

        modelQuizs.add(new ModelQuiz(0, 5, 4, "Ikan gurame dapat hidup di ?", "Sungai", "Rawa", "Air payau", "Semua jawaban benar", "Semua jawaban benar"));
        modelQuizs.add(new ModelQuiz(1, 5, 4, "Habitat yang paling disukai oleh ikan gurame adalah ... .", "Berlumpur serta dalam", "Kolam dangkal berlumpur dengan banyak tumbuhan air", "Banyak pohon pohon di sekitar kolam", "Kolam yang bening dengan banyak tumbuhan air", "Kolam dangkal berlumpur dengan banyak tumbuhan air"));
        modelQuizs.add(new ModelQuiz(2, 5, 4, "Bagaimana cara indukan ikan gurame untuk melindungi telur telurnya ?", "Menyimpan didalam mulutnya", "Diletakkan di sarang yang dibuat dari tetumbuhan air", "Membiarkannya didasar kolam", "Menempelkan telur  ke dinding kolam", "Diletakkan di sarang yang dibuat dari tetumbuhan air"));
        modelQuizs.add(new ModelQuiz(3, 5, 4, "Apa proses tahapan setelah ikan durame berhasil dipijahkan ?", "Ambil sarang yang berisi telur dan cuci telur", "Membiarkannya sampai menetas", "Mempersiapkan kolam untuk tempat pemijahan", "Mengambil indukannya", "Ambil sarang yang berisi telur dan cuci telur"));
        modelQuizs.add(new ModelQuiz(4, 5, 4, "Sampai berapakan total panjang ikan gurame jika dihitung dengan ekor dan siripnya ?", "2 meter", "1000 mm", "3 cm", "50 cm", "1000 mm"));

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(this,"Tidak Dapat Kembali",Toast.LENGTH_LONG);
    }
}
