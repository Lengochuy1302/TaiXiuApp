package com.example.newww;

public class Nganhang {
    private String nganhang,sotaikhoan,tentaikhoan,chinhanh;


    public Nganhang() {
    }

    public Nganhang(String nganhang, String sotaikhoan, String tentaikhoan, String chinhanh) {
        this.nganhang = nganhang;
        this.sotaikhoan = sotaikhoan;
        this.tentaikhoan = tentaikhoan;
        this.chinhanh = chinhanh;
    }

    public String getNganhang() {
        return nganhang;
    }

    public void setNganhang(String nganhang) {
        this.nganhang = nganhang;
    }

    public String getSotaikhoan() {
        return sotaikhoan;
    }

    public void setSotaikhoan(String sotaikhoan) {
        this.sotaikhoan = sotaikhoan;
    }

    public String getTentaikhoan() {
        return tentaikhoan;
    }

    public void setTentaikhoan(String tentaikhoan) {
        this.tentaikhoan = tentaikhoan;
    }

    public String getChinhanh() {
        return chinhanh;
    }

    public void setChinhanh(String chinhanh) {
        this.chinhanh = chinhanh;
    }

    @Override
    public String toString() {
        return nganhang;
    }
}
