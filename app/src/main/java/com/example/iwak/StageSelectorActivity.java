package com.example.iwak;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iwak.model.ModelNilai;
import com.example.iwak.model.ModelStage;

import java.util.ArrayList;
import java.util.List;

import static com.example.iwak.RVStage.idIkan;
import static com.example.iwak.database.MyApp.db;

public class StageSelectorActivity extends AppCompatActivity {
    public static String TITLE = "TITLE";
    public List<ModelNilai> nilais;

    public static ArrayList<ModelStage> modelStages = new ArrayList<>();
    public ArrayList<ModelStage> modelStage = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage_selector);
        RecyclerView recycleView = findViewById(R.id.rv);
        TextView textView = findViewById(R.id.title);
        setdata();
        nilais = db.nilaiDao().SelectHasil(getIntent().getIntExtra(TITLE, 0));
        idIkan = getIntent().getIntExtra(StageSelectorActivity.TITLE, 0);
        RVStage rvSelector = new RVStage();
        recycleView.setAdapter(rvSelector);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        for (int i = 0; i < modelStages.size(); i++) {
            if (modelStages.get(i).getIdIkan() == getIntent().getIntExtra(StageSelectorActivity.TITLE, 0)) {
                modelStage.add(modelStages.get(i));
            }
        }
        rvSelector.setArrayList(modelStage, nilais);
    }


    public void setdata() {
        modelStages.clear();
        modelStages.add(new ModelStage(1, 1, "Stage 1 : Pengenalan", "Ikan nila adalah sejenis ikan konsumsi air tawar, Tubuh berwarna kehitaman atau keabuan, dengan beberapa pita gelap melintang (belang) yang makin mengabur pada ikan dewasa. Ekor bergaris-garis tegak, 7-12 buah. Tenggorokan, sirip dada, sirip perut, sirip ekor dan ujung sirip punggung dengan warna merah atau kemerahan (atau kekuningan) ketika musim berbiak. ). Telur ikan nila berbentuk bulat berwarna kekuningan dengan diameter sekitar 2,8 mm. Sekali memijah, ikan nila betina dapat mengeluarkan telur sebanyak 300-1.500 butir,"));
        modelStages.add(new ModelStage(2, 1, "Stage 2 : Perawatan Benih", "Ikan Nila yang berkulaitas unggul memiliki beberapa ciri-ciri seperti Tidak cacat, badan tebal, sisik mengkilap dan lincah. Dan sebelum pemijahan harus dipisahkan anatara jantan dan betina agar tidak terjadi pembuahan liar. Induk nila biasanya mengerami telur selama seminggu. Dan pemijahan in biasanya di dasar kolam "));
        modelStages.add(new ModelStage(3, 1, "Stage 3 : Pemilihan indukan", "Ikan nila betina memasuki matang gonad setelah berumur 5-6 bulan. Induk betina yang akan dipijahkan setidaknya telah mencapai bobot 200-250 gram dan untuk induk jantan 250-300 gram. Seperti yang sudah di sebutkan sebelumnya ikan nila termakasuk ikan yang jumlahnya tidak sedikit. satu induk betina dengan berat 200-250gram hanya mengandung telur 500-1000 butir."));
        modelStages.add(new ModelStage(4, 1, "Stage 4 : Penyiapan Kolam", "Budidaya ikan nila bisa menggunakan berbagai jenis kolam, mulai dari kolam tanah, kolam semen, kolam terpal, jaring terapung hingga tambak air payau. Dari sekian jenis kolam tersebut, kolam tanah paling banyak digunakan karena cara membuatnya cukup mudah dan biaya konstruksinya murah. Keunggulan lain kolam tanah adalah bisa menjadi tempat tumbuh berbagai tumbuhan dan hewan yang bermanfaat sebagai pakan alami bagi ikan. Sehingga bisa mengurangi biaya pembelian pakan buatan atau pelet. Untuk memulai budidaya ikan nila di kolam tanah, perlu langkah-langkah persiapan pengolahan tanah. Mulai dari penjemuran, pembajakan tanah, pengapuran, pemupukan hingga pengairan."));
        modelStages.add(new ModelStage(5, 1, "Stage 5 : Pemijahan", "Pemijahan ikan nila intensif biasanya dipakai untuk memproduksi benih dalam jumlah besar. Karena untuk membangun infrastrukturnya membutuhkan modal besar. Kali ini kami hanya akan mengulas pemijahan ikan nila secara alami. Dasar kolam pemijahan ikan nila sebaiknya dibuat miring sekitar 2-5%. Kemudian buat kemalir atau kubangan di dasar kolam tersebut sedalam 20-30 cm sebagai lokasi-lokasi ikan memijah. Padat tebar kolam pemijahan sebanyak 1 ekor/m2, dengan perbandingan jantan dan betina 1:3. Selama proses pemijahan, berikan pakan seperti di kolam pemeliharaan induk. Pemijahan ikan nila biasanya akan berlangsung pada hari ke-7 sejak indukan ditebar. Larva ikan nila yang telah menetas, sebaiknya dibesarkan di tempat khusus. Pemindahan dilakukan setelah larva berumur 5-7 hari. Berikan pakan berprotein tinggi berbentuk tepung halus berukuran 0,2-0,5 mm. Frekuensi pemberian pakan 4-5 kali sehari, setiap kalinya sebanyak 1 sendok teh pakan berbentuk tepung"));

        modelStages.add(new ModelStage(1, 2, "Stage 1 : Pengenalan", "Ikan lele adalah  sejenis ikan yang hidup di air tawar. Lele mudah dikenali karena tubuhnya yang licin, agak pipih memanjang, serta memiliki \"kumis\" yang panjang, yang mencuat dari sekitar bagian mulutnya. dengan empat pasang sungut peraba (barbels) yang amat berguna untuk bergerak di air yang gelap. Lele juga memiliki alat pernapasan tambahan berupa modifikasi dari busur insangnya. Terdapat sepasang patil, yakni duri tulang yang tajam, pada sirip-sirip dadanya. . Ikan lele bersifat nokturnal, yaitu aktif bergerak mencari makanan pada malam hari"));
        modelStages.add(new ModelStage(2, 2, "Stage 2 : Perawatan Benih", "Indukan lele yang unggul memiliki ciri-ciri Tidak cacat, memiliki bentuk tubuh yang baik, gerakannya lincah Lele sekali memijah biasanya menghasilkan telur 20 ribu – 30 ribu butir. proses pemijahan indukan ikan lele harus dipisahkan dari telurnya untuk mengantisipasi telurnya tdak dimakan"));
        modelStages.add(new ModelStage(3, 2, "Stage 3 : Pemilihan indukan", "Pemilihan induk ikan  yang baik merupakan persyaratan yang krusial dalam kegiatan pembenihan ikan, hal ini dikarenakan dari hasil seleksi yang kurang baik maka benih yang akan dihasilkan juga tidak akan baik. Induk ikan lele yang bersifat unggul akan mempengaruhi kualitas benih yang dihasilkan. Banyak sekali pembenih ikan melakukan pemijahan dengan menggunakan induk yang tidak jelas asal usulnya  sehingga dimungkinkan terjadinya perkawinan sekerabat(Inbreeding) yang beresiko menuruni sifat resesif dari induknya yang bersifat merusak kualitas benih, diantaranya pertumbuhan benih yang dihasilkan lambat serta rentan terhadap serangan penyakit sehingga mengakibatkan kualitas benih yang dihasilkan jauh dari standar. "));
        modelStages.add(new ModelStage(4, 2, "Stage 4 : Penyiapan Kolam", "Sebelum benih ikan lele ditebarkan, kolam harus dikeringkan telebih dahulu. Lama pegeringan berkisar 3-7 hari atau bergantung pada teriknya sinar matahari. Ketinggian air yang ideal untuk budidaya ikan lele adalah 100-120 cm. Pengisian kolam dilakukan secara bertahap. Setelah kolam dipupuk, isi dengan air sampai batas 30-40 cm. Pengapuran berfungsi untuk menyeimbangkan keasaman kolam dan membantu memberantas mikroorganisme pathogen, Dosis yang diperlukan untuk pengapuran adalah 250-750 gram per meter persegi, atau tergantung pada derajat keasaman tanah. "));
        modelStages.add(new ModelStage(5, 2, "Stage 5 : Pemijahan", "Waktu yang tepat untuk memasukan indukan kedalam kolam pemijahan adalah sore hari. Biasanya ikan lele akan memijah sekitar pukul 23.00 hingga pukul 05.00. Selama proses pemijahan ikan lele kolam harus ditutup, untuk mencegah induk ikan loncat keluar kolam. Pada pagi hari, biasanya proses pemijahan sudah selesai. Telur yang berhasil dibuahi berwarna transparan sedangkan yang gagal berwarna putih susu, Penetasan bisa dilakukan di kolam pemijahan ataupun di tempat lain seperti akuarium, fiberglass atau kolam terpal. Selama proses penetasan suplai oksigen (aerasi) harus dipertahankan dan suhu distabilkan pada kisaran 28-29oC. Dari proses pemijahan akan dihasilkan larva ikan yang harus dibesarkan dalam tahap pembenihan ikan lele selanjutnya. Pisahkan larva dari induknya. Kualitas air kolam untuk pemeliharaan larva harus terjaga. Usahakan ada aerasi dengan aerotor untuk menyuplai oksigen. Suhu kolam harus dipertahankan pada kisaran 28-29oC. Pada suhu dibawah 25oC, biasanya akan terbentuk bintik putih pada larva yang menyebabkan kematian massal."));

        modelStages.add(new ModelStage(1, 3, "Stage 1 : Pengenalan", "Ikan KOI adalah jenis ikan yang hidup di air tawar, Koi sendiri berasal dari negara Jepang,ada beberapa bagian dari kegunaan dari ikan KOI sendiri seperti Selapur sirip untuk membantu ikan koi berenang lebih cepat, kumis kecil untuk mendeteksi makanan dan adatahapan pembenihan untuk ikan koi ini sendiri yaitu : Memilih indukan- Masukkan kolam khusus-pemijahan-pisahkan indukan ke kolam lain-pemeliharaan larva."));
        modelStages.add(new ModelStage(2, 3, "Stage 2 : Perawatan Benih", "Untuk ikan pemijahan ikan koi bisa menyiapkan kolam Ukuran kolam 3x6 m kedalaman 60cm dan ketinggian air 40 cm. indukan jantan bisa dilepaskan di kolam pemijahan. Jumlah indukan jantan yang dimasukkan 3 hingga 5 ekor. Pada keadaan normal, suhu sekitar 27-30 derajat celcius, telur akan menetas dalam waktu 48 jam. Untuk pemeliharaan pakan yang bisa diberikan pada burayak umur 5 hari adalah kuning telur yang telah direbus"));
        modelStages.add(new ModelStage(3, 3, "Stage 3 : Pemilihan indukan", "Ikan KOI yang kualitanya bagus memiliki beberapa ci-ciri seperti sisik acak, warna cemerlah dan kontras, , gerakannya gesit tidak banyak diam di dasar kolam. Jumlah pakan yang diberikan sekitar 3-5% dari bobot tubuhnya dalam satu hari. Frekuensi pemberian pakan 2-4 kali. Sebaiknya calon indukan ikan koi dipelihara dalam kolam khusus. Kedalaman kolam setidaknya 150 cm, lebih dalam lebih baik"));
        modelStages.add(new ModelStage(4, 3, "Stage 4 : Penyiapan Kolam", "Desain kolam pemijahan bisa bervariasi. Luas yang umum bisa berukuran 4×6 meter persegi, atau bisa menggunakan ukuran dengan luas 3 sampai dengan 6 meter persegi. Kedalaman kolam pemijahan kurang lebih 0,5 meter. Desain kolam pemijahan dapat berbentuk persegi, persegi panjang, atau lingkaran. Jika berbentuk lingkaran, anda bisa menggunakan diameter 1,5 sampai 2 meter. . Rata-rata ukuran ijuk yang baik adalah sekitar 120 cm x 40 cm. Jumlah kakaban disesuaikan dengan induk betina. Biasanya disediakan kakaban 4 sapai 6 buah kakaban dengan ukuran di atas, untuk 1 kg induk betina."));
        modelStages.add(new ModelStage(5, 3, "Stage 5 : Pemijahan", "Biarkan indukan betina beradaptasi dengan kondisi kolam agar tidak stres. Setelah 2 hingga 3 jam, indukan jantan bisa dilepaskan di kolam pemijahan. Jumlah indukan jantan yang dimasukkan 3 hingga 5 ekor. Hal ini untuk menghindari kegagalan dalam pemijahan dan semua telur yang dikeluarkan indukan betina bisa terbuahi.  Telur-telur yang menempel pada kakaban atau tanaman air harus terendam dalam air. Oleh karena itu berikan pemberat pada kakaban. Pada keadaan normal, suhu sekitar 27-30 derajat celcius, telur akan menetas dalam waktu 48 jam. Jika suhu air terlampau dingin penetasan akan lebih lama. Bila terlampau panas telur bisa membusuk. Setelah telur menetas kakaban atau tanaman air bisa diangkat. Larva yang baru menetas masih menyimpan persedian makanan yang bisa bertahan hingga 3-5 hari."));

        modelStages.add(new ModelStage(1, 4, "Stage 1 : Pengenalan", "Ikan gurame adalah  sejenis ikan yang hidup di air tawar. Di alam, gurami hidup di sungai-sungai, rawa dan kolam, termasuk pula di air payau, Telurnya dilekatkan di tetumbuhan air atau ditaruh di sarang yang terbuat dari tumbuh-tumbuhan, Ikan yang lebar dan pipih. Panjang tubuh total (dengan sirip ekor) bisa mencapai 1.000 mm. Ikan yang muda memiliki moncong yang meruncing, dengan 8-10 pita melintang (belang) di tubuhnya"));
        modelStages.add(new ModelStage(2, 4, "Stage 2 : Perawatan Benih", "Hal yang dilakukan untuk mempersiapkan kolam pemijahan yakni pengeringan dan pembersihan kolam. Jumlah ikan gurami jantan dan betina berbanding 1:3. Telur akan menetas pada hari ke 2-3 setelah pemijahan. Usahakan telur menetas pada air yang bersih dan suhu air stabil antara 27-28o C. Indukan gurame yang siap dipijahkan adalah yang berumur umur 3-7 tahun."));
        modelStages.add(new ModelStage(3, 4, "Stage 3 : Pemilihan indukan", "Calon indukan ikan jantan harus berusia 4 tahun dengan bobot antara 2 sampai 3 kg. Sedangkan indukan betina harus berumur 3 tahun dengan berat antara 2 sampai 2,5 kg. Indukan ikan gurame yang baik harus memiliki pertumbuhan badan yang baik dan cepat jika memang ikan tersebut dibesarkan sendiri Bentuk tubuh ikan juga harus ideal dengan kondisi yang tidak terlalu panjang, beratnya ideal, ukuran kepala relatif kecil, kulit licin mengkilap, warna sisik lebih cerah, ikan bergerak aktif, dan tidak ditemukan adanya kondisi luka atau cacat pada tubuh ikan."));
        modelStages.add(new ModelStage(4, 4, "Stage 4 : Penyiapan Kolam", "Tahap awal persiapan kolam pemijahan adalah membersihkan kolam, memasang sarang buatan dan mengeringkan kolam terlenih dahulu. Untuk ukuran kolam pemijahan cukup dengan 200 – 250 cm dan dengan kedalaman 1 – 1,5 meter. Selanjutnya kolam di jemur selama 3 – 6 hari atau tergantung kondisi cuaca dan ketebalan lumpurnya. Tujuan dilakukan penjemuran adalah untuk mematikan hama dan penyakit, membuang gas yang dapat membahayakan ikan gurami dan merangsang birahi ikan gurami untuk kawin. Proses pembuahan ikan gurami bisa dipercepat dengan cara membuat sarang buatan. Sarang tersebut dibuat dari ijuk, sabut kelapa, atau dari jerami. Agar bisa menggantung, ijuk harus di jepit dengan bambu atau dibuat para – para dari bambu di bawah permukaan air. Letak pengki di sarankan sekitar 20 – 30 cm di bawah permukaan air. . Pengisisan air dilakukan saat pasangan induk yang akan dipijahkan tersebut dilepas, yakni ketika kedalaman air mencapai 60 – 80 cm. Selama proses pemijahan berlangsung, air dibiarkan terus mengalir sampai pemijahan selesai. Saat proses pemijahan berlangsung ketinggian air diatur antara 1 – 1,5 meter."));
        modelStages.add(new ModelStage(5, 4, "Stage 5 : Pemijahan", "Secara sederhana bila disebutkan pemijahan ikan gurame terbilang tidak rumit. Perbandingan antara indukan betina dan jantan ialah 1:3. Yaitu seperti satu jantan dan satu betina. Setelah semuanya siap tinggal di satukan di kolam pemijahan yang sudah terpasang sarang. Media yang dijadikan tempat penetasan telur budidaya ikan gurame sebaiknya mempunyai lingkungan yang cukup tenang. Proses penetasan  akan memakan waktu cukup lama sekitar 3-4 hari. Pemeliharaan benih dilakukan di kolam yang disiapkan cukup khusus. Seperti mempunyai sirkulasi air yang baik dan kualitas air yang baik pula. Untuk memberi mekanan kepada larva ikan gurame yaitu dengan pelet halus dengan takaran 10% dari total bobot keseluruhan. Untuk menuju masa pendederan perlu waktu sekitar 3-4 bulan pemeliharaan"));

//        modelQuizs.clear();
//
//        modelQuizs.add(new ModelQuiz(1,1,1,"Ikan Nila adalah ikan air","Tawar","Laut","Payau","Gunung Berapi","Tawar"));
//        modelQuizs.add(new ModelQuiz(2 ,1,1,"Jumlah dari garis-haris pada tubuh ikan nila adalah","5 - 8"," 2 - 3","5 - 10","7 - 12","7 - 12"));
//        modelQuizs.add(new ModelQuiz(3,1,1,"Jenis kelamin ikan nila akan terlihat ketika berbobot","40 gram","50 gram","60 gram","70 gram","50 gram"));
//        modelQuizs.add(new ModelQuiz(4,1,1,"Apa ciri-ciri dari ikan nila betina?","Kumis lebih panjang","Perut lebih besar","Warna lebih gelap","Tulang rahang melebar","Perut lebih besar"));
//        modelQuizs.add(new ModelQuiz(5,1,1,"Berikut adalah proses tahapan yang terjadi setelah memilih indukan adalah?","Masukkan indukan ke kolam khusus","Menyiapkan kolam pijah","Telur dieram mulut betina","Pindah larva ikan yg menetas","Masukkan indukan ke kolam khusus"));


//        modelQuizs.add(new ModelQuiz("Stage 1 : Pengenalan","1","Ikan Nila adalah ikan air ...","Tawar","Laut","Payau","Gunung Berapi","Tawar"));
//        modelQuizs.add(new ModelQuiz("Stage 1 : Pengenalan","1","Jumlah dari garis-haris pada tubuh ikan nila adalah","5 - 8"," 2 - 3","5 - 10","7 - 12","7 - 12"));
//        modelQuizs.add(new ModelQuiz("Stage 1 : Pengenalan","1","Jenis kelamin ikan nila akan terlihat ketika berbobot","40 gram","50 gram","60 gram","70 gram","50 gram"));
//        modelQuizs.add(new ModelQuiz("Stage 1 : Pengenalan","1","Apa ciri-ciri dari ikan nila betina?","Kumis lebih panjang","Perut lebih besar","Warna lebih gelap","Tulang rahang melebar","Perut lebih besar"));
//        modelQuizs.add(new ModelQuiz("Stage 1 : Pengenalan","1","Berikut adalah proses tahapan yang terjadi setelah memilih indukan adalah?","Masukkan indukan ke kolam khusus","Menyiapkan kolam pijah","Telur dieram mulut betina","Pindah larva ikan yg menetas","Masukkan indukan ke kolam khusus"));

    }
}
