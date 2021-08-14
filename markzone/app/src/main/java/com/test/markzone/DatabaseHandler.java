package com.test.markzone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "MARKS_RECORD";
    public static final String TABLE_NAME = "Marks";
    private static final String COL_1 = "NAME";
    private static final String COL_2 = "SSC";
    private static final String COL_3 = "CG";
    private static final String COL_4 = "WEB";
    private static final String COL_5 = "OOMD";
    private static final String COL_6 = "ELECTIVE";;

    public DatabaseHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int DATABASE_VERSION) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " +TABLE_NAME+ "( NAME TEXT PRIMARY KEY , SSC TEXT , CG TEXT , WEB TEXT , OOMD TEXT , ELECTIVE TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Boolean insertuserdata(String name, String ssc, String cg, String web, String oomd, String elective)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, name);
        contentValues.put(COL_2, ssc);
        contentValues.put(COL_3, cg);
        contentValues.put(COL_4, web);
        contentValues.put(COL_5, oomd);
        contentValues.put(COL_6, elective);

        long result=db.insert(TABLE_NAME , null , contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }


    public Boolean deletedata (String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Marks where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = db.delete(TABLE_NAME, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Cursor getData(String name){

        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " +TABLE_NAME+ " WHERE NAME = '" +name+"'";
        Cursor cursor = db.rawQuery(query , null);

        return cursor;
    }

    public boolean updateData(String name , String ssc , String cg , String web , String oomd , String elective){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1 , name);
        contentValues.put(COL_2 , ssc);
        contentValues.put(COL_3 , cg);
        contentValues.put(COL_4 , web);
        contentValues.put(COL_5 , oomd);
        contentValues.put(COL_6 , elective);
        Cursor cursor = db.rawQuery("Select * from Marks where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = db.update(TABLE_NAME , contentValues , "NAME=?" , new  String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }}



    public String databaseToString() {
        String DBString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex(COL_1)) != null) {
                DBString += String.format("%11.11s", c.getString(c.getColumnIndex(COL_1)));
                DBString += "  ";

                DBString += (c.getString(c.getColumnIndex(COL_2)) + " ");
                DBString+="\t\t";
                DBString += (c.getString(c.getColumnIndex(COL_3)) + " ");
                DBString+="\t\t";
                DBString += (c.getString(c.getColumnIndex(COL_4)) + " ");
                DBString+="\t\t\t";
                DBString += (c.getString(c.getColumnIndex(COL_5)) +  "");
                DBString+="\t\t\t ";
                DBString += (c.getString(c.getColumnIndex(COL_6)) + " ");
                DBString += "\n\n";

            }
            c.moveToNext();
        }
        return DBString;
    }









}
