package com.example.helomyblair;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class sqilejava extends SQLiteOpenHelper {
    public sqilejava( Context context) {
        super(context, "Userdata.db", null,  1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Projectdetails(name Text primary key, mng Text, location Text, budget Text, teams Text," +
                " start Text, finish Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop table if exists Userdetails");
    }

    public Boolean insertuserdata(String name, String sex, String tribe){

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("sex", sex);
        contentValues.put("tribe", tribe);

        long result = DB.insert("Userdetails", null, contentValues);

        if (result == 1){
            return false;
        } else {
            return true;
        }
    }

    public Boolean updateuserdata(String name, String sex, String tribe){

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("sex", sex);
        contentValues.put("tribe", tribe);

        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getCount()>0) {
            long result = DB.update("Userdetails", contentValues, "name=?", new String[]{name});

            if (result == -1) {
                return false;
            } else {
                return true;
            }

        } else{
            return false;
        }
    }

    public Boolean deleteuserdata(String name, String sex, String tribe){

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("sex", sex);
        contentValues.put("tribe", tribe);

        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getCount()>0){
            long result = DB.delete("Userdetails", "name=?", new String[]{name});

            if (result == -1){
                return false;
            } else {
                return true;
            }

        }else {
            return false;
        }
    }

    public Cursor getdata(){

        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;
    }

}
