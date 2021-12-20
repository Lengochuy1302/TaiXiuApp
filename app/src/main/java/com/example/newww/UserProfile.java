package com.example.newww;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.DecimalFormat;

public class UserProfile extends AppCompatActivity {
    MoneyMoney mo = new MoneyMoney();
    TextInputLayout email, password;
    TextView usernamelabel, fullnamelabel, sum_money;
    EditText payment_desc, booking_desc;
    ImageView themeDepositMoney,widhdrawmoney;
    Button btn_update;
    TextInputLayout ChangePassword, confirmChangePassword;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);


        //Hooks
        progressDialog = new ProgressDialog(this);
        ChangePassword = findViewById(R.id.ChangePassword);



        email = findViewById(R.id.email_profile);

        password = findViewById(R.id.password_profile);
        usernamelabel = findViewById(R.id.usernamelabel);
        sum_money = findViewById(R.id.sum_money);
        themeDepositMoney = findViewById((R.id.themeDepositMoney));
        btn_update = findViewById(R.id.btn_update);
        widhdrawmoney = findViewById(R.id.widhdrawmoney);




        email.setEnabled(false);
        sum_money.setText(mo.tien + "VND");

        showAllUserData();


        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strCurrentPassword = password.getEditText().getText().toString().trim();
                String strNewPassword = ChangePassword.getEditText().getText().toString().trim();
                if (TextUtils.isEmpty(strCurrentPassword)) {
                    Toast.makeText(getApplication(), "Nhap Pass Hien Tai...", Toast.LENGTH_SHORT).show();
                    return;
                }

                OnclickChangePassword(strCurrentPassword, strNewPassword);


//                  DecimalFormat formatmoney = new DecimalFormat("###,###,###");
//                  String payment_descccc = payment_desc.getText().toString().trim();
//                  int sonhapcuoc = new Integer(payment_descccc).intValue();
//                  MoneyMoney.SCORE = MoneyMoney.SCORE+sonhapcuoc;
//                  String strtien = String.valueOf(formatmoney.format(MoneyMoney.SCORE));
//                  sum_money.setText(strtien+"VND");
//                  payment_desc.setText("");

//                  String ruttien = booking_desc.getText().toString().trim();
//                  int sotienrut = new Integer(ruttien).intValue();
//                  MoneyMoney.SCORE = MoneyMoney.SCORE-sotienrut;
//                  String strruttien = String.valueOf(MoneyMoney.SCORE);
//                  sum_money.setText(strruttien);


            }


        });

        widhdrawmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent drawmoney = new Intent(UserProfile.this, Withdraw_Money.class);
                startActivity(drawmoney);
            }
        });



        themeDepositMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent changethemeDeposit = new Intent(UserProfile.this, ThemeDepositMoney.class);
                startActivity(changethemeDeposit);
            }
        });




    }

    private void OnclickChangePassword(String strCurrentPassword, String strNewPassword) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
// Get auth credentials from the user for re-authentication. The example below shows
// email and password credentials but there are multiple possible providers,
// such as GoogleAuthProvider or FacebookAuthProvider.
        AuthCredential credential = EmailAuthProvider
                .getCredential(user.getEmail(), strCurrentPassword);

// Prompt the user to re-provide their sign-in credentials
        user.reauthenticate(credential).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

                //successfully authentication , begin update
                user.updatePassword(strNewPassword).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        //password update
                        Toast.makeText(getApplication(), "Password Update ....", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplication(), "" + e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        //Authentication failed, show reason
                        Toast.makeText(getApplication(), "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


    }

    private void showAllUserData() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            return;

        }

        email.getEditText().setText(user.getEmail());


    }




}