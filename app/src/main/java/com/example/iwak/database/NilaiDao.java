package com.example.iwak.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.iwak.model.ModelNilai;

import java.util.List;
@Dao
public interface NilaiDao {
    @Insert
    void insertNilai(ModelNilai nilai);
    @Query("SELECT * FROM ModelNilai")
    List<ModelNilai> SelectHasil();
    @Query("SELECT * FROM ModelNilai WHERE idStage=:idstage and idIkan=:idikan LIMIT 1")
    List<ModelNilai> SelectHasil(int idikan, int idstage);
    @Query("SELECT * FROM ModelNilai WHERE idIkan=:idikan ORDER BY idStage")
    List<ModelNilai> SelectHasil(int idikan);
    @Query("UPDATE ModelNilai SET nilai=:nilai WHERE idStage=:idstage and idIkan=:idikan")
    void updateHasil(int nilai,int idikan, int idstage);

    @Query("SELECT * FROM ModelNilai WHERE idIkan=:idikan ORDER BY idStage DESC LIMIT 1")
    List<ModelNilai> Selector (int idikan);
}
