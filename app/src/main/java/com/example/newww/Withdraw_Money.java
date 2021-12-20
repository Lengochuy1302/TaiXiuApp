package com.example.newww;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;

public class Withdraw_Money extends AppCompatActivity {

    TextView currentmoney,txt_taikhoan;
    TextInputLayout edt_sotaikhoan,edt_tentaikhoan,edt_sotienrut;
    Button btn_ruttien;
    Spinner spinner2;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    ProgressDialog pd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw_money);
        MoneyMoney mo = new MoneyMoney();
        spinner2 = findViewById(R.id.spinner2);
        btn_ruttien = findViewById(R.id.btn_ruttien);
        currentmoney = findViewById(R.id.currentmoney);
        edt_sotaikhoan = findViewById(R.id.edt_sotaikhoan);
        edt_tentaikhoan = findViewById(R.id.edt_tentaikhoan);
        edt_sotienrut = findViewById(R.id.edt_sotienrut);
        txt_taikhoan = findViewById(R.id.txt_taikhoan);
        currentmoney.setText(mo.tien+"VND");
        ProgressDialog pd = new ProgressDialog(Withdraw_Money.this);
        pd.setMessage("Đã yêu cầu xử lý");
        ArrayAdapter arrayAdapter1 = new ArrayAdapter(getApplication(),R.layout.support_simple_spinner_dropdown_item,DataBanks.getListBankss());
        spinner2.setAdapter(arrayAdapter1);

        showInformationUser();



        btn_ruttien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!validatenhapsotk() | !validatetentk() |!validatesotienrut()) {
                    return;
                } else {
                    pd.show();
                    DecimalFormat formatmoney = new DecimalFormat("###,###,###");
                    String strcurrentmoney = edt_sotienrut.getEditText().getText().toString().trim();
                    int valuecurrenttien = new Integer(strcurrentmoney).intValue();
                    mo.SCORE =  mo.SCORE - valuecurrenttien;

                    String tien = String.valueOf(formatmoney.format(mo.SCORE));
                    currentmoney.setText( tien + " VND");

                    rootNode = FirebaseDatabase.getInstance();
                    reference = rootNode.getReference("Rut Tien");
                    //lay gia tri value
                    Nganhang nganhang = (Nganhang) spinner2.getSelectedItem();

                    String laysotaikhoanuser = edt_sotaikhoan.getEditText().getText().toString();
                    String laytentaikhoannganhanguser = edt_tentaikhoan.getEditText().getText().toString();
                    String laytennganhang = nganhang.getNganhang();
                    String laysotienrut = edt_sotienrut.getEditText().getText().toString();

                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    String email = user.getEmail();
                    String hello =  email.replace(".", ",");
                    txt_taikhoan.setText(hello);
                    String laytaikhoanuser = txt_taikhoan.getText().toString().trim();

                    WithdrawMoneyArray nh1 = new WithdrawMoneyArray(laytennganhang,laysotaikhoanuser,laytentaikhoannganhanguser,laysotienrut);
                    //lay username lam lop cha
                    reference.child(laytaikhoanuser).setValue(nh1);




                }

















            }
        });









        }
    private void showInformationUser(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();
        txt_taikhoan.setText("Tài Khoản: "+email);

    }

    private boolean validatenhapsotk() {
        String val = edt_sotaikhoan.getEditText().getText().toString();
        if (val.isEmpty()) {
            edt_sotaikhoan.setError("Field cannot be empty");
            return false;

        } else {
            edt_sotaikhoan.setError(null);
            edt_sotaikhoan.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validatetentk() {
        String val = edt_tentaikhoan.getEditText().getText().toString();
        if (val.isEmpty()) {
            edt_tentaikhoan.setError("Field cannot be empty");
            return false;

        } else {
            edt_tentaikhoan.setError(null);
            edt_tentaikhoan.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validatesotienrut() {
        String val = edt_sotienrut.getEditText().getText().toString();
        if (val.isEmpty()) {
            edt_sotienrut.setError("Field cannot be empty");
            return false;

        } else {
            edt_sotienrut.setError(null);
            edt_sotienrut.setErrorEnabled(false);
            return true;
        }




    }








}