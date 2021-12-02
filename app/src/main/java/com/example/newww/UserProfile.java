package com.example.newww;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.DecimalFormat;

public class UserProfile extends AppCompatActivity {
        TextInputLayout email,password;
        TextView usernamelabel,fullnamelabel,sum_money;
        EditText payment_desc,booking_desc;
        Button btn_update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        //Hooks

        email = findViewById(R.id.email_profile);

        password = findViewById(R.id.password_profile);
        usernamelabel = findViewById(R.id.usernamelabel);
        sum_money = findViewById(R.id.sum_money);
        payment_desc = findViewById(R.id.payment_desc);
        booking_desc = findViewById(R.id.booking_desc);
        btn_update = findViewById(R.id.btn_update);


        MoneyMoney mo = new MoneyMoney();
        sum_money.setText(mo.tien+"VND");

        email.setEnabled(false);
        password.setEnabled(false);

          showAllUserData();



          btn_update.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                try {
                    DecimalFormat formatmoney = new DecimalFormat("###,###,###");
                    String payment_descccc = payment_desc.getText().toString().trim();
                    int sonhapcuoc = new Integer(payment_descccc).intValue();
                    MoneyMoney.SCORE = MoneyMoney.SCORE+sonhapcuoc;
                    String strtien = String.valueOf(formatmoney.format(MoneyMoney.SCORE));
                    sum_money.setText(strtien+"VND");
                    payment_desc.setText("");

                }catch (Exception ex){
                    Toast.makeText(getApplication(),"Nhập tiền bạn cần rút",Toast.LENGTH_SHORT).show();
                }



//                  String ruttien = booking_desc.getText().toString().trim();
//                  int sotienrut = new Integer(ruttien).intValue();
//                  MoneyMoney.SCORE = MoneyMoney.SCORE-sotienrut;
//                  String strruttien = String.valueOf(MoneyMoney.SCORE);
//                  sum_money.setText(strruttien);

              }



          });





    }

    private void showAllUserData() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user==null){
            return;

        }

        email.getEditText().setText(user.getEmail());






    }
//    private void showAllUserData() {
//        Intent intent = getIntent();
//        String user_username = intent.getStringExtra("username");
//        String user_name = intent.getStringExtra("fullname");
//        String user_email = intent.getStringExtra("email");
//        String user_phone = intent.getStringExtra("phone");
//        String user_password = intent.getStringExtra("password");
//
//            fullnamelabel.setText(user_username);
//            usernamelabel.setText(user_name);
//            fullName.getEditText().setText(user_name);
//            email.getEditText().setText(user_email);
//            phone.getEditText().setText(user_phone);
//            password.getEditText().setText(user_password);
//
//    }


}