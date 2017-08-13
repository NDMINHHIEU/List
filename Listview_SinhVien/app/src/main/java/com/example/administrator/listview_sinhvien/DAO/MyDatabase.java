package com.example.administrator.listview_sinhvien.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.Image;

/**
 * Created by Administrator on 8/13/2017.
 */

public class MyDatabase extends SQLiteOpenHelper {

    //Ten csdl
    public static final String DB_Name = "QLSinhVien";
    public static final int phienban = 1;

    //Ten Bang va thuoc tinh
    public static final String Table_SV_name = "Sinhvien";
    public static final String MSSV = "MSSV";
    public static final String Ten = "Ten";
    public static final String Lop = "Lop";
    public static final String AnhDaiDien = "Avatar";

    public MyDatabase(Context context) {
        super(context, DB_Name, null, phienban);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " + Table_SV_name + " (" + MSSV + " varchar(12) primary key, "
                + Ten + " varchar, " + Lop + " varchar, " + AnhDaiDien + " Text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.rawQuery("drop table if exists " + Table_SV_name,null);
        onCreate(db);
    }
}
