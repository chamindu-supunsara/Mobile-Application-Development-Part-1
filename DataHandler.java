package com.example.wjconstraction;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DataHandler {
    private Context con;
    private DBConnector dbCon;
    private SQLiteDatabase db;

    public DataHandler(Context con){
        this.con = con;
    }

    public void openDB(){
        this.dbCon = new DBConnector(con);
        this.db = dbCon.getWritableDatabase();
    }

    public boolean checkForID(String id, String password) {
        Cursor cursor = db.rawQuery("SELECT * FROM  admin WHERE ID=? and PASSWORD=?", new String[]{id, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkForSupID(String id, String password) {
        Cursor cursor = db.rawQuery("SELECT * FROM  supervisor WHERE ID=? and PASSWORD=?", new String[]{id, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Admin> getAllAdmin(){

        return null;
    }

    public void registerAdmin(Admin admin){
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", admin.getId());
        contentValues.put("NAME", admin.getName());
        contentValues.put("NIC", admin.getNic());
        contentValues.put("NUMBER", admin.getNumber());
        contentValues.put("ADDRESS", admin.getAddress());
        contentValues.put("EMAIL", admin.getEmail());
        contentValues.put("PASSWORD", admin.getPassword());
        db.insert("admin", null, contentValues);
    }

    public void registerSupervisor(Supervisor supervisor){
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", supervisor.getId());
        contentValues.put("NAME", supervisor.getName());
        contentValues.put("NIC", supervisor.getNic());
        contentValues.put("NUMBER", supervisor.getNumber());
        contentValues.put("ADDRESS", supervisor.getAddress());
        contentValues.put("EMAIL", supervisor.getEmail());
        contentValues.put("PASSWORD", supervisor.getPassword());
        db.insert("supervisor", null, contentValues);
    }

    public void addContractionSite(ContractionSite contractionSite) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("SITEID", contractionSite.getSiteid());
        contentValues.put("SITENAME", contractionSite.getSitename());
        contentValues.put("LOCATION", contractionSite.getLocation());
        contentValues.put("SUPERVISORNAME", contractionSite.getSupervisorname());
        db.insert("con_site", null, contentValues);
    }

    public void addWorker(Worker worker) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("WORKERID", worker.getId());
        contentValues.put("NAME", worker.getName());
        contentValues.put("NIC", worker.getNic());
        contentValues.put("PHONE", worker.getPhone());
        contentValues.put("ADDRESS", worker.getAddress());
        db.insert("workers", null, contentValues);
    }

    public void markworkersattandance (MainAttandance mainAttandance){

        ContentValues contentValues = new ContentValues();
        contentValues.put("WORKERID", mainAttandance.getMarkworkerid());
        contentValues.put("MONTH", mainAttandance.getMarkmonth());
        contentValues.put("WORKDAYS", mainAttandance.getMarkworkdays());
        contentValues.put("ABSENTDAYS", mainAttandance.getMarkabsentdays());
        db.insert("attendance", null, contentValues);
    }

}
