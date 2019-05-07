package com.example.macomputer.databasesql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private  static final String DATABASE_NAME="company";
    private static final int DATABASE_VERSION=1;
    private static final String STORE_TABLE="stores";
    private static final String KEY_ID="id";
    private static final String KEY_NAME="name";
    private static final String KEY_JOB="job";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createStatment="CREATE TABLE "+STORE_TABLE+"("+
         KEY_ID+" INTEGER PRIMARY KEY, "+
         KEY_NAME+" VARCHAR(100), "+
         KEY_JOB+" VARCHAR(100))";
        db.execSQL(createStatment);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropStatement="DROP TABLE IF EXISTS "+STORE_TABLE;
        db.execSQL(dropStatement);
        onCreate(db);
    }
    public void addStore(Strore strore){
        SQLiteDatabase dp=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_ID,strore.getId());
        values.put(KEY_NAME,strore.getName());
        values.put(KEY_JOB,strore.getJob());
        dp.insert(STORE_TABLE,null,values);
        dp.close();
    }
    public ArrayList<Strore> getAllStores(){
        ArrayList<Strore> allStores=new ArrayList<>();
        SQLiteDatabase dp=getReadableDatabase();
       Cursor cursor = dp.rawQuery("SELECT * FROM "+STORE_TABLE,null);
       while (cursor.moveToNext()){
           Strore strore=new Strore(
           cursor.getInt(0),
           cursor.getString(1),
           cursor.getString(2));
           allStores.add(strore);
       }
       return allStores;
    }
}
