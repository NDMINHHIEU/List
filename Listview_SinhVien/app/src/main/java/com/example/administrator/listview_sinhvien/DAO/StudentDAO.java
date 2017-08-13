package com.example.administrator.listview_sinhvien.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.listview_sinhvien.DTO.Student;

import java.util.ArrayList;
import java.util.List;

import static com.example.administrator.listview_sinhvien.DAO.MyDatabase.AnhDaiDien;
import static com.example.administrator.listview_sinhvien.DAO.MyDatabase.DB_Name;
import static com.example.administrator.listview_sinhvien.DAO.MyDatabase.Lop;
import static com.example.administrator.listview_sinhvien.DAO.MyDatabase.MSSV;
import static com.example.administrator.listview_sinhvien.DAO.MyDatabase.Table_SV_name;
import static com.example.administrator.listview_sinhvien.DAO.MyDatabase.Ten;

/**
 * Created by Administrator on 8/13/2017.
 */

public class StudentDAO {
    private Context context;
    SQLiteDatabase db;
    MyDatabase myDatabase;

    public StudentDAO(Context context){
        this.context = context;
        myDatabase = new MyDatabase(context);
    }

    public void Add_Student(Student student){
        db = myDatabase.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(MSSV,student.getMssv());
            contentValues.put(Ten, student.getTen());
            contentValues.put(Lop,student.getLop());
            contentValues.put(AnhDaiDien, "@drawable/ava");
            long i = db.insert(Table_SV_name,null,contentValues);
            if(i != -1) Toast.makeText(context,"Thêm thành công 1 sinh viên!!",Toast.LENGTH_SHORT).show();

        }catch (Exception ex){
            Toast.makeText(context, "Lỗi không thêm được vào cơ sở dữ liệu ...",Toast.LENGTH_SHORT).show();
        }
    }

    public List<Student> Get_List(){
        List<Student> list = new ArrayList<>();
        try {
            String sql = "select * from " + Table_SV_name;
            Cursor cursor = db.rawQuery(sql,null);
            cursor.moveToPosition(-1);
            while(cursor.moveToNext()){
                Student student = new Student(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
                list.add(student);
            }
        }
        catch (Exception e)
        {
            Log.d(DB_Name,"Lỗi!!!");
        }
        finally {
            return list;
        }
    }
}
