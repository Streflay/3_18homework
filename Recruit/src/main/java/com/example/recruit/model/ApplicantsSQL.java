package com.example.recruit.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.sql.DatabaseMetaData;


public class ApplicantsSQL{

    public static final String id="_id";
    public static final String name="名字";
    public static final String sex="性别";
    public static final String tel="电话号码";
    public static final String postName="理想岗位";
    public static final String passWord="密码";
    public static final String condition="简历情况";

    private static final String TAG="ApplicantsSQL";
    //private DatabaseHelper aDbHelper;
    private SQLiteDatabase aDb;

    static final String SQLLITE_TABLE="ApplicantsTable";
    private Context aCt;

//    private static class DatabaseHelper extends SQLiteOpenHelper{
//
//        public DatabaseHelper(@Nullable Context context) {
//            super(context, DBAdapter.DATABASE_NAME, null, DBAdapter.VERSION);
//        }
//
//        @Override
//        public void onCreate(SQLiteDatabase sqLiteDatabase) {
//
//        }
//
//        @Override
//        public void onUpgrade(SQLiteDatabase db, int olderVersion, int newVersion) {
//            Log.w(TAG,"Upgrading database from version "+olderVersion+" to "
//            +newVersion+",which will destroy all older data");
//            db.execSQL("drop table if exists "+SQLLITE_TABLE);
//            onCreate(db);
//        }
//    }
//
//    public ApplicantsSQL(Context aCt) {
//        this.aCt = aCt;
//    }
//
//    public ApplicantsSQL open() throws SQLException{
//        aDbHelper=new DatabaseHelper(aCt);
//        aDb=aDbHelper.getWritableDatabase();
//        return this;
//    }
//
//    public void close(){
//        if (aDbHelper!=null){
//            aDbHelper.close();
//        }
//    }
//
////    public static final String name="名字";
////    public static final String sex="性别";
////    public static final String tel="电话号码";
////    public static final String postName="理想岗位";
////    public static final String passWord="密码";
////    public static final String condition="简历情况";
//
//    //创建学生表字段
//    public long createStudent(String Name,String Sex,String Tel,String PostName,String PassWord,String Condition){
//        long createResult=0;
//        ContentValues initValues=new ContentValues();
//        initValues.put(name,Name);
//        initValues.put(sex,Sex);
//        initValues.put(tel,Tel);
//        initValues.put(postName,PostName);
//        initValues.put(passWord,PassWord);
//        initValues.put(condition,Condition);
//        try {
//            createResult=aDb.insert(SQLLITE_TABLE,null,initValues);
//        } catch (Exception e){
//
//        }
//        return createResult;
//    }
//
//

}
