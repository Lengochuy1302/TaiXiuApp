package com.example.newww;

import java.util.ArrayList;
import java.util.List;

public class DataBanks {


    public static List<Nganhang> getListBankss(){
        List<Nganhang> banksList = new ArrayList<>();

        Nganhang BanksVietinbank = new Nganhang();
        BanksVietinbank.setNganhang("VietinBank");
        BanksVietinbank.setSotaikhoan("123456789");
        BanksVietinbank.setTentaikhoan("Nguyễn Văn A");
        BanksVietinbank.setChinhanh("Sài Gòn");
        banksList.add(BanksVietinbank);



        Nganhang BanksACB = new Nganhang();
        BanksACB.setNganhang("ACB");
        BanksACB.setSotaikhoan("987654321");
        BanksACB.setTentaikhoan("Nguyễn Văn B");
        BanksACB.setChinhanh("Hà Nội");
        banksList.add(BanksACB);

        Nganhang BanksVietcombank = new Nganhang();
        BanksVietcombank.setNganhang("Vietcombank");
        BanksVietcombank.setSotaikhoan("456789123");
        BanksVietcombank.setTentaikhoan("Nguyễn Văn C");
        BanksVietcombank.setChinhanh("Đã Nẵng ");
        banksList.add(BanksVietcombank);

        Nganhang BanksBIDV = new Nganhang();
        BanksBIDV.setNganhang("BIDV");
        BanksBIDV.setSotaikhoan("789123456");
        BanksBIDV.setTentaikhoan("Nguyễn Văn D");
        BanksBIDV.setChinhanh("Nha Trang");
        banksList.add(BanksBIDV);

        Nganhang BanksSacombank = new Nganhang();
        BanksSacombank.setNganhang("Sacombank");
        BanksSacombank.setSotaikhoan("789123456");
        BanksSacombank.setTentaikhoan("Nguyễn Văn E");
        BanksSacombank.setChinhanh("Phan Thiết");
        banksList.add(BanksSacombank);

        Nganhang BanksTechcombank = new Nganhang();
        BanksTechcombank.setNganhang("TechcomBank");
        BanksTechcombank.setSotaikhoan("789123456");
        BanksTechcombank.setTentaikhoan("Nguyễn Văn F");
        BanksTechcombank.setChinhanh("Phan Thiết");
        banksList.add(BanksTechcombank);

        Nganhang BanksEximbank = new Nganhang();
        BanksTechcombank.setNganhang("Eximbank");
        BanksEximbank.setSotaikhoan("789123456");
        BanksEximbank.setTentaikhoan("Nguyễn Văn G");
        BanksEximbank.setChinhanh("Tiền Giang");
        banksList.add(BanksEximbank);


        return banksList;
    }




}
