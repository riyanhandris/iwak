package com.example.iwak.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class ModelNilai {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private int idIkan;
    @ColumnInfo
    private int idStage;
    @ColumnInfo
    private int nilai;

    public ModelNilai(int id, int idIkan, int idStage, int nilai) {
        this.id = id;
        this.idIkan = idIkan;
        this.idStage = idStage;
        this.nilai = nilai;
    }
    @Ignore
    public ModelNilai(int idIkan, int idStage, int nilai) {
        this.idIkan = idIkan;
        this.idStage = idStage;
        this.nilai = nilai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdIkan() {
        return idIkan;
    }

    public void setIdIkan(int idIkan) {
        this.idIkan = idIkan;
    }

    public int getIdStage() {
        return idStage;
    }

    public void setIdStage(int idStage) {
        this.idStage = idStage;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }
}
