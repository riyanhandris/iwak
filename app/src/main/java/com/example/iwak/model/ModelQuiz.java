package com.example.iwak.model;

public class ModelQuiz {
    private int id,idStage,idIkan;
    private String  soal,pilihanA,pilihanB,pilihanC,pilihanD, jawaban;

    public ModelQuiz(int id, int idStage, int idIkan, String soal, String pilihanA, String pilihanB, String pilihanC, String pilihanD, String jawaban) {
        this.id = id;
        this.idStage = idStage;
        this.idIkan = idIkan;
        this.soal = soal;
        this.pilihanA = pilihanA;
        this.pilihanB = pilihanB;
        this.pilihanC = pilihanC;
        this.pilihanD = pilihanD;
        this.jawaban = jawaban;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdStage() {
        return idStage;
    }

    public void setIdStage(int idStage) {
        this.idStage = idStage;
    }

    public int getIdIkan() {
        return idIkan;
    }

    public void setIdIkan(int idIkan) {
        this.idIkan = idIkan;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getPilihanA() {
        return pilihanA;
    }

    public void setPilihanA(String pilihanA) {
        this.pilihanA = pilihanA;
    }

    public String getPilihanB() {
        return pilihanB;
    }

    public void setPilihanB(String pilihamB) {
        this.pilihanB = pilihamB;
    }

    public String getPilihanC() {
        return pilihanC;
    }

    public void setPilihanC(String pilihanC) {
        this.pilihanC = pilihanC;
    }

    public String getPilihanD() {
        return pilihanD;
    }

    public void setPilihanD(String pilihanD) {
        this.pilihanD = pilihanD;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }
}
