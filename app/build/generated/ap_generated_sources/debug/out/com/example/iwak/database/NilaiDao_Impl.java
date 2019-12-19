package com.example.iwak.database;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.iwak.model.ModelNilai;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class NilaiDao_Impl implements NilaiDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfModelNilai;

  private final SharedSQLiteStatement __preparedStmtOfUpdateHasil;

  public NilaiDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModelNilai = new EntityInsertionAdapter<ModelNilai>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ModelNilai`(`id`,`idIkan`,`idStage`,`nilai`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ModelNilai value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getIdIkan());
        stmt.bindLong(3, value.getIdStage());
        stmt.bindLong(4, value.getNilai());
      }
    };
    this.__preparedStmtOfUpdateHasil = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE ModelNilai SET nilai=? WHERE idStage=? and idIkan=?";
        return _query;
      }
    };
  }

  @Override
  public void insertNilai(ModelNilai nilai) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfModelNilai.insert(nilai);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateHasil(int nilai, int idikan, int idstage) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateHasil.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, nilai);
      _argIndex = 2;
      _stmt.bindLong(_argIndex, idstage);
      _argIndex = 3;
      _stmt.bindLong(_argIndex, idikan);
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateHasil.release(_stmt);
    }
  }

  @Override
  public List<ModelNilai> SelectHasil() {
    final String _sql = "SELECT * FROM ModelNilai";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfIdIkan = _cursor.getColumnIndexOrThrow("idIkan");
      final int _cursorIndexOfIdStage = _cursor.getColumnIndexOrThrow("idStage");
      final int _cursorIndexOfNilai = _cursor.getColumnIndexOrThrow("nilai");
      final List<ModelNilai> _result = new ArrayList<ModelNilai>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ModelNilai _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpIdIkan;
        _tmpIdIkan = _cursor.getInt(_cursorIndexOfIdIkan);
        final int _tmpIdStage;
        _tmpIdStage = _cursor.getInt(_cursorIndexOfIdStage);
        final int _tmpNilai;
        _tmpNilai = _cursor.getInt(_cursorIndexOfNilai);
        _item = new ModelNilai(_tmpId,_tmpIdIkan,_tmpIdStage,_tmpNilai);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ModelNilai> SelectHasil(int idikan, int idstage) {
    final String _sql = "SELECT * FROM ModelNilai WHERE idStage=? and idIkan=? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, idstage);
    _argIndex = 2;
    _statement.bindLong(_argIndex, idikan);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfIdIkan = _cursor.getColumnIndexOrThrow("idIkan");
      final int _cursorIndexOfIdStage = _cursor.getColumnIndexOrThrow("idStage");
      final int _cursorIndexOfNilai = _cursor.getColumnIndexOrThrow("nilai");
      final List<ModelNilai> _result = new ArrayList<ModelNilai>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ModelNilai _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpIdIkan;
        _tmpIdIkan = _cursor.getInt(_cursorIndexOfIdIkan);
        final int _tmpIdStage;
        _tmpIdStage = _cursor.getInt(_cursorIndexOfIdStage);
        final int _tmpNilai;
        _tmpNilai = _cursor.getInt(_cursorIndexOfNilai);
        _item = new ModelNilai(_tmpId,_tmpIdIkan,_tmpIdStage,_tmpNilai);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ModelNilai> SelectHasil(int idikan) {
    final String _sql = "SELECT * FROM ModelNilai WHERE idIkan=? ORDER BY idStage";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, idikan);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfIdIkan = _cursor.getColumnIndexOrThrow("idIkan");
      final int _cursorIndexOfIdStage = _cursor.getColumnIndexOrThrow("idStage");
      final int _cursorIndexOfNilai = _cursor.getColumnIndexOrThrow("nilai");
      final List<ModelNilai> _result = new ArrayList<ModelNilai>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ModelNilai _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpIdIkan;
        _tmpIdIkan = _cursor.getInt(_cursorIndexOfIdIkan);
        final int _tmpIdStage;
        _tmpIdStage = _cursor.getInt(_cursorIndexOfIdStage);
        final int _tmpNilai;
        _tmpNilai = _cursor.getInt(_cursorIndexOfNilai);
        _item = new ModelNilai(_tmpId,_tmpIdIkan,_tmpIdStage,_tmpNilai);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ModelNilai> Selector(int idikan) {
    final String _sql = "SELECT * FROM ModelNilai WHERE idIkan=? ORDER BY idStage DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, idikan);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfIdIkan = _cursor.getColumnIndexOrThrow("idIkan");
      final int _cursorIndexOfIdStage = _cursor.getColumnIndexOrThrow("idStage");
      final int _cursorIndexOfNilai = _cursor.getColumnIndexOrThrow("nilai");
      final List<ModelNilai> _result = new ArrayList<ModelNilai>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ModelNilai _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpIdIkan;
        _tmpIdIkan = _cursor.getInt(_cursorIndexOfIdIkan);
        final int _tmpIdStage;
        _tmpIdStage = _cursor.getInt(_cursorIndexOfIdStage);
        final int _tmpNilai;
        _tmpNilai = _cursor.getInt(_cursorIndexOfNilai);
        _item = new ModelNilai(_tmpId,_tmpIdIkan,_tmpIdStage,_tmpNilai);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
