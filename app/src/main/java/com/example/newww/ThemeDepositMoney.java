package com.example.newww;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ThemeDepositMoney extends AppCompatActivity {

    Spinner spinner1;
    TextView txt_matk,txt_matentk,txt_chinhanhbanks,txt_tentaikhoan;
    Button btn_xacnhannap;
    TextInputLayout edt_sotien;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    MoneyMoney mo = new MoneyMoney();
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_deposit_money);


        spinner1 = findViewById(R.id.spinner1);
        txt_matk = findViewById(R.id.txt_matk);
        txt_matentk = findViewById(R.id.txt_matentk);
        txt_chinhanhbanks = findViewById(R.id.txt_chinhanhbanks);
        btn_xacnhannap = findViewById(R.id.btn_xacnhannap);
        txt_tentaikhoan = findViewById(R.id.txt_tentaikhoan);
        edt_sotien = findViewById(R.id.edt_sotien);
        ProgressDialog pd = new ProgressDialog(ThemeDepositMoney.this);
        pd.setMessage("Đã yêu cầu xử lý");

        showInformation();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,DataBanks.getListBankss());
        spinner1.setAdapter(arrayAdapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Nganhang nganhang = (Nganhang) spinner1.getSelectedItem();
                String tennganhang = nganhang.getNganhang();
                String sotaikhoan = nganhang.getSotaikhoan();
                String tentaikhoan = nganhang.getTentaikhoan();
                String chinhanh = nganhang.getChinhanh();
                txt_matk.setText(sotaikhoan);
                txt_matentk.setText(tentaikhoan);
                txt_chinhanhbanks.setText(chinhanh);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_xacnhannap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validatenhaptien()) {
                    return;
                } else {

                    pd.show();
                    rootNode = FirebaseDatabase.getInstance();
                    reference = rootNode.getReference("nap tien");
                    //lay gia tri value
                    Nganhang nganhang = (Nganhang) spinner1.getSelectedItem();
                    String laysotaikhoan = txt_matk.getText().toString();
                    String laytentaikhoannguoinhan = txt_matentk.getText().toString();
                    String laychinhanh = txt_chinhanhbanks.getText().toString();
                    String laytennganhang = nganhang.getNganhang();
                    String laysotien = edt_sotien.getEditText().getText().toString();

                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    String email = user.getEmail();
                    String hello =  email.replace(".", ",");
                    txt_tentaikhoan.setText(hello);
                    String laytaikhoanuser = txt_tentaikhoan.getText().toString().trim();

                    DepositMoneyArrayy nh1 = new DepositMoneyArrayy(laytennganhang,laysotaikhoan,laytentaikhoannguoinhan,laychinhanh,laysotien,laytaikhoanuser);
                    //lay username lam lop cha
                    reference.child(laytaikhoanuser).setValue(nh1);


                    String payment_descccc = edt_sotien.getEditText().getText().toString().trim();
                    int sotienchuyen = new Integer(payment_descccc).intValue();
                    mo.SCORE =mo.SCORE+sotienchuyen;












                }























            }
        });






    }
    private void showInformation(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();
        txt_tentaikhoan.setText(email);

    }
    private boolean validatenhaptien() {
        String val = edt_sotien.getEditText().getText().toString();
        if (val.isEmpty()) {
            edt_sotien.setError("Field cannot be empty");
            return false;

        } else {
            edt_sotien.setError(null);
            edt_sotien.setErrorEnabled(false);
            return true;
        }
    }







}