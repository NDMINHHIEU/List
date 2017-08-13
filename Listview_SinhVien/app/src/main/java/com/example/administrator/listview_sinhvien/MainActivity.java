package com.example.administrator.listview_sinhvien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.listview_sinhvien.DAO.StudentDAO;
import com.example.administrator.listview_sinhvien.DTO.Student;
import com.example.administrator.listview_sinhvien.DTO.StudentCustomAddapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edMSSV, edTen, edLop;
    ListView lvDanhSach;
    Button btLuu;
    Student student;
    String AnhTamThoi = "";
    StudentDAO studentDAO;
    List<Student> list;
    StudentCustomAddapter addapter;

    public void Load_student(){
        list = studentDAO.Get_List();
        addapter = new StudentCustomAddapter(this,R.layout.row_layout,list);
        lvDanhSach.setAdapter(addapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentDAO = new StudentDAO(getApplicationContext());


        Load_student();
        edMSSV = (EditText) findViewById(R.id.editMSSV);
        edTen = (EditText) findViewById(R.id.editTen);
        edLop = (EditText) findViewById(R.id.editLop);
        lvDanhSach = (ListView) findViewById(R.id.lvSinhVien);
        btLuu = (Button) findViewById(R.id.btLuu);

        btLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    student = new Student(edMSSV.getText().toString(),edTen.getText().toString(),
                            edLop.getText().toString(), AnhTamThoi);
                    studentDAO.Add_Student(student);
                    Load_student();
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Lỗi rồi =( ...",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
