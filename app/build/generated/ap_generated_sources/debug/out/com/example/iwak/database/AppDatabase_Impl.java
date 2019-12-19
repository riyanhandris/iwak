package com.example.iwak.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class AppDatabase_Impl extends AppDatabase {
  private volatile NilaiDao _nilaiDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ModelNilai` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `idIkan` INTEGER NOT NULL, `idStage` INTEGER NOT NULL, `nilai` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"6662b01b03f2ef3377f7596190d82c3d\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `ModelNilai`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsModelNilai = new HashMap<String, TableInfo.Column>(4);
        _columnsModelNilai.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsModelNilai.put("idIkan", new TableInfo.Column("idIkan", "INTEGER", true, 0));
        _columnsModelNilai.put("idStage", new TableInfo.Column("idStage", "INTEGER", true, 0));
        _columnsModelNilai.put("nilai", new TableInfo.Column("nilai", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysModelNilai = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesModelNilai = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoModelNilai = new TableInfo("ModelNilai", _columnsModelNilai, _foreignKeysModelNilai, _indicesModelNilai);
        final TableInfo _existingModelNilai = TableInfo.read(_db, "ModelNilai");
        if (! _infoModelNilai.equals(_existingModelNilai)) {
          throw new IllegalStateException("Migration didn't properly handle ModelNilai(com.example.iwak.model.ModelNilai).\n"
                  + " Expected:\n" + _infoModelNilai + "\n"
                  + " Found:\n" + _existingModelNilai);
        }
      }
    }, "6662b01b03f2ef3377f7596190d82c3d", "bab2ecfa2d48876ad919e8f653b2e78b");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "ModelNilai");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `ModelNilai`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public NilaiDao nilaiDao() {
    if (_nilaiDao != null) {
      return _nilaiDao;
    } else {
      synchronized(this) {
        if(_nilaiDao == null) {
          _nilaiDao = new NilaiDao_Impl(this);
        }
        return _nilaiDao;
      }
    }
  }
}
