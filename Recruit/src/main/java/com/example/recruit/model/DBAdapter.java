package com.example.recruit.model;

import android.app.Application;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//创建公共数据库
public class DBAdapter extends Application {
    public static final String DATABASE_NAME="BaseDatabase";
    public static final int VERSION=1;

    private static final String CREATE_APPLICANTS="create table ("
            +"ApplicantsSQL.id integer primary key autoincrement,"
            +"ApplicantsSQL.name,"
            +"ApplicantsSQL.sex,"
            +"ApplicantsSQL.tel,"
            +"ApplicantsSQL.postName,"
            +"ApplicantsSQL.passWord,"
            +"ApplicantsSQL.condition)";

    private static final String CREATE_HRS="create table hrs("
            +"id integer primary key autoincrement,"
            +"postName text,"
            +"sex text,"
            +"tel text,"
            +"name text,"
            +"passWord text,"
            +"command text,"
            +"choose text)";

    private Context context;
    private Databasehelper databasehelper;
    private SQLiteDatabase db;

    public DBAdapter(Context context) {
        this.context = context;
        this.databasehelper=new Databasehelper(this.context);
    }

    private static class Databasehelper extends SQLiteOpenHelper {
        public Databasehelper(@Nullable Context context) {
            super(context, DATABASE_NAME , null , VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_APPLICANTS);  //创建招聘者的表
            db.execSQL(CREATE_HRS); //创建HR的表
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }

    public DBAdapter open() throws SQLException
    {
        this.db=this.databasehelper.getWritableDatabase();
        return this;
    }

    public void close(){
        this.databasehelper.close();
    }
}
