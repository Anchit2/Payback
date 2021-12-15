package com.example.payback;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelperToTake  extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="totake_database";
    public static final String TABLE_NAME="totake_table";
    public static final String COL1="GIVEN_DATE";
    public static final String COL2="GIVEN_FOR";
    public static final String COL3="GIVEN_AMOUNT";

    public DatabaseHelperToTake(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (GIVEN_DATE INTEGER, GIVEN_FOR TEXT, GIVEN_AMOUNT INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table If Exists "+TABLE_NAME );
        onCreate(db);

    }
    public boolean insertdata(String date,String forr,String amount){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1,date);
        contentValues.put(COL2,forr);
        contentValues.put(COL3,amount);
        long result=db.insert(TABLE_NAME,null,contentValues);
        return result != -1;
    }

    public Cursor getalldata(){
        SQLiteDatabase db= this.getWritableDatabase();
        return db.rawQuery("Select * from " + TABLE_NAME,null);
    }
}
