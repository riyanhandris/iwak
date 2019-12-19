package com.example.iwak.database;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.iwak.model.ModelNilai;

@Database(entities = ModelNilai.class,version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
public abstract NilaiDao nilaiDao();
}
