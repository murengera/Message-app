package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class MyDB extends SQLiteOpenHelper {

    public  static final String DATABASE_NAME="register.db";
    public  static final String TABLENAME="register";
    public static final String COL_1="id";
    public static final String COL_2="firstname";
    public static final String COL_3="lastname";
    public static final String COL_4="username";
    public static final String COL_5="password";




    public MyDB( Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLENAME+"(id INTEGER PRIMARY KEY AUTOINCREMENT,firstname TEXT,lastname TEXT,username TEXT,password TEXT)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLENAME);
        onCreate(db);

    }


    public Cursor getdata(){

        SQLiteDatabase db=this.getWritableDatabase();

        Cursor res=db.rawQuery("SELECT* FROM "+TABLENAME,null);
        return res;

    }





    public  boolean  insert( String nameone,String namelast,String usernamed,String passwored)

    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(MyDB.COL_2,nameone);
        contentValues.put(MyDB.COL_3,namelast);
        contentValues.put(MyDB.COL_4,usernamed);
        contentValues.put(MyDB.COL_5,passwored);
          long result=db.insert(TABLENAME,null,contentValues);
          if (result==-1)
          {
              return false;
          }
          else
          {

              return true;

          }


    }





}
