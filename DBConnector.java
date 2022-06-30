package com.example.wjconstraction;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConnector extends SQLiteOpenHelper {

    public DBConnector(Context con){
        super(con, "CONSTRUCTION_WJ", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE admin (ID text primary key, NAME text, NIC text, NUMBER text, ADDRESS text, EMAIL text, PASSWORD text)");
        db.execSQL("CREATE TABLE supervisor (ID text primary key, NAME text, NIC text, NUMBER text, ADDRESS text, EMAIL text, PASSWORD text)");
        db.execSQL("CREATE TABLE con_site (SITEID text primary key, SITENAME text, LOCATION text, SUPERVISORNAME text)");
        db.execSQL("CREATE TABLE workers (WORKERID text primary key, NAME text, NIC text, PHONE text, ADDRESS text)");
        db.execSQL("CREATE TABLE attendance (WORKERID text, MONTH text, WORKDAYS text, ABSENTDAYS text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists workers");
        db.execSQL("drop Table if exists supervisor");
    }

    public Boolean updateworkerdata(String WORKERID, String NAME, String NIC, String PHONE, String ADDRESS){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", NAME);
        contentValues.put("NIC", NIC);
        contentValues.put("PHONE", PHONE);
        contentValues.put("ADDRESS", ADDRESS);
        Cursor cursor = db.rawQuery("SELECT * from workers where WORKERID = ?", new String[]{WORKERID});
        if (cursor.getCount() > 0) {
            long result = db.update("workers", contentValues, "WORKERID=?", new String[]{WORKERID});
            if (result == 1) {
                return false;
            } else {
                return true;
            }
            }else
        {
            return false;
        }
    }

    public Boolean deletedata(String WORKERID) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from workers where WORKERID = ?", new String[]{WORKERID});
        if (cursor.getCount() > 0) {
            long result = db.delete("workers", "WORKERID=?", new String[]{WORKERID});
            if (result == 1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getdata() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from workers", null);
        return cursor;
    }

    public Boolean updatesupervisordata(String ID, String NAME, String NIC, String NUMBER, String ADDRESS, String EMAIL, String PASSWORD){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", NAME);
        contentValues.put("NIC", NIC);
        contentValues.put("NUMBER", NUMBER);
        contentValues.put("ADDRESS", ADDRESS);
        contentValues.put("EMAIL", EMAIL);
        contentValues.put("PASSWORD", PASSWORD);
        Cursor cursor = db.rawQuery("SELECT * from supervisor where ID = ?", new String[]{ID});
        if (cursor.getCount() > 0) {
            long result = db.update("supervisor", contentValues, "ID=?", new String[]{ID});
            if (result == 1) {
                return false;
            } else {
                return true;
            }
        }else
        {
            return false;
        }
    }

    public Boolean deletesupdata(String ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from supervisor where ID = ?", new String[]{ID});
        if (cursor.getCount() > 0) {
            long result = db.delete("supervisor", "ID=?", new String[]{ID});
            if (result == 1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getsup() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from supervisor", null);
        return cursor;
    }
}
