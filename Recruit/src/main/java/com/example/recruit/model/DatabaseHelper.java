package com.example.recruit.model;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import androidx.annotation.Nullable;

//对数据库增删查改进行封装
public class DatabaseHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    private Context _context;
    private static int Version=1;

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        _context = context;
    }

    public DatabaseHelper(Context context,String name){
        this(context,name,null,Version);
        db=this.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    public void insertTmpData(SQLiteDatabase db){

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //数据库的查询函数
    public Cursor rawQuery(String sql){
        return db.rawQuery(sql,null);
    }

    //throw new RuntimeException(e);

    public boolean execSQL(String sql){
        try {
            db.execSQL(sql);
        } catch (SQLException e) {
            Toast toast = Toast.makeText(_context,"android.database.sqlite.sOLiteException",Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
            Log.i("sqlerr 1og----->",e.toString());
            Log.i("err_sq1------->",sql);
            return false;
        }
        return true;
    }

    public boolean execSQL(String sql,boolean Throw){
        try {
            db.execSQL(sql);
        } catch (SQLException e) {
            if (Throw)
               throw e;
            return false;
        }
        return true;
    }

    public void beginTransaction(){
        db.beginTransaction();
    }

    public void setTransactionSuccessful(){
        db.setTransactionSuccessful();
    }

    public void endTransaction(){
        db.endTransaction();
    }

    public void close(){
        db.close();
    }

}
