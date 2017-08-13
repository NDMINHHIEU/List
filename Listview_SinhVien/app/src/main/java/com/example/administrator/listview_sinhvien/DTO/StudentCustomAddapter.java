package com.example.administrator.listview_sinhvien.DTO;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.listview_sinhvien.DAO.MyDatabase;
import com.example.administrator.listview_sinhvien.R;

import java.util.List;

/**
 * Created by Administrator on 8/13/2017.
 */

public class StudentCustomAddapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private List<Student> objects;
    public StudentCustomAddapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View row = layoutInflater.inflate(R.layout.row_layout,parent);
        TextView txtMssv = (TextView) row.findViewById(R.id.txtMSSVrow);
        TextView txtTen = (TextView) row.findViewById(R.id.txtTenrow);
        TextView txtLop = (TextView) row.findViewById(R.id.txtLoprow);
        ImageView avatar = (ImageView) row.findViewById(R.id.imgAva);
        Student student = objects.get(position);
        txtMssv.setText(student.getMssv());
        txtTen.setText(student.getTen());
        txtLop.setText(student.getLop());
        avatar.setImageResource(Integer.parseInt(MyDatabase.AnhDaiDien));

        return row;
    }
}
