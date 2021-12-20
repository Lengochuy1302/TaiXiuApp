package com.example.newww;

public class WithdrawMoneyArray {

        String nganhang,sotaikhoanuser,tentaikhoannganhanguser,sotienrut;

    public WithdrawMoneyArray(String nganhang, String sotaikhoanuser, String tentaikhoannganhanguser, String sotienrut) {
        this.nganhang = nganhang;
        this.sotaikhoanuser = sotaikhoanuser;
        this.tentaikhoannganhanguser = tentaikhoannganhanguser;
        this.sotienrut = sotienrut;
    }

    public String getNganhang() {
        return nganhang;
    }

    public void setNganhang(String nganhang) {
        this.nganhang = nganhang;
    }

    public String getSotaikhoanuser() {
        return sotaikhoanuser;
    }

    public void setSotaikhoanuser(String sotaikhoanuser) {
        this.sotaikhoanuser = sotaikhoanuser;
    }

    public String getTentaikhoannganhanguser() {
        return tentaikhoannganhanguser;
    }

    public void setTentaikhoannganhanguser(String tentaikhoannganhanguser) {
        this.tentaikhoannganhanguser = tentaikhoannganhanguser;
    }

    public String getSotienrut() {
        return sotienrut;
    }

    public void setSotienrut(String sotienrut) {
        this.sotienrut = sotienrut;
    }
}
