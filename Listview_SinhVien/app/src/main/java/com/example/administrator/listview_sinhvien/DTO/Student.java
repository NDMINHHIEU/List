package com.example.administrator.listview_sinhvien.DTO;

import android.media.Image;

/**
 * Created by Administrator on 8/13/2017.
 */
// kieu du lieu Student
public class Student {
    private String mssv;
    private String ten;
    private String lop;
    private String avatar;

    public Student(){
        this.mssv = "";
        this.ten = "";
        this.lop = "";
        this.avatar = null;
    }

    public Student(String id, String name, String lopc, String Ava){
        this.mssv = id;
        this.ten = name;
        this.lop = lopc;
        this.avatar = Ava;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
